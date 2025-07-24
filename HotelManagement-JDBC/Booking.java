package javasqlconnectivity;
public class Booking {
    private int bookingId;
    private int userId;
    private int roomId;
    private String bookingDate;

    public Booking(int bookingId, int userId, int roomId, String bookingDate) {
        this.bookingId = bookingId;
        this.userId = userId;
        this.roomId = roomId;
        this.bookingDate = bookingDate;
    }

    public int getBookingId() { return bookingId; }
    public int getUserId() { return userId; }
    public int getRoomId() { return roomId; }
    public String getBookingDate() { return bookingDate; }
}