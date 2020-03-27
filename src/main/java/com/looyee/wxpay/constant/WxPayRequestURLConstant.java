package com.looyee.wxpay.constant;

public class WxPayRequestURLConstant {

    //预订单
    public static final String UNIFIEDORDER = "https://api.mch.weixin.qq.com/pay/unifiedorder";
    //订单查询
    public static final String ORDERQUERY = "https://api.mch.weixin.qq.com/pay/orderquery";
    //订单关闭
    public static final String CLOSEORDER = "https://api.mch.weixin.qq.com/pay/closeorder";
    //订单退款
    public static final String REFUND = "https://api.mch.weixin.qq.com/secapi/pay/refund";
    //订单退款查询
    public static final String REFUNDQUERY = "https://api.mch.weixin.qq.com/pay/refundquery";
    //下载对账单
    public static final String DOWNLOADBILL = "https://api.mch.weixin.qq.com/pay/downloadbill";
    //下载资金账单
    public static final String DOWNLOADFUNDFLOW = "https://api.mch.weixin.qq.com/pay/downloadfundflow";
    //交易保障
    public static final String REPORT = "https://api.mch.weixin.qq.com/payitil/report";
    //拉取订单评价数据
    public static final String BATCHQUERYCOMMENT = "https://api.mch.weixin.qq.com/billcommentsp/batchquerycomment";
    //提交付款码支付
    public static final String MICROPAY = "https://api.mch.weixin.qq.com/pay/micropay";
    //撤销订单
    public static final String REVERSE = "https://api.mch.weixin.qq.com/secapi/pay/reverse";
    //授权码查询openid
    public static final String AUTHCODETOOPENID = "https://api.mch.weixin.qq.com/tools/authcodetoopenid";
    //转换成短链接
    public static final String SHORTURL = "https://api.mch.weixin.qq.com/tools/shorturl";
    //企业付款到零钱
    public static final String TRANSFERS = "https://api.mch.weixin.qq.com/mmpaymkttransfers/promotion/transfers";
    //查询企业付款到零钱
    public static final String GETTRANSFERINFO = "https://api.mch.weixin.qq.com/mmpaymkttransfers/gettransferinfo";
    //企业付款到银行卡
    public static final String PAY_BANK = "https://api.mch.weixin.qq.com/mmpaysptrans/pay_bank";
    //查询企业付款到银行卡
    public static final String QUERY_BANK = "https://api.mch.weixin.qq.com/mmpaysptrans/query_bank";

}
