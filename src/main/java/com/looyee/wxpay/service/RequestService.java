package com.looyee.wxpay.service;

import org.apache.http.client.config.RequestConfig;

/**
 * 发送微信请求接口，每一个发送的请求，都必须实现此接口
 * 本服务内置了一个默认的请求示例类，若使用者想自己定制话
 * 可以自己实现RequestService 接口，并修改 yml 文件中的 request 值
 */
public interface RequestService {

    /**
     * 微信统一请求Service
     *
     * @param requestUrl 请求链接
     * @param req        请求参数(WxBaseReq)
     * @param cret       证书、证书密码
     * @return
     */
    String sendPost(String requestUrl, Object req, Object... cret);

    /**
     * 重新设置请求Config
     *
     * @param requestConfig
     */
    default void resetRequestConfig(RequestConfig requestConfig) {

    }

}
