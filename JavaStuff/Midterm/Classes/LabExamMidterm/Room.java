public class Room {
    public int roomNumber;
    public String roomType;
    public double pricePerNight;
    public boolean isAvailable;

    public Room(int roomNumber, String roomType, double pricePerNight, boolean isAvailable) {
        this.roomNumber = roomNumber;
        this.roomType = formatProperCase(roomType);
        this.pricePerNight = pricePerNight;
        this.isAvailable = isAvailable;
    }

    public String formatProperCase(String input) {
        return input.substring(0, 1).toUpperCase() + input.substring(1).toLowerCase();
    }
}