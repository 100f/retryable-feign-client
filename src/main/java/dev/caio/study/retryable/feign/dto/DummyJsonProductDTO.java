package dev.caio.study.retryable.feign.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@NoArgsConstructor
public class DummyJsonProductDTO {
    private Long id;
    private String title;
    private String description;
    private BigDecimal price;
    private BigDecimal discountPercentage;
    private BigDecimal rating;
    private Integer stock;
    private String brand;
    private String category;
    private String thumbnail;
    private List<String> images;
}
