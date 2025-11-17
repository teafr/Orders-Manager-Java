package org.example.order.processing;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
public class Clothing extends Product {
    private final String size;
}