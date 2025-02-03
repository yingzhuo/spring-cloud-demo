package com.github.yingzhuo.scd.consumer.controller;

import com.github.yingzhuo.scd.feigncli.AccountFeignClient1;
import com.github.yingzhuo.scd.feigncli.AccountFeignClient2;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/account")
public class AccountController {

    private final AccountFeignClient1 client1;
    private final AccountFeignClient2 client2;

    @PostMapping("/balance")
    public String addBalance() {
        client1.addBalance(1L, BigDecimal.valueOf(5L));
        client2.addBalance(1L, BigDecimal.valueOf(-5L));
        return "success";
    }

}
