package com.looyee.wxpay.config;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

@Configuration
@ConditionalOnProperty(
        name = {"looyee.pay.wx.enabled"},
        matchIfMissing = true
)
@EnableConfigurationProperties(WxPayProperties.class)
public class WxPayAutoConfiguration {

    @Autowired
    WxPayProperties wxPayProperties;

    private File cert;

    @PostConstruct
    private void configurationCerts() throws IOException {
        String certFilePath = wxPayProperties.getCertFilePath();
        boolean startFlag = StringUtils.startsWith(certFilePath, "classpath:");
        File cert = null;
        if (startFlag) {
            InputStream stream = getClass().getClassLoader().getResourceAsStream(certFilePath.replace("classpath:", ""));
            File targetFile = new File(certFilePath.replace("classpath:", ""));
            FileUtils.copyInputStreamToFile(stream, targetFile);
            cert = targetFile;
        } else {
            cert = new File(certFilePath);
        }
        this.cert = cert;
    }

    public File getCert() {
        return cert;
    }
}
