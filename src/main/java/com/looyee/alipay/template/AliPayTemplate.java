package com.looyee.alipay.template;

import com.alipay.api.AlipayApiException;
import com.alipay.api.domain.*;
import com.alipay.api.request.*;
import com.alipay.api.response.AlipayDataDataserviceBillDownloadurlQueryResponse;
import com.looyee.alipay.billparse.AliBillParse;
import com.looyee.alipay.business.AliPayBusiness;
import com.looyee.alipay.common.AliFileUtil;
import com.looyee.alipay.config.AliPayProperties;
import com.looyee.alipay.listener.*;
import com.looyee.alipay.notify.AliPayNotify;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Date;

@Slf4j
@Component
public class AliPayTemplate {

    @Autowired
    private AliPayBusiness payBusiness;

    @Autowired(required = false)
    private AliPayProperties payProperties;

    @Autowired
    private AliBillParse billParse;

    @Autowired
    private AliPayNotify payNotify;

    /**
     * 统一收单交易支付接口
     * 使用场景：收银员使用扫码设备读取用户手机支付宝“付款码”/声波获取设备（如麦克风）读取用户手机支付宝的声波信息后，将二维码或条码信息/声波信息通过本接口上送至支付宝发起支付。
     *
     * @param model
     * @return
     */
    public AlipayTradePayResponseListener pay(AlipayTradePayModel model) {
        AlipayTradePayRequest request = new AlipayTradePayRequest();
        request.setBizModel(model);
        AlipayTradePayResponseListener listener = new AlipayTradePayResponseListener();
        try {
            payBusiness.execute(request, listener);
        } catch (AlipayApiException e) {
            log.error("", e);
        }
        return listener;
    }

    /**
     * 统一收单线下交易预创建
     * 使用场景：收银员通过收银台或商户后台调用支付宝接口，生成二维码后，展示给用户，由用户扫描二维码完成订单支付。
     *
     * @param model
     * @return
     */
    public AlipayTradePrecreateResponseListener precreate(AlipayTradePrecreateModel model) {
        AlipayTradePrecreateRequest request = new AlipayTradePrecreateRequest();
        request.setBizModel(model);
        AlipayTradePrecreateResponseListener listener = new AlipayTradePrecreateResponseListener();
        try {
            payBusiness.execute(request, listener);
        } catch (AlipayApiException e) {
            log.error("", e);
        }
        return listener;
    }

    /**
     * app支付接口2.0
     * 使用场景：外部商户APP唤起快捷SDK创建订单并支付
     *
     * @param model
     * @return
     */
    public AlipayTradeAppPayResponseListener appPay(AlipayTradeAppPayModel model) {
        AlipayTradeAppPayRequest request = new AlipayTradeAppPayRequest();
        request.setBizModel(model);
        AlipayTradeAppPayResponseListener listener = new AlipayTradeAppPayResponseListener();
        try {
            payBusiness.sdkExecute(request, listener);
        } catch (AlipayApiException e) {
            log.error("", e);
        }
        return listener;
    }

    /**
     * 手机网站支付接口2.0
     * 使用场景：外部商户创建订单并支付
     *
     * @param model
     * @return
     */
    public AlipayTradeWapPayResponseListener wapPay(AlipayTradeWapPayModel model) {
        AlipayTradeWapPayRequest request = new AlipayTradeWapPayRequest();
        request.setBizModel(model);
        AlipayTradeWapPayResponseListener listener = new AlipayTradeWapPayResponseListener();
        try {
            payBusiness.pageExecute(request, listener);
        } catch (AlipayApiException e) {
            log.error("", e);
        }
        return listener;
    }

    /**
     * 统一收单下单并支付页面接口
     * 使用场景：PC场景下单并支付
     *
     * @param model
     * @return
     */
    public AlipayTradePagePayResponseListener pagePay(AlipayTradePagePayModel model) {
        AlipayTradePagePayRequest request = new AlipayTradePagePayRequest();
        request.setBizModel(model);
        AlipayTradePagePayResponseListener listener = new AlipayTradePagePayResponseListener();
        try {
            payBusiness.pageExecute(request, listener);
        } catch (AlipayApiException e) {
            log.error("", e);
        }
        return listener;
    }

    /**
     * 回调通知
     *
     * @param request
     * @return
     */
    public String aliPayNotify(HttpServletRequest request) {
        return payNotify.doNotifyBusiness(request);
    }

