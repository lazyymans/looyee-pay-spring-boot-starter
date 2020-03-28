package com.looyee.alipay.notify;

import com.looyee.notify.PayNotifyCallback;

import java.util.Map;

public abstract class AliPayNotifyCallback implements PayNotifyCallback<Map<String, String>> {

    public boolean doInNotifyBusiness(Map<String, String> params) {
        boolean isBusiness = doInNotifyBusiness0(params);
        if (isBusiness) {
            successDoInNotifyBusiness(params);
        }
        return isBusiness;
    }

    abstract Boolean doInNotifyBusiness0(Map<String, String> params);

    public void successDoInNotifyBusiness(Map<String, String> params) {
    }

}
