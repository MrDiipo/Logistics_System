package com.logistics.order.service.domain.entity;

import com.logistics.domain.entity.AggregateRoot;
import com.logistics.domain.valueobject.RestaurantId;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Getter
@SuperBuilder
public class Restaurant extends AggregateRoot<RestaurantId> {

    private final List<Product> products;
    private boolean active;

}
