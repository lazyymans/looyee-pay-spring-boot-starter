package com.looyee.wxpay.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class WxRefundOrderReq extends WxBaseReq {

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
     * 微信支付订单号
     * String(32)
     */
    private String transaction_id;

    /**
     * 商户系统内部订单号，要求32个字符内，只能是数字、大小写字母_-|*@ ，且在同一个商户号下唯一。
     * String(32)
     */
    private String out_trade_no;

    /**
     * 商户系统内部的退款单号，商户系统内部唯一，只能是数字、大小写字母_-|*@ ，同一退款单号多次请求只退一笔。
     * String(64)
     */
    private String out_refund_no;

    /**
     * 订单总金额，单位为分，只能为整数，详见支付金额(https://pay.weixin.qq.com/wiki/doc/api/jsapi_sl.php?chapter=4_2)
     */
    private Integer total_fee;

    /**
     * 退款总金额，单位为分，只能为整数，可部分退款。详见支付金额(https://pay.weixin.qq.com/wiki/doc/api/jsapi_sl.php?chapter=4_2)
     */
    private Integer refund_fee;

    /**
     * 退款货币类型，需与支付一致，或者不填。符合ISO 4217标准的三位字母代码，默认人民币：CNY，其他值列表详见货币类型(https://pay.weixin.qq.com/wiki/doc/api/jsapi_sl.php?chapter=4_2)
     * String(8)
     */
    private String refund_fee_type;

    /**
     * 若商户传入，会在下发给用户的退款消息中体现退款原因
     *
     * 注意：若订单退款金额≤1元，且属于部分退款，则不会在退款消息中体现退款原因
     * String(80)
     */
    private String refund_desc;

    /**
     * 仅针对老资金流商户使用
     *
     * REFUND_SOURCE_UNSETTLED_FUNDS---未结算资金退款（默认使用未结算资金退款）
     *
     * REFUND_SOURCE_RECHARGE_FUNDS---可用余额退款
     * String(30)
     */
    private String refund_account;

    /**
     * 异步接收微信支付退款结果通知的回调地址，通知URL必须为外网可访问的url，不允许带参数
     *
     * 如果参数中传了notify_url，则商户平台上配置的回调地址将不会生效
     * String(256)
     */
    private String notify_url;

}
