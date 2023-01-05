package com.logistics.order.service.domain.entity;

import com.logistics.domain.entity.BaseEntity;
import com.logistics.domain.valueobject.Money;
import com.logistics.domain.valueobject.OrderId;
import com.logistics.order.service.domain.valueobject.OrderItemId;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class OrderItem extends BaseEntity<OrderItemId> {
    private OrderId orderId;
    private final Product product;
    private final int quantity;
    private final Money price;
    private final Money subTotal;

    boolean isPriceValid() {
        return price.isGreaterThanZero() && price.equals(product.getPrice())
                && price.multiply(quantity).equals(subTotal);
    }

    void initializeOrderItem(OrderId orderId, OrderItemId orderItemId) {
        this.orderId = orderId;
        super.setId(orderItemId);
    }
}
