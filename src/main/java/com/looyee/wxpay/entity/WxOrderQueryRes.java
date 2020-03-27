package com.looyee.wxpay.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class WxOrderQueryRes extends WxBaseRes {

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
	 * 错误代码
	 * 详细参见第6节错误列表
	 */
	private String err_code;

	/**
	 * 错误代码描述
	 * 错误返回的信息描述
	 */
	private String err_code_des;

	/**
	 * 调用接口提交的终端设备号，
	 */
	private String device_info;

	/**
	 * 用户在商户appid下的唯一标识
	 */
	private String openid;

	/**
	 * 用户是否关注公众账号，Y-关注，N-未关注（机构商户不返回）
	 */
	private String is_subscribe;

	/**
	 * 用户在子商户appid下的唯一标识
	 */
	private String sub_openid;

	/**
	 * 用户是否关注子公众账号，Y-关注，N-未关注（机构商户不返回）
	 */
	private String sub_is_subscribe;

	/**
	 * JSAPI 公众号支付
	 *
	 * NATIVE Native支付
	 *
	 * APP APP支付
	 *
	 * 说明详见参数规定(https://pay.weixin.qq.com/wiki/doc/api/jsapi_sl.php?chapter=4_2)
	 */
	private String trade_type;

	/**
	 * SUCCESS—支付成功
	 *
	 * REFUND—转入退款
	 *
	 * NOTPAY—未支付
	 *
	 * CLOSED—已关闭
	 *
	 * REVOKED—已撤销(刷卡支付)
	 *
	 * USERPAYING--用户支付中
	 *
	 * PAYERROR--支付失败(其他原因，如银行返回失败)
	 */
	private String trade_state;

	/**
	 * 银行类型，采用字符串类型的银行标识，银行类型见附表
	 */
	private String bank_type;

	/**
	 * 商品详细列表，使用Json格式，传输签名前请务必使用CDATA标签将JSON文本串保护起来。如果使用了单品优惠，会有单品优惠信息返回
	 *
	 * discount_detail []：
	 * └ goods_id String 必填 32 商品的编号
	 * └ goods_name String 必填 256 商品名称
	 * └ coupon_batch_id String 必填 代金券批次ID
	 * └ coupon_id String 必填 代金卷ID
	 * └ coupon_fee Int 必填 代金券支付金额，单位为分
	 */
	private String detail;

	/**
	 * 订单总金额，单位为分
	 */
	private Integer total_fee;

	/**
	 * 货币类型，符合ISO 4217标准的三位字母代码，默认人民币：CNY，其他值列表详见货币类型
	 * (https://pay.weixin.qq.com/wiki/doc/api/jsapi_sl.php?chapter=4_2)
	 */
	private String fee_type;

	/**
	 * 应结订单金额=订单金额-非充值代金券金额，应结订单金额<=订单金额。
	 */
	private Integer settlement_total_fee;

	/**
	 * 现金支付金额订单现金支付金额，详见支付金额
	 * (https://pay.weixin.qq.com/wiki/doc/api/jsapi_sl.php?chapter=4_2)
	 */
	private Integer cash_fee;

	/**
	 * 货币类型，符合ISO 4217标准的三位字母代码，默认人民币：CNY，其他值列表详见货币类型
	 * (https://pay.weixin.qq.com/wiki/doc/api/jsapi_sl.php?chapter=4_2)
	 */
	private String cash_fee_type;

	/**
	 * 代金券或立减优惠金额<=订单总金额，订单总金额-代金券或立减优惠金额=现金支付金额，详见支付金额
	 * (https://pay.weixin.qq.com/wiki/doc/api/jsapi_sl.php?chapter=4_2)
	 */
	private Integer coupon_fee;

	/**
	 * 代金券或立减优惠使用数量
	 */
	private Integer coupon_count;

	/**
	 * 微信支付订单号
	 */
	private String transaction_id;

	/**
	 * 商户系统内部订单号，要求32个字符内，只能是数字、大小写字母_-|*@ ，且在同一个商户号下唯一。
	 */
	private String out_trade_no;

	/**
	 * 商家数据包，原样返回
	 */
	private String attach;

	/**
	 * 支付完成时间，格式为yyyyMMddHHmmss，如2009年12月25日9点10分10秒表示为20091225091010。其他详见时间规则
	 */
	private String time_end;

	/**
	 * 对当前查询订单状态的描述和下一步操作的指引
	 */
	private String trade_state_desc;

}
