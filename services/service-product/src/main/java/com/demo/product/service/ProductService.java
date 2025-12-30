package com.demo.product.service;


import com.demo.model.bean.dataobject.ProductDO;
import com.demo.model.bean.product.dto.CreateProductDTO;
import com.demo.model.bean.product.dto.ProductDeductDTO;
import com.demo.model.bean.product.vo.ProductVO;

public interface ProductService {
    /**
     * 根据id查询商品
     * @param id 商品id
     */
    ProductVO getProductById(String id);

    /**
     * 创建商品
     * @param dto 创建商品DTO
     */
    ProductDO createProduct(CreateProductDTO dto);

    /**
     * 扣减商品库存
     * @param id 商品id
     * @param dto 扣减商品DTO
     */
    ProductDO deduct(String id, ProductDeductDTO dto);
}
