package org.example.main;

import com.github.javafaker.Faker;
import org.example.order.processing.*;
import org.example.order.storage.OrderStorage;
import org.example.order.threads.ThreadManager;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Faker faker = new Faker();
        OrderStorage storage = new OrderStorage();

        Electronics phone = Electronics.builder()
                .name(faker.commerce().productName())
                .brand(faker.company().name())
                .build();

        Clothing tshirt = Clothing.builder()
                .name(faker.commerce().productName())
                .size("L")
                .build();

        storage.addProduct(phone);
        storage.addProduct(tshirt);

        List<OrderProcessor<? extends Product>> orders = new ArrayList<>();
        storage.getProducts().forEach(product -> orders.add(new OrderProcessor<>(product)));

        ThreadManager.runInParallel(orders);
    }
}