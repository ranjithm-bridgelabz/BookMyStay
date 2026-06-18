package bookmystay;

public class Reservation {
    private String guestName;
    private String roomType;
    private String roomId;
    private boolean isConfirmed;

    public Reservation(String guestName, String roomType) {
        this.guestName = guestName;
        this.roomType = roomType;
        this.isConfirmed = false;
    }

    public String getGuestName() {
        return guestName;
    }

    public String getRoomType() {
        return roomType;
    }

    public void confirmReservation(String roomId) {
        this.roomId = roomId;
        this.isConfirmed = true;
    }

    public String getRoomId() {
        return roomId;
    }

    public boolean isConfirmed() {
        return isConfirmed;
    }

    @Override
    public String toString() {
        if (isConfirmed) {
            return "Reservation{guest='" + guestName + "', roomType='" + roomType + "', roomId='" + roomId + "', status='CONFIRMED'}";
        }
        return "ReservationRequest{guest='" + guestName + "', roomType='" + roomType + "', status='PENDING'}";
    }
}
