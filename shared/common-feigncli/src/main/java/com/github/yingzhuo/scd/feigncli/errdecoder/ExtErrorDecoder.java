package com.github.yingzhuo.scd.feigncli.errdecoder;

import feign.Response;
import feign.codec.ErrorDecoder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;

import static com.github.yingzhuo.scd.feigncli.errdecoder.ResponseUtils.getBodyAsString;
import static com.github.yingzhuo.scd.feigncli.errdecoder.ResponseUtils.toBizException;

@Slf4j
public class ExtErrorDecoder implements ErrorDecoder {

    private static final ErrorDecoder DEFAULT = new ErrorDecoder.Default(Integer.MAX_VALUE, Integer.MAX_VALUE);

    @Override
    public Exception decode(String methodKey, Response response) {
        var status = HttpStatus.resolve(response.status());

        if (status.equals(HttpStatus.CONFLICT)) {
            var body = getBodyAsString(response);
            log.debug("业务异常");
            log.debug("下游节点body: {}", body);
            return toBizException(body);
        }

        return DEFAULT.decode(methodKey, response);
    }

}
