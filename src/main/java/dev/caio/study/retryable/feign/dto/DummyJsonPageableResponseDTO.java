package dev.caio.study.retryable.feign.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DummyJsonPageableResponseDTO {
    private Integer total;
    private Integer skip;
    private Integer limit;
}
