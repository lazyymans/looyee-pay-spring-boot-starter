package com.looyee.wxpay.listener;

import com.looyee.wxpay.business.WxPayBusiness;
import com.looyee.wxpay.entity.WxDownloadFundFlowRes;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WxDownloadFundFlowResultListener implements WxPayBusiness.ResultListener<WxDownloadFundFlowRes> {

	private WxDownloadFundFlowRes downloadFundFlowRes;

	@Override
	public void onFailByReturnCodeError(WxDownloadFundFlowRes t) {
		this.setDownloadFundFlowRes(t);
	}

	@Override
	public void onFailByReturnCodeFail(WxDownloadFundFlowRes t) {
		this.setDownloadFundFlowRes(t);
	}

	@Override
	public void onFailBySignInvalid(WxDownloadFundFlowRes t) {
		this.setDownloadFundFlowRes(t);
	}

	@Override
	public void onFail(WxDownloadFundFlowRes t) {
		this.setDownloadFundFlowRes(t);
	}

	@Override
	public void onSuccess(WxDownloadFundFlowRes t) {
		this.setDownloadFundFlowRes(t);
	}

}
