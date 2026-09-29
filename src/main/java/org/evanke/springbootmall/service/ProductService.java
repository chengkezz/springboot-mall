package org.evanke.springbootmall.service;

import org.evanke.springbootmall.constants.ProductCategory;
import org.evanke.springbootmall.dto.ProductRequest;
import org.evanke.springbootmall.model.Product;

import java.util.List;

public interface ProductService {

    List<Product> getProducts(ProductCategory productCategory, String search);

    Product getProductById(Integer id);

    Integer createProduct(ProductRequest productRequest);

    void updateProduct(Integer productId, ProductRequest productRequest);

    void deleteProduct(Integer productId);
}
