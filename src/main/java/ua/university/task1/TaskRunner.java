package ua.university.task1;

import java.util.ArrayList;
import java.util.List;

public class TaskRunner {
    public static void runAndWait(List<Runnable> tasks) {
        List<Thread> threads = tasks.stream()
                .map(Thread::new)
                .toList();

        threads.forEach(Thread::start);
        for (Thread thread : threads) {
        try {
                thread.join();
            } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            }
        }
    }
}
