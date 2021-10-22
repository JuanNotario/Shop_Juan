package com.corunet.pruebajuan.controller;

import com.corunet.pruebajuan.manager.ShopManager;
import com.corunet.pruebajuan.model.response.HeaderRsp;
import com.corunet.pruebajuan.model.response.ProductInfoRsp;
import com.corunet.pruebajuan.model.response.Response;
import com.corunet.pruebajuan.model.response.ShopRsp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class ShopController {
    public static final String DESCRIPTION = "Success";
    public static final String CODE = "100";

    @Autowired
    private ShopManager shopManager;

    @RequestMapping(value = "/shop/products", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public Response getProducts() {
        List<ProductInfoRsp> productInfo = shopManager.getAllProducts();

        return new Response(new HeaderRsp(CODE, DESCRIPTION), new ShopRsp(productInfo));
    }

    @RequestMapping(value = "/shop/products/filter", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public Response getProductsByDate(@RequestParam String date, @RequestParam int productId, @RequestParam int brandId) {
        List<ProductInfoRsp> productInfo = shopManager.getProductsByFilter(date, productId, brandId);

        return new Response(new HeaderRsp(CODE, DESCRIPTION), new ShopRsp(productInfo));
    }
}
