package org.example.order.threads;

import org.example.order.processing.OrderProcessor;
import java.util.List;

public class ThreadManager {
    public static <T extends OrderProcessor<?>> void runInParallel(List<T> processors) {
        processors.forEach(processor -> new Thread(processor::process).start());
    }
}