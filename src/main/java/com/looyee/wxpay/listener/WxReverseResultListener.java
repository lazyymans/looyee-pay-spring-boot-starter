package com.looyee.wxpay.listener;

import com.looyee.wxpay.business.WxPayBusiness;
import com.looyee.wxpay.entity.WxReverseRes;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WxReverseResultListener implements WxPayBusiness.ResultListener<WxReverseRes> {

	private WxReverseRes reverseRes;

	@Override
	public void onFailByReturnCodeError(WxReverseRes t) {
		this.setReverseRes(t);
	}

	@Override
	public void onFailByReturnCodeFail(WxReverseRes t) {
		this.setReverseRes(t);
	}

	@Override
	public void onFailBySignInvalid(WxReverseRes t) {
		this.setReverseRes(t);
	}

	@Override
	public void onFail(WxReverseRes t) {
		this.setReverseRes(t);
	}

	@Override
	public void onSuccess(WxReverseRes t) {
		this.setReverseRes(t);
	}

}
