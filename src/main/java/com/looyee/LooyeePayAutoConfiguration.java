package com.looyee;

import com.looyee.alipay.config.AliPayAutoConfiguration;
import com.looyee.wxpay.config.WxPayAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Import({
        WxPayAutoConfiguration.class,
        AliPayAutoConfiguration.class
})
@Configuration
@ComponentScan(basePackages = "com.looyee")
@EnableConfigurationProperties
public class LooyeePayAutoConfiguration {


}
