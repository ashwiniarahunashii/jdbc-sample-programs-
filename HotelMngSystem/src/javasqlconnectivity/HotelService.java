package javasqlconnectivity;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;

public class HotelService {
    private Scanner sc = new Scanner(System.in);

    public void registerUser() {
        System.out.print("Enter name: ");
        String name = sc.nextLine();
        System.out.print("Enter email: ");
        String email = sc.nextLine();
        System.out.print("Enter password: ");
        String password = sc.nextLine();

        try (Connection con = DBConnection.getConnection()) {
            PreparedStatement ps = con.prepareStatement("INSERT INTO users (name, email, password) VALUES (?, ?, ?)");
            ps.setString(1, name);
            ps.setString(2, email);
            ps.setString(3, password);
            ps.executeUpdate();
            System.out.println("User registered successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public User loginUser() {
        System.out.print("Enter email: ");
        String email = sc.nextLine();
        System.out.print("Enter password: ");
        String password = sc.nextLine();

        try (Connection con = DBConnection.getConnection()) {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM users WHERE email=? AND password=?");
            ps.setString(1, email);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new User(rs.getInt("id"), rs.getString("name"), rs.getString("email"));
            } else {
                System.out.println("Invalid credentials.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void viewRooms() {
        try (Connection con = DBConnection.getConnection()) {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM rooms WHERE status='available'");
            System.out.println("\nAvailable Rooms:");
            while (rs.next()) {
                System.out.println("Room ID: " + rs.getInt("room_id") +
                                   ", Type: " + rs.getString("room_type") +
                                   ", Price: " + rs.getDouble("price") +
                                   ", Status: " + rs.getString("status"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void bookRoom(int userId) {
        viewRooms();
        System.out.print("\nEnter Room ID to book: ");
        int roomId = sc.nextInt();
        sc.nextLine();
        String date = java.time.LocalDate.now().toString();

        try (Connection con = DBConnection.getConnection()) {
            PreparedStatement ps1 = con.prepareStatement("INSERT INTO bookings (user_id, room_id, booking_date) VALUES (?, ?, ?)");
            ps1.setInt(1, userId);
            ps1.setInt(2, roomId);
            ps1.setString(3, date);
            ps1.executeUpdate();

            PreparedStatement ps2 = con.prepareStatement("UPDATE rooms SET status='booked' WHERE room_id=?");
            ps2.setInt(1, roomId);
            ps2.executeUpdate();

            System.out.println("Room booked successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void cancelBooking(int userId) {
        System.out.print("Enter Room ID to cancel booking: ");
        int roomId = sc.nextInt();
        sc.nextLine();

        try (Connection con = DBConnection.getConnection()) {
        	PreparedStatement ps1 = con.prepareStatement("DELETE FROM bookings WHERE user_id=? AND room_id=?");
        	ps1.setInt(1, userId);
        	ps1.setInt(2, roomId);
        	int deleted = ps1.executeUpdate();

        	if (deleted > 0) {
        	    PreparedStatement ps2 = con.prepareStatement("UPDATE rooms SET status='available' WHERE room_id=?");
        	    ps2.setInt(1, roomId);
        	    ps2.executeUpdate();
        	    System.out.println("Booking cancelled.");
        	} else {
        	    System.out.println("No such booking found to cancel.");
        	}
        	
            System.out.println("Booking cancelled.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
