package com.looyee.wxpay.listener;

import com.looyee.wxpay.business.WxPayBusiness;
import com.looyee.wxpay.entity.WxAuthCodeToOpenIdRes;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WxAuthCodeToOpenIdResultListener implements WxPayBusiness.ResultListener<WxAuthCodeToOpenIdRes> {

	private WxAuthCodeToOpenIdRes authCodeToOpenIdRes;

	@Override
	public void onFailByReturnCodeError(WxAuthCodeToOpenIdRes t) {
		this.setAuthCodeToOpenIdRes(t);
	}

	@Override
	public void onFailByReturnCodeFail(WxAuthCodeToOpenIdRes t) {
		this.setAuthCodeToOpenIdRes(t);
	}

	@Override
	public void onFailBySignInvalid(WxAuthCodeToOpenIdRes t) {
		this.setAuthCodeToOpenIdRes(t);
	}

	@Override
	public void onFail(WxAuthCodeToOpenIdRes t) {
		this.setAuthCodeToOpenIdRes(t);
	}

	@Override
	public void onSuccess(WxAuthCodeToOpenIdRes t) {
		this.setAuthCodeToOpenIdRes(t);
	}

}
