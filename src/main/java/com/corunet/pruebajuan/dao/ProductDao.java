package com.corunet.pruebajuan.dao;

import com.corunet.pruebajuan.entity.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductDao extends CrudRepository<Product, Integer> {
    @Query(value = "select * from prices", nativeQuery = true)
    List<Product> getAllProducts();

    @Query(value = "select * from prices where start_date = ?1 and product_id = ?2 and brand_id = ?3", nativeQuery = true)
    List<Product> getProductsByFilter(String date, int productId, int brandId);


}
