package com.looyee.alipay.listener;

import com.alipay.api.response.AlipayTradeOrderSettleResponse;
import com.looyee.alipay.business.AliPayBusiness;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AlipayTradeOrderSettleResponseListener implements AliPayBusiness.ResultListener<AlipayTradeOrderSettleResponse> {

    private AlipayTradeOrderSettleResponse response;

    private Boolean status;

    @Override
    public void onFail(AlipayTradeOrderSettleResponse response) {
        this.setResponse(response);
        this.setStatus(false);
    }

    @Override
    public void onSuccess(AlipayTradeOrderSettleResponse response) {
        this.setResponse(response);
        this.setStatus(true);
    }

    public boolean assessSuccess() {
        if (this.status == null) {
            this.response = new AlipayTradeOrderSettleResponse();
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
