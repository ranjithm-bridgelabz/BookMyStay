package bookmystay;

import java.util.LinkedList;
import java.util.Queue;

public class BookingQueue {
    private Queue<Reservation> requestQueue;

    public BookingQueue() {
        this.requestQueue = new LinkedList<>();
    }

    public void addBookingRequest(Reservation reservation) {
        requestQueue.add(reservation);
        System.out.println("Enqueued booking request: " + reservation);
    }

    public Reservation processNextRequest() {
        Reservation next = requestQueue.poll();
        if (next != null) {
            System.out.println("Processing next request: " + next);
        } else {
            System.out.println("Queue is empty, no requests to process.");
        }
        return next;
    }

    public boolean hasPendingRequests() {
        return !requestQueue.isEmpty();
    }
    
    public int getQueueSize() {
        return requestQueue.size();
    }
}
