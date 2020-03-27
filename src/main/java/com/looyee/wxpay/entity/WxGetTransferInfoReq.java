package com.looyee.wxpay.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class WxGetTransferInfoReq extends WxBaseReq {

	/**
	 * 	申请商户号的appid或商户号绑定的appid
	 * String(128)
	 */
	private String appid;

	/**
	 * 微信支付分配的商户号
	 * String(32)
	 */
	private String mch_id;

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
	 * 商户订单号，需保持唯一性
	 * (只能是字母或者数字，不能包含有其他字符)
	 * String(32)
	 */
	private String partner_trade_no;


}
