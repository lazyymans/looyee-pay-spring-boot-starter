package com.looyee.wxpay.notify;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.looyee.notify.PayNotifyCallback;
import com.looyee.util.SpringBootUtil;
import com.looyee.wxpay.common.JsonUtil;
import com.looyee.wxpay.common.Signature;
import com.looyee.wxpay.common.WeixinUtil;
import com.looyee.wxpay.entity.WxCoupon;
import com.looyee.wxpay.entity.WxPayNotifyRes;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Component
public class WxPayNotify {

    /**
     * 返回成功xml
     */
    private String resSuccessXml = "<xml><return_code><![CDATA[SUCCESS]]></return_code><return_msg><![CDATA[OK]]></return_msg></xml>";

    /**
     * 返回失败xml
     */
    private String resFailXml = "<xml><return_code><![CDATA[FAIL]]></return_code><return_msg><![CDATA[报文为空]]></return_msg></xml>";


    public String doNotifyBusiness(HttpServletRequest request, String key) {
        Boolean flag = false;
        try {
            String xmlString = WeixinUtil.inputStreamToString(request.getInputStream());
            log.info("微信回调生成的返回数据 result = {}", xmlString);
            if (Signature.checkIsSignValidFromResponseString(xmlString, key)) {
                //将微信返回的数据进行转换成现有实体类
                Object obj = WeixinUtil.getObjectFromXML(xmlString, WxPayNotifyRes.class);
                JSONObject resultJson = (JSONObject) JSON.toJSON(obj);
                WxPayNotifyRes resData = JsonUtil.Json2Object(resultJson, WxPayNotifyRes.class);
                Integer coupon_count = resData.getCoupon_count();
                if (coupon_count != null && coupon_count > 0) {
                    List<WxCoupon> coupons = new ArrayList<>();
                    for (int i = 0; i < coupon_count; i++) {
                        WxCoupon coupon = new WxCoupon();
                        coupon.setCoupon_id(resultJson.getString("coupon_id_" + i));
                        coupon.setCoupon_fee(resultJson.getInteger("coupon_fee_" + i));
                        coupons.add(coupon);
                    }
                    resData.setCoupons(coupons);
                }
                log.info("doInNotifyBusiness params = {}", resData);
                //这里执行业务
                if (StringUtils.isNotBlank(resData.getAttach())) {
                    String[] attach = resData.getAttach().split("_");
                    String attachBean = attach[0];
                    PayNotifyCallback callback = SpringBootUtil.getBean(attachBean, PayNotifyCallback.class);
                    flag = callback.doInNotifyBusiness(resData);
                } else {
                    log.info("当前回调没有处理业务, 直接返回成功");
                    flag = true;
                }
            } else {
                log.info("微信校验签名失败了 返回的数据为 result = {}", xmlString);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (flag) {
            return resSuccessXml;
        } else {
            return resFailXml;
        }
    }

}
