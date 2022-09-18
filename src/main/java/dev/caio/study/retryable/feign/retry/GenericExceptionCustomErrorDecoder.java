package dev.caio.study.retryable.feign.retry;

import feign.Response;
import feign.RetryableException;
import feign.codec.ErrorDecoder;

public class GenericExceptionCustomErrorDecoder implements ErrorDecoder {
    @Override
    public Exception decode(String s, Response response) {
        throw new RetryableException(response.status(), response.reason(), response.request().httpMethod(), null, response.request());
    }
}
