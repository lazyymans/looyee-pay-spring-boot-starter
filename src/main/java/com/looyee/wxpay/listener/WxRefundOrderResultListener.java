package com.looyee.wxpay.listener;

import com.looyee.wxpay.business.WxPayBusiness;
import com.looyee.wxpay.entity.WxRefundOrderRes;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WxRefundOrderResultListener implements WxPayBusiness.ResultListener<WxRefundOrderRes> {

	private WxRefundOrderRes refundOrderRes;

	@Override
	public void onFailByReturnCodeError(WxRefundOrderRes t) {
		this.setRefundOrderRes(t);
	}

	@Override
	public void onFailByReturnCodeFail(WxRefundOrderRes t) {
		this.setRefundOrderRes(t);
	}

	@Override
	public void onFailBySignInvalid(WxRefundOrderRes t) {
		this.setRefundOrderRes(t);
	}

	@Override
	public void onFail(WxRefundOrderRes t) {
		this.setRefundOrderRes(t);
	}

	@Override
	public void onSuccess(WxRefundOrderRes t) {
		this.setRefundOrderRes(t);
	}

}
