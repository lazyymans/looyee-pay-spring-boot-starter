package com.looyee.wxpay.listener;

import com.looyee.wxpay.business.WxPayBusiness;
import com.looyee.wxpay.entity.WxMicroPayRes;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WxMicroPayResultListener implements WxPayBusiness.ResultListener<WxMicroPayRes> {

	private WxMicroPayRes wxMicroPayRes;

	@Override
	public void onFailByReturnCodeError(WxMicroPayRes t) {
		this.setWxMicroPayRes(t);
	}

	@Override
	public void onFailByReturnCodeFail(WxMicroPayRes t) {
		this.setWxMicroPayRes(t);
	}

	@Override
	public void onFailBySignInvalid(WxMicroPayRes t) {
		this.setWxMicroPayRes(t);
	}

	@Override
	public void onFail(WxMicroPayRes t) {
		this.setWxMicroPayRes(t);
	}

	@Override
	public void onSuccess(WxMicroPayRes t) {
		this.setWxMicroPayRes(t);
	}

}
