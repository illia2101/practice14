package ua.university.task1;

import java.util.List;

public class TaskOneRun {
    public static void main(String[] args) throws InterruptedException {
        List<Order> orders = List.of(
                new Order(1, 1000),
                new Order(2, 2500)
        );

        final int[] sum = {0};
        final int[] max = {Integer.MIN_VALUE};

        Runnable sumTask = () -> {
            int localSum = 0;
            for (Order o : orders) {
                localSum += o.totalCents();
            }
            sum[0] = localSum;

        };

        Runnable maxTask = () -> {
            int localMax = Integer.MIN_VALUE;
            for (Order o : orders) {
                if (o.totalCents() > localMax) {
                    localMax = o.totalCents();
                }
            }
            max[0] = localMax;
        };
        TaskRunner.runAndWait(List.of(sumTask, maxTask));

        System.out.println("Sum: " + sum[0]);
        System.out.println("Max: " + max[0]);
    }
}
