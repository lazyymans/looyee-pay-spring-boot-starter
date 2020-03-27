package com.looyee.wxpay.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class WxCloseOrderRes extends WxBaseRes {

	/**
	 * SUCCESS/FAIL
	 *
	 * 此字段是通信标识，非交易标识，交易是否成功需要查看result_code来判断
	 */
	private String return_code;

	/**
	 * 返回信息，如非空，为错误原因
	 *
	 * 签名失败
	 *
	 * 参数格式校验错误
	 */
	private String return_msg;

	//以下字段在return_code为SUCCESS的时候有返回
	/**
	 * 调用接口提交的公众账号ID
	 */
	private String appid;

	/**
	 * 调用接口提交的商户号
	 */
	private String mch_id;

	/**
	 * 微信分配的子商户公众账号ID
	 */
	private String sub_appid;

	/**
	 * 微信支付分配的子商户号
	 */
	private String sub_mch_id;

	/**
	 * 微信返回的随机字符串
	 */
	private String nonce_str;

	/**
	 * 微信返回的签名，详见签名算法(https://pay.weixin.qq.com/wiki/doc/api/jsapi_sl.php?chapter=4_3)
	 */
	private String sign;

	/**
	 * 业务结果
	 * SUCCESS/FAIL
	 */
	private String result_code;

	/**
	 * 对业务结果的补充说明
	 * SUCCESS/FAIL
	 */
	private String result_msg;

	/**
	 * 错误代码
	 * 详细参见第6节错误列表
	 */
	private String err_code;

	/**
	 * 错误代码描述
	 * 错误返回的信息描述
	 */
	private String err_code_des;

}
