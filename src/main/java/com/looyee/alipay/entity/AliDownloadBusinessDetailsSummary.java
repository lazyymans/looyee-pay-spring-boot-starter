package com.looyee.alipay.entity;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class AliDownloadBusinessDetailsSummary implements java.io.Serializable {
    private static final long serialVersionUID = 1L;

    // 门店编号
    private String shopCode;

    // 门店名称
    private String shopName;

    // 交易订单总笔数
    private Integer transactionOrders;

    // 退款订单总笔数
    private Integer refundOrders;

    // 订单金额（元）
    private BigDecimal totalOrderAmount;

    // 商家实收（元）
    private BigDecimal realIncomeAmount;

    // 支付宝优惠（元）
    private BigDecimal preferentialAmount;

    // 商家优惠（元）
    private BigDecimal shipperPreferentialAmount;

    // 卡消费金额（元）
    private BigDecimal cardAmount;

    // 服务费（元）
    private BigDecimal serviceChargeAmount;

    // 分润（元）
    private BigDecimal shareMoisten;

    // 实收净额（元）
    private BigDecimal netRealIncome;


}


