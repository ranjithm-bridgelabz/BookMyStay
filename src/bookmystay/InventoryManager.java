package bookmystay;

import java.util.HashMap;
import java.util.Map;

public class InventoryManager {
    // Stores the available count for each room type
    private Map<String, Integer> roomCounts;
    // Stores the price per night for each room type
    private Map<String, Double> roomPrices;
    // Stores the amenities for each room type
    private Map<String, String> roomAmenities;

    public InventoryManager() {
        this.roomCounts = new HashMap<>();
        this.roomPrices = new HashMap<>();
        this.roomAmenities = new HashMap<>();
        initializeDefaultInventory();
    }

    private void initializeDefaultInventory() {
        // Initializing room types with counts, prices, and amenities
        addRoomType("Single", 10, 100.0, "1 Bed, AC, Free Wi-Fi");
        addRoomType("Double", 5, 150.0, "2 Beds, AC, TV, Free Wi-Fi");
        addRoomType("Suite", 2, 300.0, "King Bed, AC, TV, Minibar, City View");
    }

    public void addRoomType(String type, int count, double price, String amenities) {
        roomCounts.put(type, count);
        roomPrices.put(type, price);
        roomAmenities.put(type, amenities);
    }

    public void updateInventory(String type, int countDelta) {
        if (roomCounts.containsKey(type)) {
            int currentCount = roomCounts.get(type);
            roomCounts.put(type, currentCount + countDelta);
        }
    }

    public boolean isRoomAvailable(String type) {
        return roomCounts.getOrDefault(type, 0) > 0;
    }
    
    public int getAvailableCount(String type) {
        return roomCounts.getOrDefault(type, 0);
    }

    public double getPrice(String type) {
        return roomPrices.getOrDefault(type, 0.0);
    }
    
    public String getAmenities(String type) {
        return roomAmenities.getOrDefault(type, "Standard Amenities");
    }
}
