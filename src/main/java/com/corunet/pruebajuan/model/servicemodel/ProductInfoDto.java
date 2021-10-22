package com.corunet.pruebajuan.model.servicemodel;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductInfoDto {
    private int productId;
    private int brandId;
    private int priority;
    private String start_date;
    private String end_date;
    private double price;
}
