package ua.university.task3;

public class TaskThreeRun {
    public static void main(String[] args) throws InterruptedException {
        Account acc1 = new Account(1, 1000);
        Account acc2 = new Account(2, 1000);

        Runnable task1 = () -> {
            for (int i = 0; i < 5; i++) {
                TransferService.transfer(acc1, acc2, 10);
            }
        };

        Runnable task2 = () -> {
            for (int i = 0; i < 5; i++) {
                TransferService.transfer(acc2, acc1, 10);
            }
        };

        Thread t1 = new Thread(task1);
        Thread t2 = new Thread(task2);

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Final balances:");
        System.out.println("Acc1: " + acc1.getBalance());
        System.out.println("Acc2: " + acc2.getBalance());
    }
}
