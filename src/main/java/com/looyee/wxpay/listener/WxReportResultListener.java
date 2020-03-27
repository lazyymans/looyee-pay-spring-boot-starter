package com.looyee.wxpay.listener;

import com.looyee.wxpay.business.WxPayBusiness;
import com.looyee.wxpay.entity.WxReportRes;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WxReportResultListener implements WxPayBusiness.ResultListener<WxReportRes> {

	private WxReportRes reportRes;

	@Override
	public void onFailByReturnCodeError(WxReportRes t) {
		this.setReportRes(t);
	}

	@Override
	public void onFailByReturnCodeFail(WxReportRes t) {
		this.setReportRes(t);
	}

	@Override
	public void onFailBySignInvalid(WxReportRes t) {
		this.setReportRes(t);
	}

	@Override
	public void onFail(WxReportRes t) {
		this.setReportRes(t);
	}

	@Override
	public void onSuccess(WxReportRes t) {
		this.setReportRes(t);
	}

}
