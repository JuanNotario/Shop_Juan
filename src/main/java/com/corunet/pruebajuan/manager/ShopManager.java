package com.corunet.pruebajuan.manager;

import com.corunet.pruebajuan.model.response.ProductInfoRsp;
import java.util.List;

public interface ShopManager {
    List<ProductInfoRsp> getAllProducts();
    List<ProductInfoRsp> getProductsByFilter(String date, int productId, int brandId);
}
