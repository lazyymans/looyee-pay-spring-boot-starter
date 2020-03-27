package com.looyee.wxpay.listener;

import com.looyee.wxpay.business.WxPayBusiness;
import com.looyee.wxpay.entity.WxCloseOrderRes;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WxCloseOrderResultListener implements WxPayBusiness.ResultListener<WxCloseOrderRes> {

	private WxCloseOrderRes closeOrderRes;

	@Override
	public void onFailByReturnCodeError(WxCloseOrderRes t) {
		this.setCloseOrderRes(t);
	}

	@Override
	public void onFailByReturnCodeFail(WxCloseOrderRes t) {
		this.setCloseOrderRes(t);
	}

	@Override
	public void onFailBySignInvalid(WxCloseOrderRes t) {
		this.setCloseOrderRes(t);
	}

	@Override
	public void onFail(WxCloseOrderRes t) {
		this.setCloseOrderRes(t);
	}

	@Override
	public void onSuccess(WxCloseOrderRes t) {
		this.setCloseOrderRes(t);
	}

}
