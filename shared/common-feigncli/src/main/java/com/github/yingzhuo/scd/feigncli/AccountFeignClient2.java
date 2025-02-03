package com.github.yingzhuo.scd.feigncli;

import com.github.yingzhuo.scd.feigncli.configuration.CommonFeignAutoConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

@FeignClient(name = "service-provider-2", contextId = "accountFeignClient2", configuration = CommonFeignAutoConfiguration.class)
public interface AccountFeignClient2 {

    @PostMapping("/account/balance")
    public String addBalance(@RequestParam("accountId") Long accountId, @RequestParam("balance") BigDecimal balance);

}
