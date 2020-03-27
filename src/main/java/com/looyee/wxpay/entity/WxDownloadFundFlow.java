package com.looyee.wxpay.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class WxDownloadFundFlow {

	//记账时间
	private String trade_time;
	//微信支付业务单号
	private String transaction_id;
	//资金流水单号
	private String flow_number;
	//业务名称
	private String business_name;
	//业务类型
	private String business_type;
	//收支类型
	private String inout_type;
	//收支金额(元)
	private String inout_money;
	//账户结余(元)
	private String account_balance;
	//资金变更提交申请人
	private String applicant;
	//备注
	private String remarks;
	//业务凭证号
	private String voucher_number;

}
