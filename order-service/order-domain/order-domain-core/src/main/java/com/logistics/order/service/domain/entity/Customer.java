package com.logistics.order.service.domain.entity;

import com.logistics.domain.entity.AggregateRoot;
import com.logistics.domain.valueobject.CustomerId;

public class Customer extends AggregateRoot<CustomerId> {

    protected Customer(AggregateRootBuilder<CustomerId, ?, ?> b) {
        super(b);
    }
}
