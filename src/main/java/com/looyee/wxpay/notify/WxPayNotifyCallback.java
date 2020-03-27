package com.looyee.wxpay.notify;


import com.looyee.notify.PayNotifyCallback;
import com.looyee.wxpay.entity.WxPayNotifyRes;

public abstract class WxPayNotifyCallback implements PayNotifyCallback<WxPayNotifyRes> {

    public boolean doInNotifyBusiness(WxPayNotifyRes resData) {
        boolean isBusiness = doInNotifyBusiness0(resData);
        if (isBusiness) {
            successDoInNotifyBusiness(resData);
        }
        return isBusiness;
    }

    abstract Boolean doInNotifyBusiness0(WxPayNotifyRes resData);

    public void successDoInNotifyBusiness(WxPayNotifyRes resData) {
    }

}
