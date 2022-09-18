package dev.caio.study.retryable.feign;

import dev.caio.study.retryable.feign.client.DummyJsonClient;
import dev.caio.study.retryable.feign.dto.DummyJsonProductsDTO;
import feign.FeignException;
import feign.RetryableException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

@SpringBootTest
class DummyJsonApiTests {

	@Autowired
	private DummyJsonClient client;

	@Test
	void shouldReturnResponseDto() {
		assertThat(client.getProducts()).isNotNull();
	}

	@Test
	void shouldReturnProductOfId1AsFirstInList() {
		DummyJsonProductsDTO pageableProductsResponse = client.getProducts();
		assertThat(pageableProductsResponse.getProducts().get(0).getId())
				.isEqualTo(1);
	}

	@Test
	void shouldProduceNotFoundExceptionFromFeignClientOnNonExistantEndpointCall() {
		assertThatThrownBy(() -> client.forceError())
				.isExactlyInstanceOf(RetryableException.class);
	}

}
