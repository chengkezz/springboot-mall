package org.evanke.springbootmall.dao;

import org.evanke.springbootmall.dto.ProductRequest;
import org.evanke.springbootmall.model.Product;

public interface ProductDao {

    Product getProductById(Integer productId);

    Integer createProduct(ProductRequest productRequest);
}
