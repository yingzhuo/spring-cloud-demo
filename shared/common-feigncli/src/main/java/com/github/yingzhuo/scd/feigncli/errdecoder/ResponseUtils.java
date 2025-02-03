package com.github.yingzhuo.scd.feigncli.errdecoder;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.yingzhuo.scd.exception.BizException;
import com.github.yingzhuo.scd.exception.BizExceptionData;
import feign.Response;
import org.springframework.util.Assert;
import org.springframework.util.StreamUtils;

import java.io.IOException;
import java.io.UncheckedIOException;

import static java.nio.charset.StandardCharsets.UTF_8;

/**
 * 工具{@link Response}
 */
public final class ResponseUtils {

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    private ResponseUtils() {
    }

    public static String getBodyAsString(Response response) {
        Assert.notNull(response, "response is required");
        try {
            var in = response.body().asInputStream();
            return StreamUtils.copyToString(in, UTF_8);
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

    public static BizException toBizException(String bodyString) {
        Assert.hasText(bodyString, "bodyString is required");

        try {
            var data = OBJECT_MAPPER.reader().readValue(bodyString, BizExceptionData.class);
            return new BizException((data.getErrorMessage()));
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

}
