package com.logistics.domain.entity;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Setter
@Getter
@EqualsAndHashCode
@SuperBuilder
@AllArgsConstructor
public abstract class BaseEntity<ID> {
    protected ID id;

}
