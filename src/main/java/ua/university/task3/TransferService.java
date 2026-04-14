package ua.university.task3;

public class TransferService {

    public static void transfer(Account from, Account to, int amount) {
        Account first;
        Account second;

        if (from.getId() < to.getId()) {
            first = from;
            second = to;
        } else {
            first = to;
            second = from;
        }

        synchronized (first) {
            synchronized (second) {

                if (from.getBalance() < amount) {
                    System.out.println("Not enough money");
                    return;
                }

                from.withdraw(amount);
                to.deposit(amount);

                System.out.println(Thread.currentThread().getName() +
                        " transferred " + amount +
                        " from " + from.getId() +
                        " to " + to.getId());
            }
        }
    }
}
