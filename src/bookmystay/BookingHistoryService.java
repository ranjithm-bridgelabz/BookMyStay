package bookmystay;

import java.util.ArrayList;
import java.util.List;

public class BookingHistoryService {
    // List to store confirmed reservations for history and reporting
    private List<Reservation> bookingHistory;
    private InventoryManager inventoryManager;

    public BookingHistoryService(InventoryManager inventoryManager) {
        this.bookingHistory = new ArrayList<>();
        this.inventoryManager = inventoryManager;
    }

    public void addConfirmedReservation(Reservation reservation) {
        if (reservation.isConfirmed()) {
            bookingHistory.add(reservation);
            System.out.println(" -> Added to History: " + reservation.getRoomId() + " (" + reservation.getGuestName() + ")");
        }
    }

    public void cancelReservation(String roomId) {
        Reservation toCancel = null;
        for (Reservation res : bookingHistory) {
            if (res.isConfirmed() && res.getRoomId().equals(roomId)) {
                toCancel = res;
                break;
            }
        }

        if (toCancel != null) {
            bookingHistory.remove(toCancel);
            // Restore inventory
            inventoryManager.updateInventory(toCancel.getRoomType(), 1);
            System.out.println(" -> Cancelled Reservation: " + roomId + ". Inventory restored.");
        } else {
            System.out.println(" -> Cancellation Failed: Room " + roomId + " not found in history.");
        }
    }

    public void printBookingReport() {
        System.out.println("\n--- Booking History Report ---");
        if (bookingHistory.isEmpty()) {
            System.out.println("No active bookings.");
        } else {
            for (Reservation res : bookingHistory) {
                System.out.println(" - " + res.getRoomId() + " | Guest: " + res.getGuestName() + " | Room: " + res.getRoomType());
            }
        }
        System.out.println("------------------------------");
    }
}
