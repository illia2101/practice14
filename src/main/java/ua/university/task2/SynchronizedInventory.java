package ua.university.task2;

public class SynchronizedInventory implements Inventory {
    private int stock;

    public SynchronizedInventory(int stock) {
        this.stock = stock;
    }
    @Override
    public synchronized boolean reserve(int amount) {
        if(stock >= amount) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {}
            stock -= amount;
            return true;
        }
        return false;
    }
    @Override
    public synchronized int available() {
        return stock;
    }
}
