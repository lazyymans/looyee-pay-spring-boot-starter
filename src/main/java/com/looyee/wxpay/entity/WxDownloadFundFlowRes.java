package com.looyee.wxpay.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Setter
@Getter
@ToString
public class WxDownloadFundFlowRes extends WxBaseRes {

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

	/**
	 * 结果代码
	 * 详细参见第6节错误列表
	 */
	private String result_code;

	/**
	 * 错误代码
	 * 详细参见第6节错误列表
	 */
	private String error_code;

	/**
	 * 错误代码
	 * 详细参见第6节错误列表
	 */
	private String err_code_des;

	/**
	 * 账单列表
	 */
	private List<WxDownloadFundFlow> downloadFundFlows;

}
