package com.github.yingzhuo.scd.feigncli;

import com.github.yingzhuo.scd.feigncli.configuration.CommonFeignAutoConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "service-provider-1", contextId = "pingFeignClient1", configuration = CommonFeignAutoConfiguration.class)
public interface PingFeignClient1 {

    @GetMapping("/ping")
    public String ping();

    @GetMapping("/bad-ping")
    public String badPing();

}
