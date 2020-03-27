package com.looyee.wxpay.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class WxDownloadBillReq extends WxBaseReq {

    /**
     * 微信分配的公众账号ID
     * String(32)
     */
    private String appid;

    /**
     * 微信支付分配的商户号
     * String(32)
     */
    private String mch_id;

    /**
     * 微信分配的子商户公众账号ID，如需在支付完成后获取sub_openid则此参数必传。
     * String(32)
     */
    private String sub_appid;

    /**
     * 微信支付分配的子商户号
     * String(32)
     */
    private String sub_mch_id;

    /**
     * 随机字符串，不长于32位。推荐随机数生成算法(https://pay.weixin.qq.com/wiki/doc/api/jsapi_sl.php?chapter=4_3)
     * String(32)
     */
    private String nonce_str;

    /**
     * 签名，详见签名生成算法(https://pay.weixin.qq.com/wiki/doc/api/jsapi_sl.php?chapter=4_3)
     * String(32)
     */
    private String sign;

    /**
     * 下载对账单的日期，格式：20140603
     * String(8)
     */
    private String bill_date;

    /**
     * ALL，返回当日所有订单信息，默认值
     *
     * SUCCESS，返回当日成功支付的订单
     *
     * REFUND，返回当日退款订单
     *
     * RECHARGE_REFUND，返回当日充值退款订单
     * String(8)
     */
    private String bill_type;

    /**
     * 非必传参数，固定值：GZIP，返回格式为.gzip的压缩包账单。不传则默认为数据流形式。
     */
    private String tar_type;

}