    /**
     * 统一收单交易创建接口
     * 使用场景：商户通过该接口进行交易的创建下单
     *
     * @param model
     * @return
     */
    public AlipayTradeCreateResponseListener create(AlipayTradeCreateModel model) {
        AlipayTradeCreateRequest request = new AlipayTradeCreateRequest();
        request.setBizModel(model);
        AlipayTradeCreateResponseListener listener = new AlipayTradeCreateResponseListener();
        try {
            payBusiness.execute(request, listener);
        } catch (AlipayApiException e) {
            log.error("", e);
        }
        return listener;
    }

    /**
     * 统一收单线下交易查询
     * 使用场景：该接口提供所有支付宝支付订单的查询，商户可以通过该接口主动查询订单状态，完成下一步的业务逻辑。 需要调用查询接口的情况： 当商户后台、网络、服务器等出现异常，商户系统最终未接收到支付通知； 调用支付接口后，返回系统错误或未知交易状态情况； 调用alipay.trade.pay，返回INPROCESS的状态； 调用alipay.trade.cancel之前，需确认支付状态；
     *
     * @param model
     * @return
     */
    public AlipayTradeQueryResponseListener query(AlipayTradeQueryModel model) {
        AlipayTradeQueryRequest request = new AlipayTradeQueryRequest();
        request.setBizModel(model);
        AlipayTradeQueryResponseListener listener = new AlipayTradeQueryResponseListener();
        try {
            payBusiness.execute(request, listener);
        } catch (AlipayApiException e) {
            log.error("", e);
        }
        return listener;
    }

    /**
     * 统一收单交易撤销接口
     * 使用场景：支付交易返回失败或支付系统超时，调用该接口撤销交易。如果此订单用户支付失败，支付宝系统会将此订单关闭；如果用户支付成功，支付宝系统会将此订单资金退还给用户。 注意：只有发生支付系统超时或者支付结果未知时可调用撤销，其他正常支付的单如需实现相同功能请调用申请退款API。提交支付交易后调用【查询订单API】，没有明确的支付结果再调用【撤销订单API】
     *
     * @param model
     * @return
     */
    public AlipayTradeCancelResponseListener cancel(AlipayTradeCancelModel model) {
        AlipayTradeCancelRequest request = new AlipayTradeCancelRequest();
        request.setBizModel(model);
        AlipayTradeCancelResponseListener listener = new AlipayTradeCancelResponseListener();
        try {
            payBusiness.execute(request, listener);
        } catch (AlipayApiException e) {
            log.error("", e);
        }
        return listener;
    }

    /**
     * 统一收单交易关闭接口
     * 使用场景：用于交易创建后，用户在一定时间内未进行支付，可调用该接口直接将未付款的交易进行关闭。
     *
     * @param model
     * @return
     */
    public AlipayTradeCloseResponseListener close(AlipayTradeCloseModel model) {
        AlipayTradeCloseRequest request = new AlipayTradeCloseRequest();
        request.setBizModel(model);
        AlipayTradeCloseResponseListener listener = new AlipayTradeCloseResponseListener();
        try {
            payBusiness.execute(request, listener);
        } catch (AlipayApiException e) {
            log.error("", e);
        }
        return listener;
    }

    /**
     * 统一收单交易退款接口
     * 使用场景：当交易发生之后一段时间内，由于买家或者卖家的原因需要退款时，卖家可以通过退款接口将支付款退还给买家，支付宝将在收到退款请求并且验证成功之后，按照退款规则将支付款按原路退到买家帐号上。 交易超过约定时间（签约时设置的可退款时间）的订单无法进行退款 支付宝退款支持单笔交易分多次退款，多次退款需要提交原支付订单的商户订单号和设置不同的退款单号。一笔退款失败后重新提交，要采用原来的退款单号。总退款金额不能超过用户实际支付金额
     *
     * @param model
     * @return
     */
    public AlipayTradeRefundResponseListener refund(AlipayTradeRefundModel model) {
        AlipayTradeRefundRequest request = new AlipayTradeRefundRequest();
        request.setBizModel(model);
        AlipayTradeRefundResponseListener listener = new AlipayTradeRefundResponseListener();
        try {
            payBusiness.execute(request, listener);
        } catch (AlipayApiException e) {
            log.error("", e);
        }
        return listener;
    }

