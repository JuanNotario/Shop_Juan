package com.corunet.pruebajuan.manager;

import com.corunet.pruebajuan.factory.ModelFactory;
import com.corunet.pruebajuan.model.response.ProductInfoRsp;
import com.corunet.pruebajuan.service.ShopService;
import org.junit.jupiter.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class ShopManagerImplTest {

    public static final String DATE = "date";

    @Mock
    private ShopService shopService;

    @InjectMocks
    private ShopManager shopManager = new ShopManagerImpl();

    @Test
    public void getAllProducts_notEmptyRsp() {
        Mockito.when(shopService.getAllProducts())
                .thenReturn(Arrays.asList(ModelFactory.getProductInfoDto()));

        List<ProductInfoRsp> allProducts = shopManager.getAllProducts();

        Assertions.assertNotNull(allProducts);
        Assertions.assertEquals(35.50, allProducts.get(0).getPrice());
    }

    @Test
    public void getAllProducts_emptyRsp() {
        Mockito.when(shopService.getAllProducts())
                .thenReturn(Arrays.asList());

        List<ProductInfoRsp> allProducts = shopManager.getAllProducts();

        Assertions.assertNotNull(allProducts);
        Assertions.assertTrue(allProducts.isEmpty());
    }

    @Test
    public void getProductsByFilter_notEmptyRsp() {
        Mockito.when(shopService.getProductsByFilter(Mockito.anyString(), Mockito.anyInt(), Mockito.anyInt()))
                .thenReturn(Arrays.asList(ModelFactory.getProductInfoDto()));

        List<ProductInfoRsp> allProducts = shopManager.getProductsByFilter(DATE, 1, 1);

        Assertions.assertNotNull(allProducts);
        Assertions.assertEquals(35.50, allProducts.get(0).getPrice());
    }

    @Test
    public void getProductsByFilter_emptyRsp() {
        Mockito.when(shopService.getProductsByFilter(Mockito.anyString(), Mockito.anyInt(), Mockito.anyInt()))
                .thenReturn(Arrays.asList());

        List<ProductInfoRsp> allProducts = shopManager.getProductsByFilter(DATE, 1, 1);

        Assertions.assertNotNull(allProducts);
        Assertions.assertTrue(allProducts.isEmpty());
    }

}