package com.corunet.pruebajuan.entity;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "prices")
@Data
@Builder
public class Product implements Serializable {
    @Column(name = "brand_id")
    private int brandId;
    private String start_date;
    private String end_date;
    @Id
    @Column(name = "price_list")
    private int priceList;
    @Column(name = "product_id")
    private int productId;
    private int priority;
    private double price;
    private String curr;
}
