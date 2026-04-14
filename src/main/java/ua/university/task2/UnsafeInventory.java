package ua.university.task2;

public class UnsafeInventory implements Inventory {
    private int stock;

    public UnsafeInventory(int stock) {
        this.stock = stock;
    }
    @Override
    public boolean reserve(int amount) {
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
    public int available() {
        return stock;
    }
}
