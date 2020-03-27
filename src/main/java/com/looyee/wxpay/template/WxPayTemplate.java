package com.looyee.wxpay.template;

import com.looyee.wxpay.business.WxPayBusiness;
import com.looyee.wxpay.constant.WxPayRequestURLConstant;
import com.looyee.wxpay.entity.*;
import com.looyee.wxpay.listener.*;
import com.looyee.wxpay.notify.WxPayNotify;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.io.File;

@Slf4j
@Component
public class WxPayTemplate {

    @Autowired
    private WxPayBusiness payBusiness;

    @Autowired
    private WxPayNotify payNotify;

    /**
     * 预订单
     *
     * @param orderReq
     * @return
     */
    public WxUnifiedOrderRes unifiedOrder(WxUnifiedOrderReq orderReq) {
        orderReq.setRequestUrl(WxPayRequestURLConstant.UNIFIEDORDER);
        WxUnifiedOrderRes unifiedOrderRes = null;
        try {
            WxUnifiedOrderResultListener resultListener = new WxUnifiedOrderResultListener();
            payBusiness.run(orderReq, WxUnifiedOrderRes.class, resultListener);
            unifiedOrderRes = resultListener.getUnifiedOrderRes();
        } catch (Exception e) {
            log.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " error, message = {}", e);
        }
        return unifiedOrderRes;
    }

    /**
     * 提交付款码支付
     *
     * @param microPayReq
     * @return
     */
    public WxMicroPayRes microPay(WxMicroPayReq microPayReq) {
        microPayReq.setRequestUrl(WxPayRequestURLConstant.MICROPAY);
        WxMicroPayRes microPayRes = null;
        try {
            WxMicroPayResultListener resultListener = new WxMicroPayResultListener();
            payBusiness.run(microPayReq, WxMicroPayRes.class, resultListener);
            microPayRes = resultListener.getWxMicroPayRes();
        } catch (Exception e) {
            log.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " error, message = {}", e);
        }
        return microPayRes;
    }

    /**
     * 撤销订单
     *
     * @param reverseReq
     * @param cert
     * @param cretPassword
     * @return
     */
    public WxReverseRes reverse(WxReverseReq reverseReq, File cert, String cretPassword) {
        reverseReq.setRequestUrl(WxPayRequestURLConstant.REVERSE);
        WxReverseRes reverseRes = null;
        try {
            WxReverseResultListener resultListener = new WxReverseResultListener();
            payBusiness.run(reverseReq, WxReverseRes.class, resultListener, cert, cretPassword);
            reverseRes = resultListener.getReverseRes();
        } catch (Exception e) {
            log.error(Thread.currentThread().getStackTrace()[1].getMethodName() + " error, message = {}", e);
        }
        return reverseRes;
    }

    /**
     * 回调通知
     *
     * @param request
     * @param key
     * @return
     */
    public String wxPayNotify(HttpServletRequest request, String key) {
        return payNotify.doNotifyBusiness(request, key);
    }

    /**
     * 订单查询
     *
     * @param orderQueryReq
     * @return
     */
    public WxOrderQueryRes orderQuery(WxOrderQueryReq orderQueryReq) {
        orderQueryReq.setRequestUrl(WxPayRequestURLConstant.ORDERQUERY);
        WxOrderQueryRes orderQueryRes = null;
        try {
            WxOrderQueryResultListener resultListener = new WxOrderQueryResultListener();
            payBusiness.run(orderQueryReq, WxOrderQueryRes.class, resultListener);
            orderQueryRes = resultListener.getOrderQueryRes();
        } catch (Exception e) {
            log.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " error, message = {}", e);
        }
        return orderQueryRes;
    }

    /**
     * 订单关闭
     *
     * @param closeOrderReq
     * @return
     */
    public WxCloseOrderRes closeOrder(WxCloseOrderReq closeOrderReq) {
        closeOrderReq.setRequestUrl(WxPayRequestURLConstant.CLOSEORDER);
        WxCloseOrderRes closeOrderRes = null;
        try {
            WxCloseOrderResultListener resultListener = new WxCloseOrderResultListener();
            payBusiness.run(closeOrderReq, WxCloseOrderRes.class, resultListener);
            closeOrderRes = resultListener.getCloseOrderRes();
        } catch (Exception e) {
            log.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " error, message = {}", e);
        }
        return closeOrderRes;
    }

    /**
     * 订单退款
     *
     * @param refudnOrderReq
     * @param cert
     * @param cretPassword
     * @return
     */
    public WxRefundOrderRes refundOrder(WxRefundOrderReq refudnOrderReq, File cert, String cretPassword) {
        refudnOrderReq.setRequestUrl(WxPayRequestURLConstant.REFUND);
        WxRefundOrderRes refundOrderRes = null;
        try {
            WxRefundOrderResultListener resultListener = new WxRefundOrderResultListener();
            payBusiness.run(refudnOrderReq, WxRefundOrderRes.class, resultListener, cert, cretPassword);
            refundOrderRes = resultListener.getRefundOrderRes();
        } catch (Exception e) {
            log.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " error, message = {}", e);
        }
        return refundOrderRes;
    }

    /**
     * 订单退款查询
     *
     * @param refundQueryReq
     * @return
     */
    public WxRefundQueryRes refundQuery(WxRefundQueryReq refundQueryReq) {
        refundQueryReq.setRequestUrl(WxPayRequestURLConstant.REFUNDQUERY);
        WxRefundQueryRes refundQueryRes = null;
        try {
            WxRefundQueryResultListener resultListener = new WxRefundQueryResultListener();
            payBusiness.run(refundQueryReq, WxRefundQueryRes.class, resultListener);
            refundQueryRes = resultListener.getRefundQueryRes();
        } catch (Exception e) {
            log.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " error, message = {}", e);
        }
        return refundQueryRes;
    }

    /**
     * 下载对账单
     *
     * @param downloadBillReq
     * @return
     */
    public WxDownloadBillRes downloadBill(WxDownloadBillReq downloadBillReq) {
        downloadBillReq.setRequestUrl(WxPayRequestURLConstant.DOWNLOADBILL);
        WxDownloadBillRes downloadBillRes = null;
        try {
            WxDownloadBillResultListener resultListener = new WxDownloadBillResultListener();
            payBusiness.run(downloadBillReq, WxDownloadBillRes.class, resultListener);
            downloadBillRes = resultListener.getDownloadBillRes();
        } catch (Exception e) {
            log.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " error, message = {}", e);
        }
        return downloadBillRes;
    }

    /**
     * 授权码查询openid
     *
     * @param authCodeToOpenIdReq
     * @return
     */
    public WxAuthCodeToOpenIdRes authCodeToOpenid(WxAuthCodeToOpenIdReq authCodeToOpenIdReq) {
        authCodeToOpenIdReq.setRequestUrl(WxPayRequestURLConstant.AUTHCODETOOPENID);
        WxAuthCodeToOpenIdRes authCodeToOpenIdRes = null;
        try {
            WxAuthCodeToOpenIdResultListener resultListener = new WxAuthCodeToOpenIdResultListener();
            payBusiness.run(authCodeToOpenIdReq, WxAuthCodeToOpenIdRes.class, resultListener);
            authCodeToOpenIdRes = resultListener.getAuthCodeToOpenIdRes();
        } catch (Exception e) {
            log.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " error, message = {}", e);
        }
        return authCodeToOpenIdRes;
    }

    /**
     * 下载资金账单
     *
     * @param downloadFundFlowReq
     * @param cert
     * @param cretPassword
     * @return
     */
    public WxDownloadFundFlowRes downloadFundFlow(WxDownloadFundFlowReq downloadFundFlowReq, File cert, String cretPassword) {
        downloadFundFlowReq.setRequestUrl(WxPayRequestURLConstant.DOWNLOADFUNDFLOW);
        WxDownloadFundFlowRes downloadFundFlowRes = null;
        try {
            WxDownloadFundFlowResultListener resultListener = new WxDownloadFundFlowResultListener();
            payBusiness.run(downloadFundFlowReq, WxDownloadFundFlowRes.class, resultListener, cert, cretPassword);
            downloadFundFlowRes = resultListener.getDownloadFundFlowRes();
        } catch (Exception e) {
            log.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " error, message = {}", e);
        }
        return downloadFundFlowRes;
    }

    /**
     * 交易保障
     *
     * @param reportReq
     * @return
     */
    public WxReportRes report(WxReportReq reportReq) {
        reportReq.setRequestUrl(WxPayRequestURLConstant.REPORT);
        WxReportRes reportRes = null;
        try {
            WxReportResultListener resultListener = new WxReportResultListener();
            payBusiness.run(reportReq, WxReportRes.class, resultListener);
            reportRes = resultListener.getReportRes();
        } catch (Exception e) {
            log.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " error, message = {}", e);
        }
        return reportRes;
    }

    /**
     * 拉取订单评价数据
     *
     * @param batchQueryCommentReq
     * @param cert
     * @param cretPassword
     * @return
     */
    public WxBatchQueryCommentRes batchQueryComment(WxBatchQueryCommentReq batchQueryCommentReq, File cert, String cretPassword) {
        batchQueryCommentReq.setRequestUrl(WxPayRequestURLConstant.BATCHQUERYCOMMENT);
        WxBatchQueryCommentRes batchQueryCommentRes = null;
        try {
            WxBatchQueryCommentResultListener resultListener = new WxBatchQueryCommentResultListener();
            payBusiness.run(batchQueryCommentReq, WxBatchQueryCommentRes.class, resultListener, cert, cretPassword);
            batchQueryCommentRes = resultListener.getBatchQueryCommentRes();
        } catch (Exception e) {
            log.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " error, message = {}", e);
        }
        return batchQueryCommentRes;
    }

    /**
     * 企业付款到零钱
     *
     * @param transfersReq
     * @param cert
     * @param cretPassword
     * @return
     */
    public WxTransfersRes transfers(WxTransfersReq transfersReq, File cert, String cretPassword) {
        transfersReq.setRequestUrl(WxPayRequestURLConstant.TRANSFERS);
        WxTransfersRes transfersRes = null;
        try {
            WxTransfersResultListener resultListener = new WxTransfersResultListener();
            payBusiness.run(transfersReq, WxTransfersRes.class, resultListener, cert, cretPassword);
            transfersRes = resultListener.getTransfersRes();
        } catch (Exception e) {
            log.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " error, message = {}", e);
        }
        return transfersRes;
    }

    /**
     * 查询企业付款到零钱
     *
     * @param transferInfoReq
     * @param cert
     * @param cretPassword
     * @return
     */
    public WxGetTransferInfoRes getTransferInfo(WxGetTransferInfoReq transferInfoReq, File cert, String cretPassword) {
        transferInfoReq.setRequestUrl(WxPayRequestURLConstant.GETTRANSFERINFO);
        WxGetTransferInfoRes transferInfoRes = null;
        try {
            WxGetTransferInfoResultListener resultListener = new WxGetTransferInfoResultListener();
            payBusiness.run(transferInfoReq, WxGetTransferInfoRes.class, resultListener, cert, cretPassword);
            transferInfoRes = resultListener.getTransferInfoRes();
        } catch (Exception e) {
            log.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " error, message = {}", e);
        }
        return transferInfoRes;
    }

}
