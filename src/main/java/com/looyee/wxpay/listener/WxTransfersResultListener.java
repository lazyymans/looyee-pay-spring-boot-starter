package com.looyee.wxpay.listener;

import com.looyee.wxpay.business.WxPayBusiness;
import com.looyee.wxpay.entity.WxTransfersRes;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WxTransfersResultListener implements WxPayBusiness.ResultListener<WxTransfersRes> {

	private WxTransfersRes transfersRes;

	@Override
	public void onFailByReturnCodeError(WxTransfersRes t) {
		this.setTransfersRes(t);
	}

	@Override
	public void onFailByReturnCodeFail(WxTransfersRes t) {
		this.setTransfersRes(t);
	}

	@Override
	public void onFailBySignInvalid(WxTransfersRes t) {
		this.setTransfersRes(t);
	}

	@Override
	public void onFail(WxTransfersRes t) {
		this.setTransfersRes(t);
	}

	@Override
	public void onSuccess(WxTransfersRes t) {
		this.setTransfersRes(t);
	}

}
