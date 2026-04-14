package ua.university.task2;

public interface Inventory {
    boolean reserve(int amount);
    int available();
}
