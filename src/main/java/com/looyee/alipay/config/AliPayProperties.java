package com.looyee.alipay.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Validated
@ConfigurationProperties(prefix = "looyee.pay.ali")
public class AliPayProperties {

    @Valid
    @NotNull
    private String appId;

    @Valid
    @NotNull
    private String privateKey;

    @Valid
    @NotNull
    private String alipayPublicKey;

    private String notifyUrl;

    private String returnUrl;

    private String billFileZipPath;

    private String billFileUnZipPath;

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getPrivateKey() {
        return privateKey;
    }

    public void setPrivateKey(String privateKey) {
        this.privateKey = privateKey;
    }

    public String getAlipayPublicKey() {
        return alipayPublicKey;
    }

    public void setAlipayPublicKey(String alipayPublicKey) {
        this.alipayPublicKey = alipayPublicKey;
    }

    public String getNotifyUrl() {
        return notifyUrl;
    }

    public void setNotifyUrl(String notifyUrl) {
        this.notifyUrl = notifyUrl;
    }

    public String getReturnUrl() {
        return returnUrl;
    }

    public void setReturnUrl(String returnUrl) {
        this.returnUrl = returnUrl;
    }

    public String getBillFileZipPath() {
        return billFileZipPath;
    }

    public void setBillFileZipPath(String billFileZipPath) {
        this.billFileZipPath = billFileZipPath;
    }

    public String getBillFileUnZipPath() {
        return billFileUnZipPath;
    }

    public void setBillFileUnZipPath(String billFileUnZipPath) {
        this.billFileUnZipPath = billFileUnZipPath;
    }
}
