package com.corunet.pruebajuan.manager;

import com.corunet.pruebajuan.mapper.ShopMapper;
import com.corunet.pruebajuan.model.ProductInfoReq;
import com.corunet.pruebajuan.model.response.ProductInfoRsp;
import com.corunet.pruebajuan.model.servicemodel.ProductInfoDto;
import com.corunet.pruebajuan.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ShopManagerImpl implements ShopManager {

    @Autowired
    private ShopService shopService;

    @Override
    public List<ProductInfoRsp> getAllProducts() {
        List<ProductInfoDto> productInfoList = shopService.getAllProducts();

        return productInfoDtoListToProductInfoRspList(productInfoList);
    }

    @Override
    public List<ProductInfoRsp> getProductsByFilter(String date, int productId, int brandId) {
        List<ProductInfoDto> productInfoList = shopService.getProductsByFilter(date, productId, brandId);
        return productInfoDtoListToProductInfoRspList(productInfoList);
    }

    private List<ProductInfoRsp> productInfoDtoListToProductInfoRspList(List<ProductInfoDto> productInfoList) {
        return productInfoList.stream()
                .map(product -> productInfoDtoToProductInfoRsp(product))
                .collect(Collectors.toList());
    }

    private ProductInfoRsp productInfoDtoToProductInfoRsp(ProductInfoDto productInfo) {
        return ProductInfoRsp.builder()
                .productId(productInfo.getProductId())
                .brandId(productInfo.getBrandId())
                .priority(productInfo.getPriority())
                .start_date(productInfo.getStart_date())
                .end_date(productInfo.getEnd_date())
                .price(productInfo.getPrice())
                .build();
    }
}
