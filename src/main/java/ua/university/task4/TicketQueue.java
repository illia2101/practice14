package ua.university.task4;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class TicketQueue {
    private final BlockingQueue<SupportTicket> queue = new LinkedBlockingQueue<>();

    public static final SupportTicket POISON_PILL =
            new SupportTicket(-1, "SYSTEM", "STOP");

    public void put(SupportTicket ticket) throws InterruptedException {
        queue.put(ticket);
    }

    public SupportTicket take() throws InterruptedException {
        return queue.take();
    }

}
