package org.evanke.springbootmall.dao;

import org.evanke.springbootmall.constants.ProductCategory;
import org.evanke.springbootmall.dto.ProductRequest;
import org.evanke.springbootmall.model.Product;

import java.util.List;

public interface ProductDao {

    List<Product> getProducts(ProductCategory productCategory,  String search);

    Product getProductById(Integer productId);

    Integer createProduct(ProductRequest productRequest);

    void updateProduct(Integer productId, ProductRequest productRequest);

    void deleteProductById(Integer productId);


}
