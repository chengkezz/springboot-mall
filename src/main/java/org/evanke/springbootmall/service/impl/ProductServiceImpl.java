package org.evanke.springbootmall.service.impl;

import org.evanke.springbootmall.constants.ProductCategory;
import org.evanke.springbootmall.dao.ProductDao;
import org.evanke.springbootmall.dto.ProductRequest;
import org.evanke.springbootmall.model.Product;
import org.evanke.springbootmall.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;

    @Override
    public List<Product> getProducts(ProductCategory productCategory,  String search) {
        return productDao.getProducts(productCategory, search);
    }

    @Override
    public Product getProductById(Integer id) {
        return productDao.getProductById(id);
    }

    @Override
    public Integer createProduct(ProductRequest productRequest) {
        return productDao.createProduct(productRequest);
    }

    @Override
    public void updateProduct(Integer productId, ProductRequest productRequest) {
        productDao.updateProduct(productId, productRequest);
    }

    @Override
    public void deleteProduct(Integer productId) {
        productDao.deleteProductById(productId);
    }
}
