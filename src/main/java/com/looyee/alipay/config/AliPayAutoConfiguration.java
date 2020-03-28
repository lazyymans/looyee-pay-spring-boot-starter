package com.looyee.alipay.config;

import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.looyee.alipay.constant.AliPayCommonConstant;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnProperty(
        name = {"looyee.pay.ali.enabled"},
        matchIfMissing = true
)
@EnableConfigurationProperties(AliPayProperties.class)
public class AliPayAutoConfiguration {

    @Bean
    public AlipayClient alipayClient(AliPayProperties payProperties) {
        return new DefaultAlipayClient(AliPayCommonConstant.SERVER_URL,
                payProperties.getAppId(),
                payProperties.getPrivateKey(),
                AliPayCommonConstant.FORMAT,
                AliPayCommonConstant.CHARSET,
                payProperties.getAlipayPublicKey(),
                AliPayCommonConstant.SIGN_TYPE);
    }

}
