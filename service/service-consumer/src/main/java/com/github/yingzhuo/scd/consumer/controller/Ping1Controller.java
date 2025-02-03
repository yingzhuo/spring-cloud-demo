package com.github.yingzhuo.scd.consumer.controller;

import com.github.yingzhuo.scd.feigncli.PingFeignClient1;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RestController
public class Ping1Controller {

    private final PingFeignClient1 client1;

    @GetMapping("/ping1")
    public String ping() {
        return client1.ping();
    }

    @GetMapping("/bad-ping-1")
    public String badPing() {
        return client1.badPing();
    }

}
