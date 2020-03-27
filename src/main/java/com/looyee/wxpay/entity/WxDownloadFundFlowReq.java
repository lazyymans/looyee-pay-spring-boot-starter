package com.looyee.wxpay.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class WxDownloadFundFlowReq extends WxBaseReq {

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
     * 签名类型，目前支持HMAC-SHA256
     * String(32)
     */
    private String sign_type;

    /**
     * 下载对账单的日期，格式：20140603
     * String(8)
     */
    private String bill_date;

    /**
     * 账单的资金来源账户：
     *
     * Basic  基本账户
     *
     * Operation 运营账户
     *
     * Fees 手续费账户
     * String(8)
     */
    private String account_type;

    /**
     * 非必传参数，固定值：GZIP，返回格式为.gzip的压缩包账单。不传则默认为数据流形式。
     * String(8)
     */
    private String tar_type;
}
