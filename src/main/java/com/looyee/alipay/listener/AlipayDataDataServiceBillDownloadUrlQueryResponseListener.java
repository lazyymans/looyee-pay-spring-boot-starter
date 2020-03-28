package com.looyee.alipay.listener;

import com.alipay.api.response.AlipayDataDataserviceBillDownloadurlQueryResponse;
import com.looyee.alipay.business.AliPayBusiness;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AlipayDataDataServiceBillDownloadUrlQueryResponseListener implements AliPayBusiness.ResultListener<AlipayDataDataserviceBillDownloadurlQueryResponse> {

    private AlipayDataDataserviceBillDownloadurlQueryResponse response;

    private Boolean status;

    @Override
    public void onFail(AlipayDataDataserviceBillDownloadurlQueryResponse response) {
        this.setResponse(response);
        this.setStatus(false);
    }

    @Override
    public void onSuccess(AlipayDataDataserviceBillDownloadurlQueryResponse response) {
        this.setResponse(response);
        this.setStatus(true);
    }

    public boolean assessSuccess() {
        if (this.status == null) {
            this.response = new AlipayDataDataserviceBillDownloadurlQueryResponse();
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
