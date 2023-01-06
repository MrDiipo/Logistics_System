package com.logistics.order.service.domain.event;

import com.logistics.domain.events.DomainEvent;
import com.logistics.order.service.domain.entity.Order;
import lombok.Builder;
import lombok.Getter;

import java.time.ZonedDateTime;

@Builder
@Getter
public abstract class OrderEvent implements DomainEvent<Order> {
    private final Order order;
    private final ZonedDateTime createdAt;
}
