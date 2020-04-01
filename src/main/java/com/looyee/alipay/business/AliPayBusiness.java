package com.looyee.alipay.business;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.AlipayRequest;
import com.alipay.api.AlipayResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.stereotype.Component;

@Slf4j
@ConditionalOnBean(AlipayClient.class)
@Component
public class AliPayBusiness {

    @Autowired
    private AlipayClient alipayClient;

    public <Response extends AlipayResponse> void execute(AlipayRequest<Response> request, ResultListener<Response> resultListener) throws AlipayApiException {
        Response response = alipayClient.execute(request);
        if (response.isSuccess()) {
            resultListener.onSuccess(response);
        } else {
            resultListener.onFail(response);
        }
    }

    public <Response extends AlipayResponse> void sdkExecute(AlipayRequest<Response> request, ResultListener<Response> resultListener) throws AlipayApiException {
        Response response = alipayClient.sdkExecute(request);
        if (response.isSuccess()) {
            resultListener.onSuccess(response);
        } else {
            resultListener.onFail(response);
        }
    }

    public <Response extends AlipayResponse> void pageExecute(AlipayRequest<Response> request, ResultListener<Response> resultListener) throws AlipayApiException {
        Response response = alipayClient.pageExecute(request);
        if (response.isSuccess()) {
            resultListener.onSuccess(response);
        } else {
            resultListener.onFail(response);
        }
    }

    public interface ResultListener<Response extends AlipayResponse> {

        // 失败
        void onFail(Response response);

        // 成功
        void onSuccess(Response response);

    }

}
