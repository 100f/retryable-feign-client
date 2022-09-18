package dev.caio.study.retryable.feign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class RetryFeignApplication {
	public static void main(String[] args) {
		SpringApplication.run(RetryFeignApplication.class, args);
	}
}
