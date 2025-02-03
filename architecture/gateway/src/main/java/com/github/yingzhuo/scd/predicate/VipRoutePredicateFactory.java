package com.github.yingzhuo.scd.predicate;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.cloud.gateway.handler.predicate.AbstractRoutePredicateFactory;
import org.springframework.cloud.gateway.handler.predicate.GatewayPredicate;
import org.springframework.cloud.gateway.handler.predicate.RoutePredicateFactory;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.server.ServerWebExchange;

import java.io.Serializable;
import java.util.List;
import java.util.function.Predicate;
import java.util.regex.Pattern;

@Component
public class VipRoutePredicateFactory extends AbstractRoutePredicateFactory<VipRoutePredicateFactory.Config>
        implements RoutePredicateFactory<VipRoutePredicateFactory.Config> {

    /**
     * 默认构造方法
     */
    public VipRoutePredicateFactory() {
        super(Config.class);
    }

    @Override
    public Predicate<ServerWebExchange> apply(final Config config) {
        return new VipPredicate(config);
    }

    @Override
    public List<String> shortcutFieldOrder() {
        return List.of("param", "regex");
    }

    // -----------------------------------------------------------------------------------------------------------------

    private record VipPredicate(Config c) implements GatewayPredicate {

        @Override
        public boolean test(ServerWebExchange serverWebExchange) {
            final var request = serverWebExchange.getRequest();

            var paramValue = request.getQueryParams().getFirst(c.getParam());
            if (paramValue == null) {
                return false;
            }

            return Pattern.compile(c.getRegex()).matcher(paramValue).matches();
        }
    }

    // -----------------------------------------------------------------------------------------------------------------

    @Getter
    @Setter
    @Validated
    public static class Config implements Serializable {

        @NotEmpty
        private String param;

        @NotEmpty
        private String regex;
    }

}
