package com.github.yingzhuo.scd.provider2.controller;

import com.github.yingzhuo.scd.exception.BizException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PingController {

    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST}, path = "/ping")
    public String ping() {
        return "pong";
    }

    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST}, path = "/bad-ping")
    public String badPing() {
        throw new BizException("bad-ping");
    }

}
