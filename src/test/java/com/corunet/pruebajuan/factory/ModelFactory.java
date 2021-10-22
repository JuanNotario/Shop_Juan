package com.corunet.pruebajuan.factory;

import com.corunet.pruebajuan.entity.Product;
import com.corunet.pruebajuan.model.servicemodel.ProductInfoDto;

public class ModelFactory {
    public static ProductInfoDto getProductInfoDto() {
        return ProductInfoDto.builder()
                .productId(35455)
                .brandId(1)
                .priority(0)
                .start_date("2020-06-14-00.00.00")
                .end_date("2020-12-31-23.59.59")
                .price(35.50)
                .build();
    }

    public static Product getProduct() {
        return Product.builder()
                .brandId(1)
                .curr("CURR")
                .end_date("2020-06-14-18.30.00")
                .price(25.45)
                .priceList(2)
                .priority(1)
                .productId(35455)
                .start_date("2020-0-15-00.00.00")
                .build();
    }
}
