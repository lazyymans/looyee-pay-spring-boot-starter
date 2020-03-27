package com.looyee.wxpay.service.impl;

import com.looyee.wxpay.service.RequsetService;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.thoughtworks.xstream.io.xml.XmlFriendlyNameCoder;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.conn.ConnectionPoolTimeoutException;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.SSLContexts;
import org.apache.http.util.EntityUtils;

import javax.net.ssl.SSLContext;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.SocketTimeoutException;
import java.security.*;
import java.security.cert.CertificateException;

@Slf4j
@Setter
@Getter
public class RequsetServiceImpl implements RequsetService {

    // 表示请求器是否已经做了初始化工作
    private boolean hasInit = false;
    // 连接超时时间，默认10秒
    private int socketTimeout = 10000;
    // 传输超时时间，默认30秒
    private int connectTimeout = 30000;
    // 请求器的配置
    private RequestConfig requestConfig = null;
    // 解决XStream对出现双下划线的bug
    private static final XStream xStreamForRequestPostData = new XStream(new DomDriver("UTF-8", new XmlFriendlyNameCoder("-_", "_")));

    /**
     * 初始化httpClient
     */
    private void initRequestConfig() {
        // 根据默认超时限制初始化requestConfig
        if (requestConfig == null) {
            requestConfig = RequestConfig.custom().setSocketTimeout(socketTimeout).setConnectTimeout(connectTimeout).build();
        }
        hasInit = true;
    }

    /**
     * 初始化SSL，如果存在证书文件，这里可能回出现线程安全问题
     *
     * @return
     */
    private SSLConnectionSocketFactory initSSL(File cert, String certPassword) {
        SSLConnectionSocketFactory sslsf = null;
        try {
            KeyStore keyStore = KeyStore.getInstance("PKCS12");
            FileInputStream inStream = new FileInputStream(cert);
            try {
                keyStore.load(inStream, certPassword.toCharArray());// 设置证书密码
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                inStream.close();
            }
            // Trust own CA and all self-signed certs
            SSLContext sslcontext = SSLContexts.custom().loadKeyMaterial(keyStore, certPassword.toCharArray()).build();
            // Allow TLSv1 protocol only
            sslsf = new SSLConnectionSocketFactory(sslcontext, new String[]{"TLSv1"}, null,
                    SSLConnectionSocketFactory.getDefaultHostnameVerifier());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sslsf;
    }


    /**
     * 每次请求微信API，创建新的HttpPost、StringEntity、CloseableHttpClient，解决高并发数据安全问题
     *
     * @param requestUrl 请求链接
     * @param req        请求参数
     * @param cret       证书、证书密码
     * @return
     */
    @Override
    public String sendPost(String requestUrl, Object req, Object... cret) {
        //初始化RequestConfig
        if (!hasInit) {
            initRequestConfig();
        }

        String result = null;
        // 发送post 请求
        HttpPost httpPost = new HttpPost(requestUrl);
        // 将要提交给API的数据对象转换成XML格式数据Post给API
        String postDataXML = xStreamForRequestPostData.toXML(req);
        log.info("API，POST过去的数据是：");
        log.info(postDataXML);

        // 得指明使用UTF-8编码，否则到API服务器XML的中文不能被成功识别
        StringEntity postEntity = new StringEntity(postDataXML, "UTF-8");
        // 设置请求头
        httpPost.addHeader("Content-Type", "text/xml");
        // 设置请求实体
        httpPost.setEntity(postEntity);
        // 设置请求器的配置
        httpPost.setConfig(requestConfig);

        log.info("executing request" + httpPost.getRequestLine());
        try {
            CloseableHttpClient httpClient;
            if (cret != null && cret.length == 2) {
                SSLConnectionSocketFactory sslsf = initSSL((File) cret[0], String.valueOf(cret[1]));
                httpClient = HttpClients.custom().setSSLSocketFactory(sslsf).build();
            } else {
                httpClient = HttpClients.custom().build();
            }

            // httpClient执行请求
            HttpResponse response = httpClient.execute(httpPost);
            // 获取HttpResponse 返回实体数据
            HttpEntity entity = response.getEntity();
            // 将entity 转化为String 类型的结果集
            result = EntityUtils.toString(entity, "UTF-8");
        } catch (ConnectionPoolTimeoutException e) {
            log.error("http get throw ConnectionPoolTimeoutException(wait time out)");
        } catch (ConnectTimeoutException e) {
            log.error("http get throw ConnectTimeoutException");
        } catch (SocketTimeoutException e) {
            log.error("http get throw SocketTimeoutException");
        } catch (Exception e) {
            log.error("http get throw Exception");
        } finally {
            httpPost.abort();
        }
        return result;
    }

    /**
     * 开放使用者自定义的RequestConfig
     *
     * @param requestConfig
     */
    @Override
    public void resetRequestConfig(RequestConfig requestConfig) {
        this.requestConfig = requestConfig;
    }
}
