package com.looyee.wxpay.listener;

import com.looyee.wxpay.business.WxPayBusiness;
import com.looyee.wxpay.entity.WxBatchQueryCommentRes;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WxBatchQueryCommentResultListener implements WxPayBusiness.ResultListener<WxBatchQueryCommentRes> {

	private WxBatchQueryCommentRes batchQueryCommentRes;

	@Override
	public void onFailByReturnCodeError(WxBatchQueryCommentRes t) {
		this.setBatchQueryCommentRes(t);
	}

	@Override
	public void onFailByReturnCodeFail(WxBatchQueryCommentRes t) {
		this.setBatchQueryCommentRes(t);
	}

	@Override
	public void onFailBySignInvalid(WxBatchQueryCommentRes t) {
		this.setBatchQueryCommentRes(t);
	}

	@Override
	public void onFail(WxBatchQueryCommentRes t) {
		this.setBatchQueryCommentRes(t);
	}

	@Override
	public void onSuccess(WxBatchQueryCommentRes t) {
		this.setBatchQueryCommentRes(t);
	}

}
