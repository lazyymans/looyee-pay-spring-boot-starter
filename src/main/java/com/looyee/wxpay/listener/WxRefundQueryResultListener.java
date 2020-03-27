package com.looyee.wxpay.listener;

import com.looyee.wxpay.business.WxPayBusiness;
import com.looyee.wxpay.entity.WxRefundQueryRes;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WxRefundQueryResultListener implements WxPayBusiness.ResultListener<WxRefundQueryRes> {

	private WxRefundQueryRes refundQueryRes;

	@Override
	public void onFailByReturnCodeError(WxRefundQueryRes t) {
		this.setRefundQueryRes(t);
	}

	@Override
	public void onFailByReturnCodeFail(WxRefundQueryRes t) {
		this.setRefundQueryRes(t);
	}

	@Override
	public void onFailBySignInvalid(WxRefundQueryRes t) {
		this.setRefundQueryRes(t);
	}

	@Override
	public void onFail(WxRefundQueryRes t) {
		this.setRefundQueryRes(t);
	}

	@Override
	public void onSuccess(WxRefundQueryRes t) {
		this.setRefundQueryRes(t);
	}

}
