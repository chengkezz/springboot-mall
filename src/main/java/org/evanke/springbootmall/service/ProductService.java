package org.evanke.springbootmall.service;

import org.evanke.springbootmall.dto.ProductQueryParams;
import org.evanke.springbootmall.dto.ProductRequest;
import org.evanke.springbootmall.model.Product;

import java.util.List;

public interface ProductService {

    Integer countProduct(ProductQueryParams productQueryParams);

    List<Product> getProducts(ProductQueryParams productQueryParams);

    Product getProductById(Integer id);

    Integer createProduct(ProductRequest productRequest);

    void updateProduct(Integer productId, ProductRequest productRequest);

    void deleteProduct(Integer productId);
}
