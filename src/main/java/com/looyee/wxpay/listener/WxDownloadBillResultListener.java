package com.looyee.wxpay.listener;

import com.looyee.wxpay.business.WxPayBusiness;
import com.looyee.wxpay.entity.WxDownloadBillRes;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WxDownloadBillResultListener implements WxPayBusiness.ResultListener<WxDownloadBillRes> {

	private WxDownloadBillRes downloadBillRes;

	@Override
	public void onFailByReturnCodeError(WxDownloadBillRes t) {
		this.setDownloadBillRes(t);
	}

	@Override
	public void onFailByReturnCodeFail(WxDownloadBillRes t) {
		this.setDownloadBillRes(t);
	}

	@Override
	public void onFailBySignInvalid(WxDownloadBillRes t) {
		this.setDownloadBillRes(t);
	}

	@Override
	public void onFail(WxDownloadBillRes t) {
		this.setDownloadBillRes(t);
	}

	@Override
	public void onSuccess(WxDownloadBillRes t) {
		this.setDownloadBillRes(t);
	}

}
