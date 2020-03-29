package com.looyee.wxpay.business;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.looyee.wxpay.common.JsonUtil;
import com.looyee.wxpay.common.Signature;
import com.looyee.wxpay.common.WxPayUtil;
import com.looyee.wxpay.entity.*;
import com.looyee.wxpay.service.RequestService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Component
public class WxPayBusiness {

    @Autowired(required = false)
    private RequestService requestService;

    /**
     * 统一执行微信请求
     *
     * @param req            请求参数
     * @param resClazz       响应参数Class
     * @param resultListener 监听器
     * @param cret           证书，证书密码
     * @param <Req>
     * @throws Exception
     */
    public <Req extends WxBaseReq, Res extends WxBaseRes> void run(Req req, Class<Res> resClazz, ResultListener<Res> resultListener, Object... cret) throws Exception {

        String payResultString;
        String key = req.getKey();
        String requestUrl = req.getRequestUrl();
        req.setKey(null);
        req.setRequestUrl(null);

        Long costTimeStart = System.currentTimeMillis();
        //发送请求
        payResultString = requestService.sendPost(requestUrl, req, cret);
        Long costTimeEnd = System.currentTimeMillis();
        log.info("请求耗时： {}毫秒", (costTimeEnd - costTimeStart));

        if (resClazz == WxDownloadBillRes.class) {
            if (payResultString.startsWith("<xml>")) {
                Object objectFromXML = WxPayUtil.getObjectFromXML(payResultString, resClazz);
                JSONObject resultJson = (JSONObject) JSON.toJSON(objectFromXML);
                resultListener.onFail(JsonUtil.Json2Object(resultJson, resClazz));
                return;
            } else {
                WxDownloadBillRes downloadBillRes = convertToWxDownloadBillRes(payResultString);
                downloadBillRes.setReturn_code("SUCCESS");
                downloadBillRes.setReturn_msg("OK");
                resultListener.onSuccess((Res) downloadBillRes);
                return;
            }
        } else if (resClazz == WxDownloadFundFlowRes.class) {
            if (payResultString.startsWith("<xml>")) {
                Object objectFromXML = WxPayUtil.getObjectFromXML(payResultString, resClazz);
                JSONObject resultJson = (JSONObject) JSON.toJSON(objectFromXML);
                resultListener.onFail(JsonUtil.Json2Object(resultJson, resClazz));
                return;
            } else {
                WxDownloadFundFlowRes downloadFundFlowRes = convertToWxDownloadFundFlowRes(payResultString);
                downloadFundFlowRes.setReturn_code("SUCCESS");
                downloadFundFlowRes.setReturn_msg("OK");
                resultListener.onSuccess((Res) downloadFundFlowRes);
                return;
            }
        } else if (resClazz == WxBatchQueryCommentRes.class) {
            if (payResultString.startsWith("<xml>")) {
                Object objectFromXML = WxPayUtil.getObjectFromXML(payResultString, resClazz);
                JSONObject resultJson = (JSONObject) JSON.toJSON(objectFromXML);
                resultListener.onFail(JsonUtil.Json2Object(resultJson, resClazz));
                return;
            } else {
                WxBatchQueryCommentRes batchQueryCommentRes = convertToWxBatchQueryCommentRes(payResultString);
                batchQueryCommentRes.setReturn_code("SUCCESS");
                batchQueryCommentRes.setReturn_msg("OK");
                resultListener.onSuccess((Res) batchQueryCommentRes);
                return;
            }
        } else {
            Object objectFromXML = WxPayUtil.getObjectFromXML(payResultString, resClazz);
            JSONObject resultJson = (JSONObject) JSON.toJSON(objectFromXML);

            String return_code = resultJson.getString("return_code");
            if (StringUtils.isBlank(return_code)) {
                log.error("【调用失败】请求逻辑错误，请仔细检测传过去的每一个参数是否合法，或是看API能否被正常访问");
                resultListener.onFailByReturnCodeError(JsonUtil.Json2Object(resultJson, resClazz));
                return;
            }

            if (return_code.equals("FAIL")) {
                // 注意：一般这里返回FAIL是出现系统级参数错误，请检测Post给API的数据是否规范合法
                log.error("【调用失败】请求API系统返回失败，请检测Post给API的数据是否规范合法");
                resultListener.onFailByReturnCodeFail(JsonUtil.Json2Object(resultJson, resClazz));
                return;
            } else {
                //剔除不需要验签的响应数据
                boolean flag = resClazz != WxReportRes.class && resClazz != WxTransfersRes.class && resClazz != WxGetTransferInfoRes.class;
                //数据验签，服务器支付请求数据被劫持会导致验签失败
                if (flag && !Signature.checkIsSignValidFromResponseString(payResultString, key)) {
                    log.error("【调用失败】请求API返回的数据签名验证失败，有可能数据被篡改了");
                    resultListener.onFailBySignInvalid(JsonUtil.Json2Object(resultJson, resClazz));
                    return;
                }

                String errorCode = resultJson.getString("err_code");
                String errorCodeDes = resultJson.getString("err_code_des");
                String resultCode = resultJson.getString("result_code");
                if (resultCode.equals("SUCCESS")) {
                    log.info("【调用成功】");
                    resultListener.onSuccess(JsonUtil.Json2Object(resultJson, resClazz));
                    return;
                } else {
                    // 出现业务错误
                    log.error("业务返回失败");
                    log.error("err_code:" + errorCode);
                    log.error("【调用失败】: " + errorCodeDes);
                    resultListener.onFail(JsonUtil.Json2Object(resultJson, resClazz));
                    return;
                }
            }

        }

    }

