package com.looyee.wxpay.listener;

import com.looyee.wxpay.business.WxPayBusiness;
import com.looyee.wxpay.entity.WxOrderQueryRes;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WxOrderQueryResultListener implements WxPayBusiness.ResultListener<WxOrderQueryRes> {

	private WxOrderQueryRes orderQueryRes;

	@Override
	public void onFailByReturnCodeError(WxOrderQueryRes t) {
		this.setOrderQueryRes(t);
	}

	@Override
	public void onFailByReturnCodeFail(WxOrderQueryRes t) {
		this.setOrderQueryRes(t);
	}

	@Override
	public void onFailBySignInvalid(WxOrderQueryRes t) {
		this.setOrderQueryRes(t);
	}

	@Override
	public void onFail(WxOrderQueryRes t) {
		this.setOrderQueryRes(t);
	}

	@Override
	public void onSuccess(WxOrderQueryRes t) {
		this.setOrderQueryRes(t);
	}

}
