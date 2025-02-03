package com.github.yingzhuo.scd.feigncli.configuration;

import com.github.yingzhuo.scd.feigncli.errdecoder.ExtErrorDecoder;
import org.springframework.context.annotation.Bean;

public class CommonFeignAutoConfiguration {

    @Bean
    public ExtErrorDecoder errorDecoder() {
        return new ExtErrorDecoder();
    }

}
