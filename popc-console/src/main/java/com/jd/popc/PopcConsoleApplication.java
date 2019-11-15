package com.jd.popc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author yangsong on 2018/11/29.
 */
@SpringBootApplication
@EnableAutoConfiguration
@EnableAsync
@EnableScheduling
@EnableSwagger2
@EnableTransactionManagement(proxyTargetClass = true)
public class PopcConsoleApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(PopcConsoleApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(PopcConsoleApplication.class, args);
    }

}