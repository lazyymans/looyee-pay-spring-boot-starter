package com.looyee.wxpay.listener;

import com.looyee.wxpay.business.WxPayBusiness;
import com.looyee.wxpay.entity.WxUnifiedOrderRes;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WxUnifiedOrderResultListener implements WxPayBusiness.ResultListener<WxUnifiedOrderRes> {

	private WxUnifiedOrderRes unifiedOrderRes;

	@Override
	public void onFailByReturnCodeError(WxUnifiedOrderRes t) {
		this.setUnifiedOrderRes(t);
	}

	@Override
	public void onFailByReturnCodeFail(WxUnifiedOrderRes t) {
		this.setUnifiedOrderRes(t);
	}

	@Override
	public void onFailBySignInvalid(WxUnifiedOrderRes t) {
		this.setUnifiedOrderRes(t);
	}

	@Override
	public void onFail(WxUnifiedOrderRes t) {
		this.setUnifiedOrderRes(t);
	}

	@Override
	public void onSuccess(WxUnifiedOrderRes t) {
		this.setUnifiedOrderRes(t);
	}

}
