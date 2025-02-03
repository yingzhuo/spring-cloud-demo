package com.github.yingzhuo.scd.provider2.controller;

import com.github.yingzhuo.scd.provider2.service.AccountService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/account")
public class AccountController {

    private final AccountService accountService;

    @PostMapping("/balance")
    public String addBalance(@RequestParam("accountId") Long accountId, @RequestParam("balance") BigDecimal balance) {
        accountService.addBalance(accountId, balance);
        return "success";
    }

}
