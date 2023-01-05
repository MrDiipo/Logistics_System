package com.logistics.order.service.domain.valueobject;

import com.logistics.domain.entity.BaseEntity;
import com.logistics.domain.valueobject.BaseId;

public class OrderItemId extends BaseId<Long> {
    public OrderItemId(Long value) {
        super(value);
    }
}
