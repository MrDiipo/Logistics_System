package com.logistics.order.service.domain.ports.output.message.publisher.payment;

import com.logistics.domain.events.publisher.DomainEventPublisher;
import com.logistics.order.service.domain.event.OrderCreatedEvent;

public interface OrderCreatedPaymentRequestMessagePublisher extends DomainEventPublisher<OrderCreatedEvent> {

}
