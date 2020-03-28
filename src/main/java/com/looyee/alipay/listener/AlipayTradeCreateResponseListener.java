package com.looyee.alipay.listener;

import com.alipay.api.response.AlipayTradeCreateResponse;
import com.looyee.alipay.business.AliPayBusiness;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AlipayTradeCreateResponseListener implements AliPayBusiness.ResultListener<AlipayTradeCreateResponse> {

    private AlipayTradeCreateResponse response;

    private Boolean status;

    @Override
    public void onFail(AlipayTradeCreateResponse response) {
        this.setResponse(response);
        this.setStatus(false);
    }

    @Override
    public void onSuccess(AlipayTradeCreateResponse response) {
        this.setResponse(response);
        this.setStatus(true);
    }

    public boolean assessSuccess() {
        if (this.status == null) {
            this.response = new AlipayTradeCreateResponse();
            response.setCode("500");
            response.setMsg("SYSTEM ERROR");
            response.setSubCode("500");
            response.setSubMsg("当前程序系统错误");
            return false;
        } else {
            return this.status;
        }
    }

}
