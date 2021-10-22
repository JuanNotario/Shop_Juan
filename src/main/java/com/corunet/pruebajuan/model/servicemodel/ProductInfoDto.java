package com.corunet.pruebajuan.model.servicemodel;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductInfoDto {
    private int productId;
    private int brandId;
    private int priority;
    private String start_date;
    private String end_date;
    private double price;
}
