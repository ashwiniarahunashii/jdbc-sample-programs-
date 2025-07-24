// Main.java
package javasqlconnectivity;
public class Main {
    public static void main(String[] args) {
        HotelService service = new HotelService();
        java.util.Scanner sc = new java.util.Scanner(System.in);

        while (true) {
        	System.out.println("********************************");
        	System.out.println("\n1. Register\n2. Login\n3. Exit");
        	System.out.println("********************************");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    service.registerUser();
                    break;
                case 2:
                    User user = service.loginUser();
                    if (user != null) {
                        while (true) {
                            System.out.println("\nWelcome, " + user.getName());
                            System.out.println("1. View Rooms\n2. Book Room\n3. Cancel Booking\n4. Logout");;
                            System.out.print("Choose an option: ");
                            int opt = sc.nextInt();
                            switch (opt) {
                                case 1: service.viewRooms(); break;
                                case 2: service.bookRoom(user.getId()); break;
                                case 3: service.cancelBooking(user.getId()); break;
                                case 4: System.out.println("Logged out."); return;
                                default: System.out.println("Invalid option");
                            }
                        }
                    }
                    break;
                case 3:
                    System.out.println("Thank you!");
                    return;
                default:
                    System.out.println("Invalid option");
            }
        }
    }
}