package com.corunet.pruebajuan.service;

import com.corunet.pruebajuan.dao.ProductDao;
import com.corunet.pruebajuan.entity.Product;
import com.corunet.pruebajuan.factory.ModelFactory;
import com.corunet.pruebajuan.model.servicemodel.ProductInfoDto;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class ShopServiceImplTest {
    public static final String DATE = "date";
    public static final double PRICE = 25.45;

    @Mock
    private ProductDao productDao;

    @InjectMocks
    private ShopService shopService = new ShopServiceImpl();

    @Test
    public void getAllProducts_notEmptyRsp() {
        Mockito.when(productDao.getAllProducts())
                .thenReturn(Arrays.asList(ModelFactory.getProduct()));

        List<ProductInfoDto> allProducts = shopService.getAllProducts();

        Assertions.assertNotNull(allProducts);
        Assertions.assertEquals(PRICE, allProducts.get(0).getPrice());
    }

    @Test
    public void getAllProducts_emptyRsp() {
        Mockito.when(productDao.getAllProducts())
                .thenReturn(Arrays.asList());

        List<ProductInfoDto> allProducts = shopService.getAllProducts();

        Assertions.assertNotNull(allProducts);
        Assertions.assertTrue(allProducts.isEmpty());
    }

    @Test
    public void getProductsByFilter_notEmptyRsp() {
        Mockito.when(productDao.getProductsByFilter(Mockito.anyString(), Mockito.anyInt(), Mockito.anyInt()))
                .thenReturn(Arrays.asList(ModelFactory.getProduct()));

        List<Product> allProducts = productDao.getProductsByFilter(DATE, 1, 1);

        Assertions.assertNotNull(allProducts);
        Assertions.assertEquals(PRICE, allProducts.get(0).getPrice());
    }

    @Test
    public void getProductsByFilter_emptyRsp() {
        Mockito.when(productDao.getProductsByFilter(Mockito.anyString(), Mockito.anyInt(), Mockito.anyInt()))
                .thenReturn(Arrays.asList());

        List<Product> allProducts = productDao.getProductsByFilter(DATE, 1, 1);

        Assertions.assertNotNull(allProducts);
        Assertions.assertTrue(allProducts.isEmpty());
    }
}