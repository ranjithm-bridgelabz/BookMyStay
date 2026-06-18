package bookmystay;

public class HotelApp {
    public static void main(String[] args) {
        System.out.println("Welcome to BookMyStay App!");
        
        System.out.println("\n--- [UC1: Initializing Inventory] ---");
        InventoryManager inventory = new InventoryManager();
        System.out.println("Single Rooms: " + inventory.getAvailableCount("Single") + " | Price: $" + inventory.getPrice("Single"));
        System.out.println("Double Rooms: " + inventory.getAvailableCount("Double") + " | Price: $" + inventory.getPrice("Double"));
        System.out.println("Suite Rooms: " + inventory.getAvailableCount("Suite") + " | Price: $" + inventory.getPrice("Suite"));
        
        System.out.println("\n--- [UC2: Room Search & Availability Check] ---");
        SearchService searchService = new SearchService(inventory);
        searchService.searchRoom("Double");
        System.out.println("\n--- [UC3: Booking Request Queue (FIFO)] ---");
        BookingQueue bookingQueue = new BookingQueue();
        bookingQueue.addBookingRequest(new Reservation("Alice", "Single"));
        bookingQueue.addBookingRequest(new Reservation("Bob", "Double"));
        bookingQueue.addBookingRequest(new Reservation("Charlie", "Suite"));
        
        System.out.println("\n--- Processing Queue ---");
        while (bookingQueue.hasPendingRequests()) {
            bookingQueue.processNextRequest();
        }
    }
}
