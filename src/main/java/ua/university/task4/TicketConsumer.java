package ua.university.task4;

import java.util.concurrent.ConcurrentHashMap;

public class TicketConsumer implements Runnable{
    private final TicketQueue queue;
    private final ConcurrentHashMap<String, Integer> stats;

    public TicketConsumer(TicketQueue queue, ConcurrentHashMap<String, Integer> stats) {
        this.queue = queue;
        this.stats = stats;
    }

    @Override
    public void run() {
        try {
            while (true) {
                SupportTicket ticket = queue.take();

                if (ticket == TicketQueue.POISON_PILL) {
                    break;
                }

                stats.merge(ticket.topic(), 1, Integer::sum);

            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
