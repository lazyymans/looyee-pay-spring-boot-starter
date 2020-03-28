package com.looyee.alipay.listener;

import com.alipay.api.response.AlipayTradePageRefundResponse;
import com.looyee.alipay.business.AliPayBusiness;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AlipayTradePageRefundResponseListener implements AliPayBusiness.ResultListener<AlipayTradePageRefundResponse> {

    private AlipayTradePageRefundResponse response;

    private Boolean status;

    @Override
    public void onFail(AlipayTradePageRefundResponse response) {
        this.setResponse(response);
        this.setStatus(false);
    }

    @Override
    public void onSuccess(AlipayTradePageRefundResponse response) {
        this.setResponse(response);
        this.setStatus(true);
    }

    public boolean assessSuccess() {
        if (this.status == null) {
            this.response = new AlipayTradePageRefundResponse();
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
