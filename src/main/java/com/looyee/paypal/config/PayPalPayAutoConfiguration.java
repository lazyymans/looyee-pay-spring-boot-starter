package com.looyee.paypal.config;

import com.paypal.base.rest.APIContext;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnProperty(
        name = {"looyee.pay.paypal.enabled"},
        matchIfMissing = true
)
@EnableConfigurationProperties(PayPalPayProperties.class)
public class PayPalPayAutoConfiguration {

    @Bean
    public APIContext paypalContext(PayPalPayProperties payProperties) {
        return new APIContext(payProperties.getClientId(), payProperties.getClientId(), payProperties.getMode());
    }

}
