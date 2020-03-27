package com.looyee.alipay.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnProperty(
        name = {"looyee.pay.ali.enabled"},
        matchIfMissing = true
)
@EnableConfigurationProperties(AliPayProperties.class)
public class AliPayAutoConfiguration {

}
