package org.example.order.processing;

import lombok.AllArgsConstructor;

import java.util.function.Consumer;

@AllArgsConstructor
public class OrderProcessor<T extends Product> {
    private final T product;

    public void process() {
        System.out.println("Processing order for: " + product.getName());
        if (product instanceof Electronics electronics) {
            System.out.println("Electronics brand: " + electronics.getBrand());
        } else if (product instanceof Clothing clothing) {
            System.out.println("Clothing size: " + clothing.getSize());
        } else {
            throw new UnknownProductTypeException("Unsupported product type: " + product.getClass());
        }
    }

    public void processWith(Consumer<T> processorFunction) {
        processorFunction.accept(product);
    }

    public static <T extends Product> void processOrder(OrderProcessor<T> processor) {
        processor.process();
    }
}