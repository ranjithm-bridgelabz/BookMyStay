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
        
        System.out.println("\n--- [UC4: Room Allocation & Confirmation] ---");
        RoomAllocationService allocationService = new RoomAllocationService(inventory);
        
        while (bookingQueue.hasPendingRequests()) {
            Reservation request = bookingQueue.processNextRequest();
            if (request != null) {
                allocationService.allocateRoom(request);
            }
        }
        
        System.out.println("\n--- [UC5: Add-On Service Selection] ---");
        AddOnServiceManager serviceManager = new AddOnServiceManager();
        
        // Let's add some services to Alice's room (if it was confirmed, we'd need her room ID)
        // For demonstration, we'll extract Alice's ID if available.
        String aliceRoomId = "S-???";
        // We know Alice requested Single, so let's just use the first generated ID for Single
        // In reality, we'd store the reservation objects in a List or Map. 
        // For now, let's just use dummy IDs for demonstration of UC5.
        System.out.println("Adding services to Bob's reservation...");
        serviceManager.addService("D-184", new Service("Breakfast", 20.0));
        serviceManager.addService("D-184", new Service("Spa", 50.0));
        System.out.println("Bob's total add-on cost: $" + serviceManager.calculateAddOnTotal("D-184"));
        
        System.out.println("\n--- Final Inventory Status ---");
        System.out.println("Single Rooms: " + inventory.getAvailableCount("Single"));
        System.out.println("Double Rooms: " + inventory.getAvailableCount("Double"));
        System.out.println("Suite Rooms: " + inventory.getAvailableCount("Suite"));
    }
}
