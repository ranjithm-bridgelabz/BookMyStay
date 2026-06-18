package bookmystay;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class RoomAllocationService {
    private InventoryManager inventoryManager;
    private Set<String> bookedRoomIds;
    private Map<String, Set<String>> roomTypeToAssignedRooms;

    public RoomAllocationService(InventoryManager inventoryManager) {
        this.inventoryManager = inventoryManager;
        this.bookedRoomIds = new HashSet<>();
        this.roomTypeToAssignedRooms = new HashMap<>();
    }

    public void allocateRoom(Reservation reservation) {
        String roomType = reservation.getRoomType();
        
        if (inventoryManager.isRoomAvailable(roomType)) {
            // Generate a unique Room ID
            String roomId = generateUniqueRoomId(roomType);
            
            // Allocate the room
            bookedRoomIds.add(roomId);
            roomTypeToAssignedRooms.computeIfAbsent(roomType, k -> new HashSet<>()).add(roomId);
            
            // Confirm reservation
            reservation.confirmReservation(roomId);
            
            // Decrement inventory
            inventoryManager.updateInventory(roomType, -1);
            
            System.out.println(" -> Successfully allocated Room " + roomId + " to " + reservation.getGuestName());
        } else {
            System.out.println(" -> Allocation Failed: No " + roomType + " rooms available for " + reservation.getGuestName());
        }
    }

    private String generateUniqueRoomId(String roomType) {
        String roomId;
        do {
            // Simple logic for room ID: Type Prefix + Random Number
            roomId = roomType.substring(0, 1).toUpperCase() + "-" + (int)(Math.random() * 1000 + 100);
        } while (bookedRoomIds.contains(roomId));
        return roomId;
    }
}
