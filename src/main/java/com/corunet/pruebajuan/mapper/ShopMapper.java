package com.corunet.pruebajuan.mapper;

import com.corunet.pruebajuan.model.response.ProductInfoRsp;
import com.corunet.pruebajuan.model.servicemodel.ProductInfoDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ShopMapper {
    ShopMapper INSTANCE = Mappers.getMapper(ShopMapper.class);

    ProductInfoRsp productInfoDtoToProductInfoRsp(ProductInfoDto productInfoDto);
}
