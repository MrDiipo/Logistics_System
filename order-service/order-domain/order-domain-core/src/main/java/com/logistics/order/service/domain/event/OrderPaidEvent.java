package com.logistics.order.service.domain.event;

import com.logistics.domain.events.DomainEvent;
import com.logistics.order.service.domain.entity.Order;
import lombok.Builder;
import lombok.Getter;

import java.time.ZonedDateTime;

@Builder
@Getter
public class OrderPaidEvent extends OrderEvent{
    public OrderPaidEvent(Order order, ZonedDateTime createdAt) {
        super(order, createdAt);
    }
}
