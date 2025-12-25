package com.demo.product.service;


import com.demo.model.bean.Product;

public interface ProductService {
    /**
     * 根据id查询商品
     * @param id 商品id
     */
    Product getProductById(String id);
}
