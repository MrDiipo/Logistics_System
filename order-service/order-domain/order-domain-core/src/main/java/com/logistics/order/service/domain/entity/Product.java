package com.logistics.order.service.domain.entity;

import com.logistics.domain.entity.BaseEntity;
import com.logistics.domain.valueobject.Money;
import com.logistics.domain.valueobject.ProductId;
import lombok.Getter;

@Getter
public class Product extends BaseEntity<ProductId> {
    private String name;
    private Money price;

    public Product(ProductId productId, String name, Money price) {
        super(productId);
        super.setId(productId);
        this.name = name;
        this.price = price;
    }
}
