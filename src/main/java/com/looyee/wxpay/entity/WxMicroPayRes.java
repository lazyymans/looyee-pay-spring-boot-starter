package com.looyee.wxpay.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author lxw
 * @date 2018/5/19
 * @description
 */
@Setter
@Getter
@ToString
public class WxMicroPayRes extends WxBaseRes {

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
     * 调用接口提交的公众账号ID
     */
    private String appid;

    /**
     * 调用接口提交的商户号
     */
    private String mch_id;

    /**
     * 微信分配的子商户公众账号ID
     */
    private String sub_appid;

    /**
     * 微信支付分配的子商户号
     */
    private String sub_mch_id;

    /**
     * 调用接口提交的终端设备号，
     */
    private String device_info;

    /**
     * 微信返回的随机字符串
     */
    private String nonce_str;

    /**
     * 微信返回的签名，详见签名算法(https://pay.weixin.qq.com/wiki/doc/api/jsapi_sl.php?chapter=4_3)
     */
    private String sign;

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

    /**
     * 用户在商户appid 下的唯一标识
     */
    private String openid;

    /**
     * 用户是否关注公众账号，仅在公众账号类型支付有效，取值范围：Y或N;Y-关注;N-未关注
     */
    private String is_subscribe;

    /**
     * 	子商户appid下用户唯一标识，如需返回则请求时需要传sub_appid
     */
    private String sub_openid;

    /**
     * 用户是否关注子公众账号，仅在公众账号类型支付有效，取值范围：Y或N;Y-关注;N-未关注
     */
    private String sub_is_subscribe;

    /**
     * 支付类型为MICROPAY(即扫码支付)
     */
    private String trade_type;

    /**
     * 银行类型，采用字符串类型的银行标识，值列表详见银行类型
     */
    private String bank_type;

    /**
     * 符合ISO 4217标准的三位字母代码，默认人民币：CNY，其他值列表详见货币类型
     */
    private String fee_type;

    /**
     * 	订单总金额，单位为分，只能为整数，详见支付金额
     */
    private Integer total_fee;

    /**
     * 当订单使用了免充值型优惠券后返回该参数，应结订单金额=订单金额-免充值优惠券金额。
     */
    private String settlement_total_fee;

    /**
     * “代金券”金额<=订单金额，订单金额-“代金券”金额=现金支付金额，详见支付金额
     */
    private String coupon_fee;

    /**
     * 	符合ISO 4217标准的三位字母代码，默认人民币：CNY，其他值列表详见货币类型
     */
    private String cash_fee_type;

    /**
     * 订单现金支付金额，详见支付金额
     */
    private String cash_fee;

    /**
     * 微信支付订单号
     */
    private String transaction_id;

    /**
     * 商户系统内部订单号，要求32个字符内，只能是数字、大小写字母_-|*且在同一个商户号下唯一。
     */
    private String out_trade_no;

    /**
     * 	商家数据包，原样返回
     */
    private String attach;

    /**
     * 	订单生成时间，格式为yyyyMMddHHmmss，如2009年12月25日9点10分10秒表示为20091225091010。详见时间规则
     */
    private String time_end;

    /**
     * 新增返回，单品优惠功能字段，需要接入请见详细说明
     */
    private String promotion_detail;

}
