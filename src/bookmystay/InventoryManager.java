package bookmystay;

import java.util.HashMap;
import java.util.Map;

public class InventoryManager {
    // Stores the available count for each room types
    private Map<String, Integer> roomCounts;
    // Stores the price per night for each room type
    private Map<String, Double> roomPrices;

    public InventoryManager() {
        this.roomCounts = new HashMap<>();
        this.roomPrices = new HashMap<>();
        initializeDefaultInventory();
    }

    private void initializeDefaultInventory() {
        // Initializing room types with counts and prices
        addRoomType("Single", 10, 100.0);
        addRoomType("Double", 5, 150.0);
        addRoomType("Suite", 2, 300.0);
    }

    public void addRoomType(String type, int count, double price) {
        roomCounts.put(type, count);
        roomPrices.put(type, price);
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
}
