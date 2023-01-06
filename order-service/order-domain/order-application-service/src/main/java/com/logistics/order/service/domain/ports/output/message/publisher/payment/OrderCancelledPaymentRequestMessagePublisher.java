package com.logistics.order.service.domain.ports.output.message.publisher.payment;

import com.logistics.domain.events.publisher.DomainEventPublisher;
import com.logistics.order.service.domain.event.OrderCancelledEvent;

public interface OrderCancelledPaymentRequestMessagePublisher extends DomainEventPublisher<OrderCancelledEvent> {
}
