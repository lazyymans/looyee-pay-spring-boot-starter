package com.looyee.wxpay.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class WxTransfersReq extends WxBaseReq {

	/**
	 * 	申请商户号的appid或商户号绑定的appid
	 * String(128)
	 */
	private String mch_appid;

	/**
	 * 微信支付分配的商户号
	 * String(32)
	 */
	private String mchid;

	/**
	 * 微信支付分配的终端设备号
	 * String(32)
	 */
	private String device_info;

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

	/**
	 * 商户appid下，某用户的openid
	 * String(64)
	 */
	private String openid;

	/**
	 * NO_CHECK：不校验真实姓名
	 * FORCE_CHECK：强校验真实姓名
	 * String(16)
	 */
	private String check_name;

	/**
	 * 收款用户真实姓名。
	 * 如果check_name设置为FORCE_CHECK，则必填用户真实姓名
	 * String(64)
	 */
	private String re_user_name;

	/**
	 * 企业付款金额，单位为分
	 */
	private Integer amount;

	/**
	 * 企业付款备注，必填。注意：备注中的敏感词会被转成字符*
	 * String(100)
	 */
	private String desc;

	/**
	 * 该IP同在商户平台设置的IP白名单中的IP没有关联，该IP可传用户端或者服务端的IP。
	 * 	String(32)
	 */
	private String spbill_create_ip;

}
