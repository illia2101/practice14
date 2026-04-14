package ua.university.task4;

import java.util.List;

public class TicketProducer implements Runnable{
    private final TicketQueue queue;
    private final List<SupportTicket> tickets;
    private final int consumersCount;

    public TicketProducer(TicketQueue queue, List<SupportTicket> tickets, int consumersCount) {
        this.queue = queue;
        this.tickets = tickets;
        this.consumersCount = consumersCount;
    }

    @Override
    public void run() {
        try {
            for (SupportTicket ticket : tickets) {
                queue.put(ticket);
            }

            for (int i = 0; i < consumersCount; i++) {
                queue.put(TicketQueue.POISON_PILL);
            }

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
