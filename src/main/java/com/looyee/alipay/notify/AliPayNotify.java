package com.looyee.alipay.notify;

import com.alipay.api.internal.util.AlipaySignature;
import com.looyee.alipay.config.AliPayProperties;
import com.looyee.alipay.constant.AliPayCommonConstant;
import com.looyee.notify.PayNotifyCallback;
import com.looyee.util.SpringBootUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.MapUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

@Slf4j
@Component
public class AliPayNotify {

    @Autowired(required = false)
    private AliPayProperties payProperties;

    private String resAliSuccessXml = "success";
    private String resAliFailXml = "failure";

    public String doNotifyBusiness(HttpServletRequest request) {
        boolean flag = false;
        try {
            Map<String, String> params = new HashMap<>();
            Map requestParams = request.getParameterMap();
            for (Iterator iter = requestParams.keySet().iterator(); iter.hasNext(); ) {
                String name = (String) iter.next();
                String[] values = (String[]) requestParams.get(name);
                String valueStr = "";
                for (int i = 0; i < values.length; i++) {
                    valueStr = (i == values.length - 1) ? valueStr + values[i] : valueStr + values[i] + ",";
                }
                //乱码解决，这段代码在出现乱码时使用。如果mysign和sign不相等也可以使用这段代码转化
                //valueStr = new String(valueStr.getBytes("ISO-8859-1"), "gbk");
                params.put(name, valueStr);
            }
            String passbackParams = MapUtils.getString(params, "passback_params");
            log.info("passback_params = {}", passbackParams);
            String[] attach = passbackParams.split("_");
            String attachBean = attach[0];
            boolean checkSign = AlipaySignature.rsaCheckV1(params, payProperties.getAlipayPublicKey(),
                    AliPayCommonConstant.CHARSET, AliPayCommonConstant.SIGN_TYPE);
            if (checkSign) {
                PayNotifyCallback callback = SpringBootUtil.getBean(attachBean, PayNotifyCallback.class);
                flag = callback.doInNotifyBusiness(params);
            } else {
                log.info("支付宝校验签名失败了 返回的数据为 result = {}", params.toString());
            }
        } catch (Exception e) {
            log.info("", e);
        }
        if (flag) {
            return resAliSuccessXml;
        } else {
            return resAliFailXml;
        }
    }

}
