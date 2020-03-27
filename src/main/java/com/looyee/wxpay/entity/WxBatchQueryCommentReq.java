package com.looyee.wxpay.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class WxBatchQueryCommentReq extends WxBaseReq {

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
     * 按用户评论时间批量拉取的起始时间，格式为yyyyMMddHHmmss
     * String(256)
     */
    private String begin_time;
    /**
     * 按用户评论时间批量拉取的结束时间，格式为yyyyMMddHHmmss
     * String(256)
     */
    private String end_time;

    /**
     * 指定从某条记录的下一条开始返回记录。接口调用成功时，会返回本次查询最后一条数据的offset。商户需要翻页时，应该把本次调用返回的offset 作为下次调用的入参。注意offset是评论数据在微信支付后台保存的索引，未必是连续的
     */
    private Integer offset;

    /**
     * 一次拉取的条数, 最大值是200，默认是200
     */
    private Integer limit;

}
