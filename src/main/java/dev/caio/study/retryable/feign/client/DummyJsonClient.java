package dev.caio.study.retryable.feign.client;

import dev.caio.study.retryable.feign.config.FeignClientConfig;
import dev.caio.study.retryable.feign.dto.DummyJsonProductsDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "dummy", url = "${feign.client.dummy-json.base-url}", configuration = FeignClientConfig.class)
public interface DummyJsonClient {
    @GetMapping("/products")
    DummyJsonProductsDTO getProducts();

    /**
     * Chamada fake para endpoint que não existe nessa API (para forçar erros)
     */
    @GetMapping("/productz")
    Object forceError();
}
