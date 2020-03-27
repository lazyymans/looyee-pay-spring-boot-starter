package com.looyee.wxpay.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class WxBatchQueryComment {

    private String trade_time;//﻿交易时间
    private String transaction_id;//微信订单号
    private String review_star;//评论星级
    private String review;//评论星级

}
