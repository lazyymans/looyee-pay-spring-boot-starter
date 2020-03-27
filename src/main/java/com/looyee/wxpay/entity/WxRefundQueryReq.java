package com.looyee.wxpay.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class WxRefundQueryReq extends WxBaseReq {

	/**
	 * 微信分配的公众账号ID
	 * String(32)
	 */
	private String appid;

	/**
	 * 微信分配的子商户公众账号ID，如需在支付完成后获取sub_openid则此参数必传。
	 * String(32)
	 */
	private String sub_appid;

	/**
	 * 微信支付分配的商户号
	 * String(32)
	 */
	private String mch_id;

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
	 * 签名类型，目前支持HMAC-SHA256和MD5，默认为MD5
	 * String(32)
	 */
	private String sign_type;

	/**
	 * 签名，详见签名生成算法(https://pay.weixin.qq.com/wiki/doc/api/jsapi_sl.php?chapter=4_3)
	 * String(32)
	 */
	private String sign;

	/**
	 * 微信的订单号，优先使用
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
	 * String(32)
	 */
	private String out_refund_no;

	/**
	 * 微信退款单号
	 *
	 * refund_id、out_refund_no、out_trade_no、transaction_id四个参数必填一个，如果同时存在优先级为：
	 *
	 * >out_refund_no>transaction_id>out_trade_no
	 * String(32)
	 */
	private String refund_id;

	/**
	 * 偏移量，当部分退款次数超过10次时可使用，表示返回的查询结果从这个偏移量开始取记录
	 */
	private Integer offset;

}
