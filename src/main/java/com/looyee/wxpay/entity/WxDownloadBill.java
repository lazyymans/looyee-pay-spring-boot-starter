package com.looyee.wxpay.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class WxDownloadBill {

	private String trade_time;//﻿交易时间
	private String appid;//公众账号ID
	private String mch_id;//商户号
	private String sub_mch_id;//子商户号 特约商户号
	private String device_info;//设备号
	private String transaction_id;//微信订单号
	private String out_trade_no;//商户订单号
	private String openid;//用户标识
	private String trade_type;//交易类型
	private String trade_status;//交易状态
	private String bank_type;//付款银行
	private String fee_type;//货币种类
	private String order_pay;//应结订单金额
	private String voucher_amount;//代金券金额
	private String refund_number;//微信退款单号
	private String out_refund_no;//商户退款单号
	private String refund_amount;//退款金额
	private String refund_amount_voucher;//充值券退款金额
	private String refunds_type;//退款类型
	private String refunds_status;//退款状态
	private String commodity_name;//商品名称
	private String data_packet;//商户数据包
	private String service_charge;//手续费
	private String rate;//费率
	private String order_amount; //订单金额
	private String application_refund_amount; //申请退款金额
	private String rate_notes; //费率备注

}
