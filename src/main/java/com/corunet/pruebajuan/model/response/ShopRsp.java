package com.corunet.pruebajuan.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShopRsp implements BodyRsp {
    private List<ProductInfoRsp> productListRsp;
}
