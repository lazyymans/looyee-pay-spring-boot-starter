package com.looyee.alipay.listener;

import com.alipay.api.response.AlipayTradeFastpayRefundQueryResponse;
import com.looyee.alipay.business.AliPayBusiness;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AlipayTradeFastpayRefundQueryResponseListener implements AliPayBusiness.ResultListener<AlipayTradeFastpayRefundQueryResponse> {

    private AlipayTradeFastpayRefundQueryResponse response;

    private Boolean status;

    @Override
    public void onFail(AlipayTradeFastpayRefundQueryResponse response) {
        this.setResponse(response);
        this.setStatus(false);
    }

    @Override
    public void onSuccess(AlipayTradeFastpayRefundQueryResponse response) {
        this.setResponse(response);
        this.setStatus(true);
    }

    public boolean assessSuccess() {
        if (this.status == null) {
            this.response = new AlipayTradeFastpayRefundQueryResponse();
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
