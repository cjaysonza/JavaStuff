import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class Booking extends Room {
    public String bookingID;
    private Guest guest;
    private int numberOfNights;

    public Booking(int roomNumber, String roomType, double pricePerNight, Guest guest, int numberOfNights) {
        super(roomNumber, roomType, pricePerNight, true);
        this.guest = guest;
        this.numberOfNights = numberOfNights;
        this.bookingID = generateBookingID();
    }

    private String generateBookingID() {
        return "BOOK2025" + (new Random().nextInt(9000) + 1000);
    }

    public double calculateTotalCost() {
        double total = pricePerNight * numberOfNights;
        double tax = (total > 1000) ? total * 0.14 : total * 0.05;
        return total + tax;
    }

    public void printReceipt() throws IOException {
        String receiptFile = "receipt_" + bookingID + ".txt";
        FileWriter writer = new FileWriter(receiptFile);
        writer.write("Booking Receipt\n");
        writer.write("---------------------\n");
        writer.write("Booking ID: " + bookingID + "\n");
        writer.write(guest.summary() + "\n");
        writer.write("Room Number: " + roomNumber + "\n");
        writer.write("Room Type: " + roomType + "\n");
        writer.write(String.format("Price per Night: $%.2f\n", pricePerNight));
        writer.write("Nights: " + numberOfNights + "\n");
        writer.write(String.format("Total Cost (after tax): $%.2f\n", calculateTotalCost()));
        writer.close();
    }
}
