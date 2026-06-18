package bookmystay;

public class HotelApp {
    public static void main(String[] args) {
        System.out.println("Welcome to BookMyStay App!");
        
        System.out.println("\n--- [UC1: Initializing Inventory] ---");
        InventoryManager inventory = new InventoryManager();
        System.out.println("Single Rooms: " + inventory.getAvailableCount("Single") + " | Price: $" + inventory.getPrice("Single"));
        System.out.println("Double Rooms: " + inventory.getAvailableCount("Double") + " | Price: $" + inventory.getPrice("Double"));
        System.out.println("Suite Rooms: " + inventory.getAvailableCount("Suite") + " | Price: $" + inventory.getPrice("Suite"));
    }
}
