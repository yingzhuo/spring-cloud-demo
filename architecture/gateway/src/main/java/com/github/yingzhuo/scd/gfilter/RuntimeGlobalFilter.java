package com.github.yingzhuo.scd.gfilter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Slf4j
@Component
public class RuntimeGlobalFilter implements GatewayFilter {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {

        final long start = System.currentTimeMillis();

        return chain.filter(exchange)
                .doFinally((result) -> {
                    long end = System.currentTimeMillis();
                    log.info("请求耗时: {} ms", end - start);
                });

    }

}
