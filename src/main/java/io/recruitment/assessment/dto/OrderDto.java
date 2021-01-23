package io.recruitment.assessment.dto;

import java.util.List;

public class OrderDto extends BaseDto {
    private List<ProductOrderDto> products;

    public List<ProductOrderDto> getProducts() {
        return this.products;
    }

    public OrderDto(String name, Integer id, List<ProductOrderDto> orders) {
        this.name = name;
        this.id = id;
        this.products = orders;
    }    
}
