package org.example.order.threads;

import java.util.List;

public class ThreadManager {
    public static void runInParallel(List<Runnable> tasks) {
        tasks.forEach(task -> new Thread(() -> {
            try {
                task.run();
            } catch (Exception e) {
                System.out.println("Помилка під час обробки: " + e.getMessage());
            }
        }).start());
    }
}