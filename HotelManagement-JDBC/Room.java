package javasqlconnectivity;
public class Room {
    private int roomId;
    private String roomType;
    private double price;
    private String status;

    public Room(int roomId, String roomType, double price, String status) {
        this.roomId = roomId;
        this.roomType = roomType;
        this.price = price;
        this.status = status;
    }

    public int getRoomId() { return roomId; }
    public String getRoomType() { return roomType; }
    public double getPrice() { return price; }
    public String getStatus() { return status; }
}
