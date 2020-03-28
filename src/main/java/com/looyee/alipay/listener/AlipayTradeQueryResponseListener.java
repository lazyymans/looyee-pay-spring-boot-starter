package com.looyee.alipay.listener;

import com.alipay.api.response.AlipayTradeQueryResponse;
import com.looyee.alipay.business.AliPayBusiness;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AlipayTradeQueryResponseListener implements AliPayBusiness.ResultListener<AlipayTradeQueryResponse> {

    private AlipayTradeQueryResponse response;

    private Boolean status;

    @Override
    public void onFail(AlipayTradeQueryResponse response) {
        this.setResponse(response);
        this.setStatus(false);
    }

    @Override
    public void onSuccess(AlipayTradeQueryResponse response) {
        this.setResponse(response);
        this.setStatus(true);
    }

    public boolean assessSuccess() {
        if (this.status == null) {
            this.response = new AlipayTradeQueryResponse();
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