    public interface ResultListener<Res extends WxBaseRes> {

        // API返回ReturnCode不合法，支付请求逻辑错误，请仔细检测传过去的每一个参数是否合法，或是看API能否被正常访问
        void onFailByReturnCodeError(Res t);

        // API返回ReturnCode为FAIL，支付API系统返回失败，请检测Post给API的数据是否规范合法
        void onFailByReturnCodeFail(Res t);

        // 支付请求API返回的数据签名验证失败，有可能数据被篡改了
        void onFailBySignInvalid(Res t);

        // 失败
        void onFail(Res t);

        // 成功
        void onSuccess(Res t);

    }

    private WxDownloadBillRes convertToWxDownloadBillRes(String payResultString) {
        WxDownloadBillRes downloadBillRes = new WxDownloadBillRes();
        List<WxDownloadBill> bills = new ArrayList<>();
        int i = payResultString.indexOf("`");
        int j = payResultString.indexOf("总");
        String substring = payResultString.substring(i, j - 2);
        String[] temp = substring.split(",`\r\n`");
        for (int k = 0; k < temp.length; k++) {
            String[] order = temp[k].replace("`", "").split(",");
            WxDownloadBill bill = new WxDownloadBill();
            bill.setTrade_time(order[0]);
            bill.setAppid(order[1]);
            bill.setMch_id(order[2]);
            bill.setSub_mch_id(order[3]);
            bill.setDevice_info(order[4]);
            bill.setTransaction_id(order[5]);
            bill.setOut_trade_no(order[6]);
            bill.setOpenid(order[7]);
            bill.setTrade_type(order[8]);
            bill.setTrade_status(order[9]);
            bill.setBank_type(order[10]);
            bill.setFee_type(order[11]);
            bill.setOrder_pay(order[12]);
            bill.setVoucher_amount(order[13]);
            bill.setRefund_number(order[14]);
            bill.setOut_refund_no(order[15]);
            bill.setRefund_amount(order[16]);
            bill.setRefund_amount_voucher(order[17]);
            bill.setRefunds_type(order[18]);
            bill.setRefunds_status(order[19]);
            bill.setCommodity_name(order[20]);
            bill.setData_packet(order[21]);
            bill.setService_charge(order[22]);
            bill.setRate(order[23]);
            bill.setOrder_amount(order[24]);
            bill.setApplication_refund_amount(order[25]);
            bills.add(bill);
        }
        downloadBillRes.setBills(bills);
        return downloadBillRes;
    }

    private WxDownloadFundFlowRes convertToWxDownloadFundFlowRes(String payResultString) {
        WxDownloadFundFlowRes downloadFundFlowRes = new WxDownloadFundFlowRes();
        List<WxDownloadFundFlow> downloadFundFlows = new ArrayList<>();
        int i = payResultString.indexOf("`");
        int j = payResultString.indexOf("资金流水总笔数");
        String substring = payResultString.substring(i, j);
        String[] temp = substring.split("\r\n`");
        for (int k = 0; k < temp.length; k++) {
            String[] order = temp[k].replace("`", "").split(",");
            WxDownloadFundFlow downloadFundFlow = new WxDownloadFundFlow();
            downloadFundFlow.setTrade_time(order[0]);
            downloadFundFlow.setTransaction_id(order[1]);
            downloadFundFlow.setFlow_number(order[2]);
            downloadFundFlow.setBusiness_name(order[3]);
            downloadFundFlow.setBusiness_type(order[4]);
            downloadFundFlow.setInout_type(order[5]);
            downloadFundFlow.setInout_money(order[6]);
            downloadFundFlow.setAccount_balance(order[7]);
            downloadFundFlow.setApplicant(order[8]);
            downloadFundFlow.setRemarks(order[9]);
            downloadFundFlow.setVoucher_number(order[10]);
            downloadFundFlows.add(downloadFundFlow);
        }
        downloadFundFlowRes.setDownloadFundFlows(downloadFundFlows);
        return downloadFundFlowRes;
    }

    private WxBatchQueryCommentRes convertToWxBatchQueryCommentRes(String payResultString) {
        WxBatchQueryCommentRes batchQueryCommentRes = new WxBatchQueryCommentRes();
        List<WxBatchQueryComment> batchQueryComments = new ArrayList<>();
        String[] temp = payResultString.split("\n`");
        for (int k = 1; k < temp.length; k++) {
            String[] order = temp[k].replace("`", "").split(",");
            WxBatchQueryComment batchQueryComment = new WxBatchQueryComment();
            batchQueryComment.setTrade_time(order[0]);
            batchQueryComment.setTransaction_id(order[1]);
            batchQueryComment.setReview_star(order[2]);
            if (order.length == 4) {
                batchQueryComment.setReview(order[3]);
            }
            batchQueryComments.add(batchQueryComment);
        }
        batchQueryCommentRes.setOffset(Integer.parseInt(temp[0].replace("`", "")));
        batchQueryCommentRes.setBatchQueryComments(batchQueryComments);
        return batchQueryCommentRes;
    }

}
