import java.io.*;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class HotelManagementSystem {
    public static void main(String[] args) throws IOException {
        // JOptionPane.showMessageDialog(null, "Welcome to the Hotel Management System!\n");

        // Scanner fileScanner = new Scanner(new File("room.txt"));
        // String selectedRoomType = "";
        // double selectedRoomPrice = 0.0;
        // boolean roomFound = false;
        // String allRooms = "";

        // while (fileScanner.hasNextLine()) {
        //     String line = fileScanner.nextLine();
        //     Scanner lineScanner = new Scanner(line);
        //     lineScanner.useDelimiter(",");
            
        //     int roomNumber = Integer.parseInt(lineScanner.next());
        //     String roomType = lineScanner.next();
        //     double pricePerNight = Double.parseDouble(lineScanner.next());
        //     boolean isAvailable = Boolean.parseBoolean(lineScanner.next());
            
        //     if (isAvailable) {
        //         // JOptionPane.showMessageDialog(null, String.format("Room %d (%s) - $%.2f per night", roomNumber, roomType, pricePerNight));
        //         allRooms += String.format("Room %d (%s) - $%.2f per night \n", roomNumber, roomType, pricePerNight);
        //     }
        // }
        // // JOptionPane.showMessageDialog(null, "Available Rooms: \n" + allRooms);
        
        // int selectedRoomNumber = Integer.parseInt(JOptionPane.showInputDialog("Available Rooms: \n" + allRooms + "\nEnter Room Number to book:"));
        

        
        // fileScanner = new Scanner(new File("room.txt"));
        // while (fileScanner.hasNextLine()) {
        //     String line = fileScanner.nextLine();
        //     Scanner lineScanner = new Scanner(line);
        //     lineScanner.useDelimiter(",");

        //     int roomNumber = Integer.parseInt(lineScanner.next());
        //     String roomType = lineScanner.next();
        //     double pricePerNight = Double.parseDouble(lineScanner.next());
        //     boolean isAvailable = Boolean.parseBoolean(lineScanner.next());

        //     if (roomNumber == selectedRoomNumber && isAvailable) {
        //         selectedRoomType = roomType;

        //         selectedRoomPrice = pricePerNight;
        //         roomFound = true;
        //         break;
        //     }
        // }

        // if (!roomFound) {
        //     JOptionPane.showMessageDialog(null, "Selected room is not available. Exiting.");
        //     System.exit(0);
        // }

        // String name = JOptionPane.showInputDialog("Enter Full Name:");
        // int age = Integer.parseInt(JOptionPane.showInputDialog("Enter Age:"));
        // String contact = JOptionPane.showInputDialog("Enter Contact Number:");
        // String email = JOptionPane.showInputDialog("Enter Email:");
        // int nights = Integer.parseInt(JOptionPane.showInputDialog("Enter Number of Nights:"));

        // Guest guest = new Guest(name, age, contact, email);
        // Booking booking = new Booking(selectedRoomNumber, selectedRoomType, selectedRoomPrice, guest, nights);

        // booking.printReceipt();
        // JOptionPane.showMessageDialog(null, "Booking Confirmed! Receipt saved as receipt_" + booking.bookingID + ".txt");

        // fileScanner.close();

         JOptionPane.showMessageDialog(null, "Welcome to the Hotel Management System!\n");

        Scanner fileScanner = new Scanner(new File("room.txt"));
        String selectedRoomType = "";
        double selectedRoomPrice = 0.0;
        boolean roomFound = false;
        String updatedRoomData = "";

        JOptionPane.showMessageDialog(null, "Available Rooms:");
        while (fileScanner.hasNextLine()) {
            String line = fileScanner.nextLine();
            Scanner lineScanner = new Scanner(line);
            lineScanner.useDelimiter(",");

            int roomNumber = Integer.parseInt(lineScanner.next().trim());
            String roomType = lineScanner.next().trim();
            double pricePerNight = Double.parseDouble(lineScanner.next().trim());
            boolean isAvailable = Boolean.parseBoolean(lineScanner.next().trim());

            if (isAvailable) {
                JOptionPane.showMessageDialog(null, String.format("Room %d (%s) - $%.2f per night", roomNumber, roomType, pricePerNight));
            }
        }

        int selectedRoomNumber = Integer.parseInt(JOptionPane.showInputDialog("Enter Room Number to book:"));

        fileScanner = new Scanner(new File("room.txt"));
        while (fileScanner.hasNextLine()) {
            String line = fileScanner.nextLine();
            Scanner lineScanner = new Scanner(line);
            lineScanner.useDelimiter(",");

            int roomNumber = Integer.parseInt(lineScanner.next().trim());
            String roomType = lineScanner.next().trim();
            double pricePerNight = Double.parseDouble(lineScanner.next().trim());
            boolean isAvailable = Boolean.parseBoolean(lineScanner.next().trim());

            if (roomNumber == selectedRoomNumber && isAvailable) {
                selectedRoomType = roomType;
                selectedRoomPrice = pricePerNight;
                roomFound = true;
                isAvailable = false;
            }
            updatedRoomData += roomNumber + "," + roomType + "," + pricePerNight + "," + isAvailable + "\n";
        }

        if (!roomFound) {
            JOptionPane.showMessageDialog(null, "Selected room is not available. Exiting.");
            System.exit(0);
        }

        FileWriter fileWriter = new FileWriter("room.txt");
        fileWriter.write(updatedRoomData);
        fileWriter.close();

        String name = JOptionPane.showInputDialog("Enter Full Name:");
        int age = Integer.parseInt(JOptionPane.showInputDialog("Enter Age:"));
        String contact = JOptionPane.showInputDialog("Enter Contact Number:");
        String email = JOptionPane.showInputDialog("Enter Email:");
        int nights = Integer.parseInt(JOptionPane.showInputDialog("Enter Number of Nights:"));

        Guest guest = new Guest(name, age, contact, email);
        Booking booking = new Booking(selectedRoomNumber, selectedRoomType, selectedRoomPrice, guest, nights);

        booking.printReceipt();
        JOptionPane.showMessageDialog(null, "Booking Confirmed! Receipt saved as receipt_" + booking.bookingID + ".txt");

        fileScanner.close();

    }
}
