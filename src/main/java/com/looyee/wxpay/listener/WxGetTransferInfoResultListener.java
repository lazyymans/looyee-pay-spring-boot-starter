package com.looyee.wxpay.listener;

import com.looyee.wxpay.business.WxPayBusiness;
import com.looyee.wxpay.entity.WxGetTransferInfoRes;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WxGetTransferInfoResultListener implements WxPayBusiness.ResultListener<WxGetTransferInfoRes> {

	private WxGetTransferInfoRes transferInfoRes;

	@Override
	public void onFailByReturnCodeError(WxGetTransferInfoRes t) {
		this.setTransferInfoRes(t);
	}

	@Override
	public void onFailByReturnCodeFail(WxGetTransferInfoRes t) {
		this.setTransferInfoRes(t);
	}

	@Override
	public void onFailBySignInvalid(WxGetTransferInfoRes t) {
		this.setTransferInfoRes(t);
	}

	@Override
	public void onFail(WxGetTransferInfoRes t) {
		this.setTransferInfoRes(t);
	}

	@Override
	public void onSuccess(WxGetTransferInfoRes t) {
		this.setTransferInfoRes(t);
	}

}
