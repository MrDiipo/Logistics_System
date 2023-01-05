package com.logistics.order.service.domain.entity;

import com.logistics.domain.entity.AggregateRoot;
import com.logistics.domain.valueobject.*;
import com.logistics.order.service.domain.exception.OrderDomainException;
import com.logistics.order.service.domain.valueobject.OrderItemId;
import com.logistics.order.service.domain.valueobject.StreetAddress;
import com.logistics.order.service.domain.valueobject.TrackingId;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

import java.util.List;
import java.util.UUID;

@Getter
@SuperBuilder
public class Order extends AggregateRoot<OrderId> {


    private final CustomerId customerId;
    private final RestaurantId restaurantId;
    private final StreetAddress deliveryAddress;
    private final Money price;
    private final List<OrderItem> items;

    private TrackingId trackingId;
    private OrderStatus orderStatus;
    private List<String> failureMessages;

    public void initializeOrder(){
        setId(new OrderId(UUID.randomUUID()));
        trackingId = new TrackingId(UUID.randomUUID());
        orderStatus = OrderStatus.PENDING;
        initializeOrderItems();
    }

    private void initializeOrderItems() {
        long itemId = 1;
        for (OrderItem orderItem : items) {
            orderItem.initializeOrderItem(super.getId(), new OrderItemId(itemId++));
        }
    }

    public void validateOrder() {
        validateInitialOrder();
        validateTotalPrice();
        validateItemsPrice();
    }

    public void pay() {
        if (orderStatus != OrderStatus.PENDING) {
            throw new OrderDomainException("Order not in correct state for pay operation");
        }
        orderStatus = OrderStatus.PAID;
    }

    public void approved() {
        if (orderStatus != OrderStatus.PAID) {
            throw new OrderDomainException("Order is not in correct state for initialization");
        }
        orderStatus = OrderStatus.APPROVED;
    }

    public void initCancel(List<String> failureMessages) {
        if (orderStatus !=  OrderStatus.PAID) {
            throw new OrderDomainException("Order not in correct state for initCancel operation!");
        }
        orderStatus = OrderStatus.CANCELLING;
        updateFailureMessage(failureMessages);
    }

    public void cancel(List<String> failureMessages) {
        if (!(orderStatus == OrderStatus.CANCELLING || orderStatus == OrderStatus.PENDING)) {
            throw new OrderDomainException("Order not in correct state for cancel operation!");
        }
        orderStatus = OrderStatus.CANCELLED;
        updateFailureMessage(failureMessages);
    }


    private void updateFailureMessage(List<String> failureMessages) {
        if (this.failureMessages != null && failureMessages != null) {
            this.failureMessages.addAll(failureMessages.stream().filter(
                    message -> !message.isEmpty()).toList()
            );
        }
        if (this.failureMessages == null) {
            this.failureMessages = failureMessages;
        }
    }

    private void validateItemsPrice() {
       Money orderItemsTotal = items.stream().map(
                orderItem -> {
                    validateItemPrice(orderItem);
                    return orderItem.getSubTotal();
                }
        ).reduce(Money.ZERO, Money::add);

       if (!price.equals(orderItemsTotal)) {
           throw new OrderDomainException("Total price: " + price.getAmount() + " is not equal to Order items total" +
                   orderItemsTotal.getAmount() + "!");
       }
    }

    private void validateItemPrice(OrderItem orderItem) {
        if (!orderItem.isPriceValid()) {
            throw new OrderDomainException("Order item price: " + orderItem.getPrice().getAmount() +
                    " is not valid for product " + orderItem.getProduct().getId().getValue());
        }
    }

    private void validateTotalPrice() {
        if (price == null || !price.isGreaterThanZero()) {
            throw new OrderDomainException("Total price must be greater than zero");
        }
    }

    private void validateInitialOrder() {
        if (orderStatus != null || getId() != null) {
            throw new OrderDomainException("Order is not in correct state for initialization");
        }
    }

}
