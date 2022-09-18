package dev.caio.study.retryable.feign.config;

import dev.caio.study.retryable.feign.retry.AttemptsRetryer;
import dev.caio.study.retryable.feign.retry.GenericExceptionCustomErrorDecoder;
import feign.Retryer;
import feign.codec.ErrorDecoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignClientConfig {
    @Bean
    public Retryer getRetryer() {
        return new AttemptsRetryer();
    }

    @Bean
    public ErrorDecoder getErrorDecoder() { return new GenericExceptionCustomErrorDecoder(); }
}
