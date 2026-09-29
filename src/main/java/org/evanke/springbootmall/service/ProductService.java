package org.evanke.springbootmall.service;

import org.evanke.springbootmall.dto.ProductRequest;
import org.evanke.springbootmall.model.Product;

public interface ProductService {
    Product getProductById(Integer id);

    Integer createProduct(ProductRequest productRequest);

    void updateProduct(Integer productId, ProductRequest productRequest);
}
