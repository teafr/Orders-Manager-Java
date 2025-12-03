package org.example.order.storage;

import lombok.Getter;
import org.example.order.processing.Product;

import java.util.ArrayList;
import java.util.List;

@Getter
public class OrderStorage {
    private final List<Product> products = new ArrayList<>();

    public void addProduct(Product product) {
        if (product == null) {
            throw new IllegalArgumentException("Product не може бути null");
        }
        products.add(product);
    }
}
