package org.evanke.springbootmall.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Min;

public class BuyItem {
    @NotNull
    private Integer productId;

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @NotNull
    @Min(1)
    private Integer quantity;
}
