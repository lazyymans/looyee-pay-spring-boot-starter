package com.looyee.wxpay.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class WxUnifiedOrderReq extends WxBaseReq {

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
     * Y，传入Y时，支付成功消息和支付详情页将出现开票入口。需要在微信支付商户平台或微信公众平台开通电子发票功能，传此字段才可生效
     * String(8)
     */
    private String receipt;

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
     * 商品描述交易字段格式根据不同的应用场景建议按照以下格式上传：
     *
     * （1）PC网站——传入浏览器打开的网站主页title名-实际商品名称，例如：腾讯充值中心-QQ会员充值；
     *
     * （2） 公众号——传入公众号名称-实际商品名称，例如：腾讯形象店- image-QQ公仔；
     *
     * （3） H5——应用在浏览器网页上的场景，传入浏览器打开的移动网页的主页title名-实际商品名称，例如：腾讯充值中心-QQ会员充值；
     *
     * （4） 线下门店——门店品牌名-城市分店名-实际商品名称，例如： image形象店-深圳腾大- QQ公仔）
     *
     * （5） APP——需传入应用市场上的APP名字-实际商品名称，天天爱消除-游戏充值。
     * String(128)
     */
    private String body;

    /**
     * 商品详细描述，对于使用单品优惠的商户，改字段必须按照规范上传，详见“单品优惠参数说明”(https://pay.weixin.qq.com/wiki/doc/api/danpin.php?chapter=9_102&index=2)
     * String(6000)
     */
    private String detail;

    /**
     * 因为本服务做的是统一处理回调业务，所以推荐使用此字段来做实际业务不同回调处理，这样猜可以保证一个回调链接，可以做多种不同的业务
     * 附加数据，在查询API和支付通知中原样返回，该字段主要用于商户携带订单的自定义数据
     * String(127)
     */
    private String attach;

    /**
     * 商户系统内部订单号，要求32个字符内，只能是数字、大小写字母_-|*且在同一个商户号下唯一。详见商户订单号(https://pay.weixin.qq.com/wiki/doc/api/jsapi_sl.php?chapter=4_2)
     * String(32)
     */
    private String out_trade_no;

    /**
     * 符合ISO 4217标准的三位字母代码，默认人民币：CNY，其他值列表详见货币类型(https://pay.weixin.qq.com/wiki/doc/api/jsapi_sl.php?chapter=4_2)
     * String(32)
     */
    private String fee_type;

    /**
     * 订单总金额，只能为整数，详见支付金额(https://pay.weixin.qq.com/wiki/doc/api/jsapi_sl.php?chapter=4_2)
     */
    private Integer total_fee;

    /**
     * 支持IPV4和IPV6两种格式的IP地址。调用微信支付API的机器IP
     * String(16)
     */
    private String spbill_create_ip;

    /**
     * 订单生成时间，格式为yyyyMMddHHmmss，如2009年12月25日9点10分10秒表示为20091225091010。其他详见时间规则(https://pay.weixin.qq.com/wiki/doc/api/jsapi_sl.php?chapter=4_2)
     * String(14)
     */
    private String time_start;

    /**
     * 订单失效时间，格式为yyyyMMddHHmmss，如2009年12月27日9点10分10秒表示为20091227091010。订单失效时间是针对订单号而言的，由于在请求支付的时候有一个必传参数prepay_id只有两小时的有效期，所以在重入时间超过2小时的时候需要重新请求下单接口获取新的prepay_id。其他详见时间规则
     *
     * 建议：最短失效时间间隔大于1分钟(https://pay.weixin.qq.com/wiki/doc/api/jsapi_sl.php?chapter=4_2)
     * String(14)
     */
    private String time_expire;

    /**
     * 订单优惠标记，代金券或立减优惠功能的参数，说明详见代金券或立减优惠(https://pay.weixin.qq.com/wiki/doc/api/jsapi_sl.php?chapter=12_1)
     * String(32)
     */
    private String goods_tag;

    /**
     * 接收微信支付异步通知回调地址，通知url必须为直接可访问的url，不能携带参数。
     * String(256)
     */
    private String notify_url;

    /**
     * JSAPI -JSAPI支付
     *
     * NATIVE -Native支付
     *
     * APP -APP支付
     *
     * 说明详见参数规定(https://pay.weixin.qq.com/wiki/doc/api/jsapi_sl.php?chapter=4_2)
     * String(16)
     */
    private String trade_type;

    /**
     * trade_type=NATIVE时，此参数必传。此id为二维码中包含的商品ID，商户自行定义。
     * String(32)
     */
    private String product_id;

    /**
     * no_credit--指定不能使用信用卡支付
     * String(32)
     */
    private String limit_pay;

    /**
     * trade_type=JSAPI，此参数必传，用户在主商户appid下的唯一标识。openid和sub_openid可以选传其中之一，如果选择传sub_openid,则必须传sub_appid。下单前需要调用【网页授权获取用户信息】接口获取到用户的Openid。
     * (https://mp.weixin.qq.com/wiki?t=resource/res_main&id=mp1445241432)
     * String(128)
     */
    private String openid;

    /**
     * trade_type=JSAPI，此参数必传，用户在子商户appid下的唯一标识。openid和sub_openid可以选传其中之一，如果选择传sub_openid,则必须传sub_appid。下单前需要调用【网页授权获取用户信息】接口获取到用户的Openid。
     * (https://mp.weixin.qq.com/wiki?t=resource/res_main&id=mp1445241432)
     * String(128)
     */
    private String sub_openid;

    /**
     * 该字段常用于线下活动时的场景信息上报，支持上报实际门店信息，商户也可以按需求自己上报相关信息。该字段为JSON对象数据，对象格式为{"store_info":{"id": "门店ID","name": "名称","area_code": "编码","address": "地址" }} ，字段详细说明请点击行前的+展开
     * String(256)
     */
    private String scene_info;

}
