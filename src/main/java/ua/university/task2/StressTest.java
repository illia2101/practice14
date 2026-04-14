package ua.university.task2;

public class StressTest {

    public static void main(String[] args) throws InterruptedException {
        int violations = 0;
        int runs = 500;

        for (int i = 0; i < runs; i++) {
            Inventory inventory = new UnsafeInventory(100);

            Thread t1 = new Thread(() -> inventory.reserve(60));
            Thread t2 = new Thread(() -> inventory.reserve(60));

            t1.start();
            t2.start();

            t1.join();
            t2.join();

            if (inventory.available() < 0) {
                violations++;
            }
        }

        System.out.println("Violations: " + violations + " / " + runs);
    }
}
