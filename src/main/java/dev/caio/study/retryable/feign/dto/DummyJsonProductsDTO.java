package dev.caio.study.retryable.feign.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class DummyJsonProductsDTO extends DummyJsonPageableResponseDTO {
    private List<DummyJsonProductDTO> products;
}
