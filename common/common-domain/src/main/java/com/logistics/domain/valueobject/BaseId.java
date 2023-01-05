package com.logistics.domain.valueobject;

import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode
public abstract class BaseId<T> {

    private final T value;

    protected BaseId(T value) {
        this.value = value;
    }
}
