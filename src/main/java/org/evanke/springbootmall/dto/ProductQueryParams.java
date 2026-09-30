package org.evanke.springbootmall.dto;

import org.evanke.springbootmall.constants.ProductCategory;

public class ProductQueryParams {
    private ProductCategory productCategory;

    public ProductCategory getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(ProductCategory productCategory) {
        this.productCategory = productCategory;
    }

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }

    private String search;


}
