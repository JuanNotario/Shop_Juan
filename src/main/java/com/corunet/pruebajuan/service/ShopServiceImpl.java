package com.corunet.pruebajuan.service;

import com.corunet.pruebajuan.dao.ProductDao;
import com.corunet.pruebajuan.entity.Product;
import com.corunet.pruebajuan.model.ProductInfoReq;
import com.corunet.pruebajuan.model.servicemodel.ProductInfoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class ShopServiceImpl implements ShopService {

    @Autowired
    private ProductDao productDao;

    @Override
    public List<ProductInfoDto> getAllProducts() {
        List<Product> allProducts = productDao.getAllProducts();

        return productListToProductInfoDtoList(allProducts);
    }

    @Override
    public List<ProductInfoDto> getProductsByFilter(String date, int productId, int brandId) {
        List<Product> allProducts = productDao.getProductsByFilter(date, productId, brandId);
        return productListToProductInfoDtoList(allProducts);
    }

    private List<ProductInfoDto> productListToProductInfoDtoList(List<Product> allProducts) {
        return allProducts.stream()
                .map(product -> productToProductInfoDto(product))
                .collect(Collectors.toList());
    }

    private ProductInfoDto productToProductInfoDto(Product product) {
        return ProductInfoDto.builder()
                .brandId(product.getBrandId())
                .end_date(product.getEnd_date())
                .price(product.getPrice())
                .productId(product.getProductId())
                .priority(product.getPriority())
                .start_date(product.getStart_date())
                .build();
    }
}
