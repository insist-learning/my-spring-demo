package com.example.testdemo.config;

import com.xxl.job.core.executor.impl.XxlJobSpringExecutor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class XXLConfig {
    @Bean
    public XxlJobSpringExecutor xxlJobExecutor() {
        XxlJobSpringExecutor xxlJobSpringExecutor = new XxlJobSpringExecutor();
        xxlJobSpringExecutor.setAdminAddresses("http://192.168.1.4:9998/xxl-job-admin");
        xxlJobSpringExecutor.setAppname("xxl-job-executor-sample");
        xxlJobSpringExecutor.setAccessToken("default_token");
        return xxlJobSpringExecutor;
    }
}
