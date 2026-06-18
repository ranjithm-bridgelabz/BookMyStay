package bookmystay;

public class SearchService {
    private InventoryManager inventoryManager;

    public SearchService(InventoryManager inventoryManager) {
        this.inventoryManager = inventoryManager;
    }

    public void searchRoom(String roomType) {
        System.out.println("Searching for room type: " + roomType);
        if (inventoryManager.isRoomAvailable(roomType)) {
            int availableCount = inventoryManager.getAvailableCount(roomType);
            double price = inventoryManager.getPrice(roomType);
            String amenities = inventoryManager.getAmenities(roomType);
            
            System.out.println(" -> Success: " + availableCount + " " + roomType + " room(s) available.");
            System.out.println("    Price    : $" + price + " per night");
            System.out.println("    Amenities: " + amenities);
        } else {
            System.out.println(" -> Sorry, no " + roomType + " rooms are currently available.");
        }
    }
}
