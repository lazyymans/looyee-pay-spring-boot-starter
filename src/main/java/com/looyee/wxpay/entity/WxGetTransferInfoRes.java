package com.looyee.wxpay.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class WxGetTransferInfoRes extends WxBaseRes {

    /**
     * SUCCESS/FAIL
     *
     * 此字段是通信标识，非交易标识，交易是否成功需要查看result_code来判断
     */
    private String return_code;

    /**
     * 返回信息，如非空，为错误原因
     *
     * 签名失败
     *
     * 参数格式校验错误
     */
    private String return_msg;

    /**
     * 业务结果
     * SUCCESS/FAIL
     */
    private String result_code;

    /**
     * 错误代码
     * 详细参见第6节错误列表
     */
    private String err_code;

    /**
     * 错误代码描述
     * 错误返回的信息描述
     */
    private String err_code_des;

    //以下字段在return_code为SUCCESS的时候有返回
    /**
     * 申请商户号的appid或商户号绑定的appid（企业号corpid即为此appId）
     */
    private String appid;

    /**
     * 微信支付分配的商户号
     */
    private String mch_id;

    /**
     * 商户订单号，需保持历史全局唯一性(只能是字母或者数字，不能包含有其他字符)
     */
    private String partner_trade_no;

    /**
     * 调用企业付款API时，微信系统内部产生的单号
     */
    private String detail_id;

    /**
     * SUCCESS:转账成功
     *
     * FAILED:转账失败
     *
     * PROCESSING:处理中
     */
    private String status;

    /**
     * 如果失败则有失败原因
     */
    private String reason;

    /**
     * 转账的openid
     */
    private String openid;

    /**
     * 收款用户姓名
     */
    private String transfer_name;

    /**
     * 付款金额单位为“分”
     */
    private Integer payment_amount;

    /**
     * 发起转账的时间
     */
    private String transfer_time;

    /**
     * 企业付款成功时间
     */
    private String payment_time;

    /**
     * 	企业付款备注
     */
    private String desc;

}
