package ua.university.task2;

public class TaskTwoRun {
    public static void main(String[] args) throws InterruptedException {
        testInventory(new UnsafeInventory(100), "UNSAFE");
        testInventory(new SynchronizedInventory(100), "SAFE");

    }
    private static void testInventory(Inventory inventory, String label) throws InterruptedException {
        Runnable task = () -> {
            boolean success = inventory.reserve(60);
            System.out.println(Thread.currentThread().getName() +
                    " reserved: " + success);
        };

        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println(label + " remaining: " + inventory.available());



    }
}
