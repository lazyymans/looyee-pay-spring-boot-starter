package com.looyee.wxpay.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * INVALID_REQUEST	参数错误	参数格式有误或者未按规则上传	订单重入时，要求参数值与原请求一致，请确认参数问题
 * NOAUTH	商户无此接口权限	商户未开通此接口权限	请商户前往申请此接口权限
 * NOTENOUGH	余额不足	用户帐号余额不足	用户帐号余额不足，请用户充值或更换支付卡后再支付
 * ORDERPAID	商户订单已支付	商户订单已支付，无需重复操作	商户订单已支付，无需更多操作
 * ORDERCLOSED	订单已关闭	当前订单已关闭，无法支付	当前订单已关闭，请重新下单
 * SYSTEMERROR	系统错误	系统超时	系统异常，请用相同参数重新调用
 * APPID_NOT_EXIST	APPID不存在	参数中缺少APPID	请检查APPID是否正确
 * MCHID_NOT_EXIST	MCHID不存在	参数中缺少MCHID	请检查MCHID是否正确
 * APPID_MCHID_NOT_MATCH	appid和mch_id不匹配	appid和mch_id不匹配	请确认appid和mch_id是否匹配
 * LACK_PARAMS	缺少参数	缺少必要的请求参数	请检查参数是否齐全
 * OUT_TRADE_NO_USED	商户订单号重复	同一笔交易不能多次提交	请核实商户订单号是否重复提交
 * SIGNERROR	签名错误	参数签名结果不正确	请检查签名参数和方法是否都符合签名算法要求
 * XML_FORMAT_ERROR	XML格式错误	XML格式错误	请检查XML参数格式是否正确
 * REQUIRE_POST_METHOD	请使用post方法	未使用post传递参数 	请检查请求参数是否通过post方法提交
 * POST_DATA_EMPTY	post数据为空	post数据不能为空	请检查post数据是否为空
 * NOT_UTF8	编码格式错误	未使用指定编码格式	请使用NOT_UTF8编码格式
 */
@Setter
@Getter
@ToString
public class WxTransfersRes extends WxBaseRes {

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

    //以下字段在return_code为SUCCESS的时候有返回
    /**
     * 申请商户号的appid或商户号绑定的appid（企业号corpid即为此appId）
     */
    private String mch_appid;

    /**
     * 微信支付分配的商户号
     */
    private String mchid;

    /**
     * 微信支付分配的终端设备号
     */
    private String device_info;

    /**
     * 随机字符串，不长于32位
     */
    private String nonce_str;

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

    //以下字段在return_code 和result_code都为SUCCESS的时候有返回
    /**
     * 商户订单号，需保持历史全局唯一性(只能是字母或者数字，不能包含有其他字符)
     */
    private String partner_trade_no;

    /**
     * 企业付款成功，返回的微信付款单号
     */
    private String payment_no;

    /**
     * 	企业付款成功时间
     */
    private String payment_time;

}
