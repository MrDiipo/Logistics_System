package com.logistics.order.service.domain.ports.output.message.publisher.restaurantapproval;

import com.logistics.domain.events.publisher.DomainEventPublisher;
import com.logistics.order.service.domain.event.OrderPaidEvent;

public interface OrderPaidRestaurantRequestPaymentPublisher extends DomainEventPublisher<OrderPaidEvent> {
}