    /**
     * 统一收单退款页面接口
     * 使用场景：当交易发生之后一段时间内，由于买家或者卖家的原因需要退款时，卖家可以通过退款页面接口将支付款退还给买家，支付宝将在收到退款请求并且验证成功之后，按照退款规则将支付款按原路退到买家帐号上。 目前该接口用于信用退款场景，通过biz_type指定信用退款。支付宝页面会提示用户退款成功或失败，退款处理完成后支付宝回跳到商户请求指定的回跳地址页面。
     *
     * @param model
     * @return
     */
    public AlipayTradePageRefundResponseListener pageRefund(AlipayTradePageRefundModel model) {
        AlipayTradePageRefundRequest request = new AlipayTradePageRefundRequest();
        request.setBizModel(model);
        AlipayTradePageRefundResponseListener listener = new AlipayTradePageRefundResponseListener();
        try {
            payBusiness.pageExecute(request, listener);
        } catch (AlipayApiException e) {
            log.error("", e);
        }
        return listener;
    }

    /**
     * 统一收单交易退款查询
     * 使用场景：商户可使用该接口查询自已通过alipay.trade.refund或alipay.trade.refund.apply提交的退款请求是否执行成功。 该接口的返回码10000，仅代表本次查询操作成功，不代表退款成功。如果该接口返回了查询数据，且refund_status为空或为REFUND_SUCCESS，则代表退款成功，如果没有查询到则代表未退款成功，可以调用退款接口进行重试。重试时请务必保证退款请求号一致。
     *
     * @param model
     * @return
     */
    public AlipayTradeFastpayRefundQueryResponseListener fastpayRefundQuery(AlipayTradeFastpayRefundQueryModel model) {
        AlipayTradeFastpayRefundQueryRequest request = new AlipayTradeFastpayRefundQueryRequest();
        request.setBizModel(model);
        AlipayTradeFastpayRefundQueryResponseListener listener = new AlipayTradeFastpayRefundQueryResponseListener();
        try {
            payBusiness.execute(request, listener);
        } catch (AlipayApiException e) {
            log.error("", e);
        }
        return listener;
    }

    /**
     * 单笔转账接口(新版接口)
     * 使用场景：单笔转账接口是基于支付宝的资金处理能力，为了满足支付宝商家的转账需求，针对有部分开发能力的商家，提供通过API接口完成企业自身支付宝账户到支付宝账户、企业自身支付宝账户到银行卡的转账功能。 适用于：C2C现金红包的红包领取、B2C现金红包的红包发放、B2C单笔转账到支付宝账户、B2C单笔转账到银行卡等。
     *
     * @param model
     * @return
     */
    public AlipayFundTransUniTransferResponseListener transUniTransfer(AlipayFundTransUniTransferModel model) {
        AlipayFundTransUniTransferRequest request = new AlipayFundTransUniTransferRequest();
        request.setBizModel(model);
        AlipayFundTransUniTransferResponseListener listener = new AlipayFundTransUniTransferResponseListener();
        try {
            payBusiness.execute(request, listener);
        } catch (AlipayApiException e) {
            log.error("", e);
        }
        return listener;
    }

    /**
     * 查询转账订单接口
     * 使用场景：商户可通过该接口查询转账订单的状态、支付时间等相关信息，主要应用于B2C转账订单查询的场景
     *
     * @param model
     * @return
     */
    public AlipayFundTransOrderQueryResponseListener transOrderQuery(AlipayFundTransOrderQueryModel model) {
        AlipayFundTransOrderQueryRequest request = new AlipayFundTransOrderQueryRequest();
        request.setBizModel(model);
        AlipayFundTransOrderQueryResponseListener listener = new AlipayFundTransOrderQueryResponseListener();
        try {
            payBusiness.execute(request, listener);
        } catch (AlipayApiException e) {
            log.error("", e);
        }
        return listener;
    }

    /**
     * 统一收单交易结算接口
     * 使用场景：用于在线下场景交易支付后，进行卖家与第三方（如供应商或平台商）基于交易金额的结算。
     *
     * @param model
     * @return
     */
    public AlipayTradeOrderSettleResponseListener orderSettle(AlipayTradeOrderSettleModel model) {
        AlipayTradeOrderSettleRequest request = new AlipayTradeOrderSettleRequest();
        request.setBizModel(model);
        AlipayTradeOrderSettleResponseListener listener = new AlipayTradeOrderSettleResponseListener();
        try {
            payBusiness.execute(request, listener);
        } catch (AlipayApiException e) {
            log.error("", e);
        }
        return listener;
    }

