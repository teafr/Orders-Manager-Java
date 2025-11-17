package org.example.order.threads;

import org.example.order.processing.OrderProcessor;
import org.example.order.processing.UnknownProductTypeException;

import java.util.List;

public class ThreadManager {
    public static <T extends OrderProcessor<?>> void runInParallel(List<T> processors) {
        processors.forEach(processor -> new Thread(() -> {
                try {
                    processor.process();
                } catch (UnknownProductTypeException e) {
                    System.out.println("Помилка під час обробки: " + e.getMessage());
                }
            }).start()
        );
    }
}