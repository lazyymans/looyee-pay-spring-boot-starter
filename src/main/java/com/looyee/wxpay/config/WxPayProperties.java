package com.looyee.wxpay.config;

import com.looyee.wxpay.proxy.CglibProxyFactory;
import com.looyee.wxpay.service.RequsetService;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Validated
@ConfigurationProperties(prefix = "looyee.pay.wx")
public class WxPayProperties {

    private static final String DEFAULT_REQUEST_SERVICE = "com.looyee.wxpay.service.impl.RequsetServiceImpl";

    @Valid
    @NotNull
    private String key;

    private String wxAppid;

    private String wxaAppid;

    private String appAppid;

    @Valid
    @NotNull
    private String mchid;

    @Valid
    @NotNull
    private String certPassword;

    private String notify;

    @Valid
    @NotNull
    private String certFilePath;

    private String request = DEFAULT_REQUEST_SERVICE;

    @Bean
    public RequsetService requsetService() throws ClassNotFoundException {
        Class<?> clazz = Class.forName(request);
        RequsetService proxyRequestService = (RequsetService) new CglibProxyFactory().getProxyInstance(clazz);
        return proxyRequestService;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getWxAppid() {
        return wxAppid;
    }

    public void setWxAppid(String wxAppid) {
        this.wxAppid = wxAppid;
    }

    public String getWxaAppid() {
        return wxaAppid;
    }

    public void setWxaAppid(String wxaAppid) {
        this.wxaAppid = wxaAppid;
    }

    public String getAppAppid() {
        return appAppid;
    }

    public void setAppAppid(String appAppid) {
        this.appAppid = appAppid;
    }

    public String getMchid() {
        return mchid;
    }

    public void setMchid(String mchid) {
        this.mchid = mchid;
    }

    public String getCertPassword() {
        return certPassword;
    }

    public void setCertPassword(String certPassword) {
        this.certPassword = certPassword;
    }

    public String getNotify() {
        return notify;
    }

    public void setNotify(String notify) {
        this.notify = notify;
    }

    public String getCertFilePath() {
        return certFilePath;
    }

    public void setCertFilePath(String certFilePath) {
        this.certFilePath = certFilePath;
    }

    public String getRequest() {
        return request;
    }

    public void setRequest(String request) {
        this.request = request;
    }
}
