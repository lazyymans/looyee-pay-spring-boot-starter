package com.looyee.wxpay.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class WxOrderQueryReq extends WxBaseReq {

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
	 * 随机字符串，不长于32位。推荐随机数生成算法(https://pay.weixin.qq.com/wiki/doc/api/jsapi_sl.php?chapter=4_3)
	 * String(32)
	 */
	private String nonce_str;

	/**
	 * 签名，详见签名生成算法(https://pay.weixin.qq.com/wiki/doc/api/jsapi_sl.php?chapter=4_3)
	 * String(32)
	 */
	private String sign;

}
