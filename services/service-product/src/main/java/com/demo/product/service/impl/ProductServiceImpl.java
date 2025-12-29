package com.demo.product.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.demo.model.bean.Product;
import com.demo.model.bean.dataobject.ProductDO;
import com.demo.model.bean.product.dto.CreateProductDTO;
import com.demo.model.bean.product.vo.ProductVO;
import com.demo.product.mapper.ProductMapper;
import com.demo.product.service.ProductService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Objects;

@Service
public class ProductServiceImpl extends ServiceImpl<ProductMapper, ProductDO> implements ProductService {
    /**
     * 根据id查询商品
     *
     * @param id 商品id
     */
    @Override
    public ProductVO getProductById(String id) {
        ProductDO productDO = getById(id);
        if (Objects.isNull(productDO)){
            return null;
        }
        return ProductVO.builder()
                .id(productDO.getId())
                .projectName(productDO.getProjectName())
                .price(productDO.getPrice())
                .description(productDO.getDescription())
                .num(productDO.getNum())
                .build();
    }

    /**
     * 创建商品
     *
     * @param dto 创建商品DTO
     */
    @Override
    public ProductDO createProduct(CreateProductDTO dto) {
        ProductDO productDO = new ProductDO();
        productDO.setProjectName(dto.getProjectName());
        productDO.setPrice(BigDecimal.valueOf(dto.getPrice()));
        productDO.setNum(dto.getNum());
        productDO.setDescription(dto.getDescription());

        save(productDO);
        return productDO;
    }
}
