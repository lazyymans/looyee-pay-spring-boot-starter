package com.looyee.wxpay.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class WxReportReq extends WxBaseReq {

    /**
     * 微信分配的公众账号ID
     * String(32)
     */
    private String appid;

    /**
     * 微信支付分配的商户号
     * String(32)
     */
    private String mch_id;

    /**
     * 微信分配的子商户公众账号ID，如需在支付完成后获取sub_openid则此参数必传。
     * String(32)
     */
    private String sub_appid;

    /**
     * 微信支付分配的子商户号
     * String(32)
     */
    private String sub_mch_id;

    /**
     * 终端设备号(门店号或收银设备ID)，注意：PC网页或JSAPI支付请传"WEB"
     * String(32)
     */
    private String device_info;

    /**
     * 随机字符串，不长于32位。推荐随机数生成算法(https://pay.weixin.qq.com/wiki/doc/api/jsapi_sl.php?chapter=4_3)
     * String(32)
     */
    private String nonce_str;

    /**
     * 签名，详见签名生成算法(https://pay.weixin.qq.com/wiki/doc/api/jsapi_sl.php?chapter=4_3)
     * String(32)
     */
    private String sign;

    /**
     * 签名类型，目前支持HMAC-SHA256和MD5，默认为MD5
     * String(32)
     */
    private String sign_type;

    /**
     * 上报对应的接口的完整URL，类似：
     *
     * https://api.mch.weixin.qq.com/pay/unifiedorder
     *
     * 对于刷卡支付，为更好的和商户共同分析一次业务行为的整体耗时情况，对于两种接入模式，请都在门店侧对一次刷卡行为进行一次单独的整体上报，上报URL指定为：
     *
     * https://api.mch.weixin.qq.com/pay/micropay/total
     *
     * 关于两种接入模式具体可参考本文档章节：刷卡支付商户接入模式
     *
     * 其它接口调用仍然按照调用一次，上报一次来进行。
     */
    private String interface_url;

    //这里两个耗时字段，看相关借口使用哪一个
    /**
     * 	接口耗时情况，单位为毫秒
     */
    private Integer execute_time_;

    /**
     * 	接口耗时情况，单位为毫秒
     */
    private Integer execute_time;

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
     * 商户系统内部的订单号,商户可以在上报时提供相关商户订单号方便微信支付更好的提高服务质量
     */
    private String out_trade_no;

    /**
     * 发起接口调用时的机器IP
     */
    private String user_ip;

    /**
     * 系统时间，格式为yyyyMMddHHmmss，如2009年12月27日9点10分10秒表示为20091227091010。其他详见时间规则
     */
    private String time;

}
