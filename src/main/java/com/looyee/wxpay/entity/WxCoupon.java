package com.looyee.wxpay.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class WxCoupon {

	/**
	 * 代金券或立减优惠ID
	 */
	private String coupon_id;

	/**
	 * 单个代金券或立减优惠支付金额
	 */
	private Integer coupon_fee;

	/**
	 * 代金券类型
	 */
	private String coupon_type;

}
