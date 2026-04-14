package ua.university.task4;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class TaskFourRun {
    public static void main(String[] args) throws InterruptedException {

        TicketQueue queue = new TicketQueue();
        ConcurrentHashMap<String, Integer> stats = new ConcurrentHashMap<>();

        int consumersCount = 2;

        List<SupportTicket> tickets = List.of(
                new SupportTicket(1, "Alice", "Billing"),
                new SupportTicket(2, "Bob", "Tech"),
                new SupportTicket(3, "Alice", "Billing"),
                new SupportTicket(4, "John", "Tech"),
                new SupportTicket(5, "Emma", "General")
        );

        Thread producer = new Thread(
                new TicketProducer(queue, tickets, consumersCount)
        );

        Thread consumer1 = new Thread(new TicketConsumer(queue, stats));
        Thread consumer2 = new Thread(new TicketConsumer(queue, stats));

        producer.start();
        consumer1.start();
        consumer2.start();

        producer.join();
        consumer1.join();
        consumer2.join();

        System.out.println("Stats: " + stats);
    }
}
