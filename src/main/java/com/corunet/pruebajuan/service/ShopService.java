package com.corunet.pruebajuan.service;

import com.corunet.pruebajuan.model.servicemodel.ProductInfoDto;
import java.util.List;

public interface ShopService {
    List<ProductInfoDto> getAllProducts();
    List<ProductInfoDto> getProductsByFilter(String date, int productId, int brandId);
}
