package com.logistics.domain.events.publisher;

import com.logistics.domain.events.DomainEvent;

public interface DomainEventPublisher <T> extends DomainEvent<T> {
    void publish(T domainEvent);
}