    /**
     * 查询对账单下载地址
     * 使用场景：为方便商户快速查账，支持商户通过本接口获取商户离线账单下载地址
     *
     * @param model
     */
    public void dataServiceBillDownloadUrlQuery(AlipayDataDataserviceBillDownloadurlQueryModel model) {
        AlipayDataDataserviceBillDownloadurlQueryRequest request = new AlipayDataDataserviceBillDownloadurlQueryRequest();
        request.setBizModel(model);
        AlipayDataDataServiceBillDownloadUrlQueryResponseListener listener = new AlipayDataDataServiceBillDownloadUrlQueryResponseListener();
        try {
            payBusiness.execute(request, listener);
        } catch (AlipayApiException e) {
            log.error("", e);
            return;
        }
        AlipayDataDataserviceBillDownloadurlQueryResponse response = listener.getResponse();
        if (response.isSuccess()) {
            // 获取下载地址url
            String url = response.getBillDownloadUrl();
            String billFileZipPath = payProperties.getBillFileZipPath();
            String billFileUnZipPath = payProperties.getBillFileUnZipPath();
            if (StringUtils.isNotBlank(billFileZipPath) && StringUtils.isNotBlank(billFileUnZipPath)) {
                log.info("即将创建保存ZIP的路径{}", billFileZipPath);
                File zipSaveFile = new File(billFileZipPath);
                if (!zipSaveFile.exists()) {
                    boolean mkdirs = zipSaveFile.mkdirs();
                    if (mkdirs) {
                        log.info("创建保存ZIP的路径{}成功", billFileZipPath);
                    } else {
                        log.info("创建保存ZIP的路径{}失败", billFileZipPath);
                    }
                } else {
                    log.info("已经存在保存ZIP{}路径的文件夹", billFileZipPath);
                }
                log.info("即将创建的ZIP解压路径{}", billFileUnZipPath);
                File zipUnZipSave = new File(billFileUnZipPath);
                if (!zipUnZipSave.exists()) {
                    boolean mkdirs = zipUnZipSave.mkdirs();
                    if (mkdirs) {
                        log.info("创建的ZIP解压路径{}成功", billFileUnZipPath);
                    } else {
                        log.info("创建的ZIP解压路径{}失败", billFileUnZipPath);
                    }
                } else {
                    log.info("已经存在ZIP解压{}路径的文件夹", billFileUnZipPath);
                }
                // 设置下载后生成Zip目录
                String newZip = billFileZipPath + new Date().getTime() + ".zip";
                log.info("下载的zip目录{}", newZip);
                // 开始下载
                try {
                    AliFileUtil.downloadNet(url, newZip);
                    log.info("解压的zip目录{}", billFileUnZipPath);
                    // 解压到指定目录
                    AliFileUtil.unZip(newZip, billFileUnZipPath);
                } catch (Exception e) {
                    log.error("", e);
                }
                // 遍历文件 获取需要的汇整csv
                File[] fs = new File(billFileUnZipPath).listFiles();
                parseAliBill(fs);
                // 解析完成之后删除临时目录
                try {
                    FileUtils.deleteDirectory(zipSaveFile);
                    FileUtils.deleteDirectory(zipUnZipSave);
                } catch (IOException e) {
                    log.error("", e);
                }
            }
        } else {

        }
    }

    private void parseAliBill(File[] files) {
        if (files == null || files.length <= 0) {
            log.info("支付宝下载对账单为空无法解析");
            return;
        }
        String contains1 = "业务明细";
        String contains2 = "账务明细";
        String contains3 = "(汇总)";
        for (File file : files) {
            String name = file.getName();
            // 判断是否为 业务明细 账单
            if (name.contains(contains1)) {
                // 判断是否为 业务明细(汇总) 账单
                if (name.contains(contains3)) {
                    billParse.parseAliBusinessDetailsBillSummary(file);
                } else {
                    billParse.parseAliBusinessDetailsBill(file);
                }
            }
            // 判断是否为 账务明细 账单
            else if (name.contains(contains2)) {
                // 判断是否为 账务明细(汇总) 账单
                if (name.contains(contains3)) {
                    billParse.parseAliAccountDetailsBillSummary(file);
                } else {
                    billParse.parseAliAccountDetailsBill(file);
                }
            }
        }
    }


}
