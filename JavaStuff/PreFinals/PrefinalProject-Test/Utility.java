import java.util.Random;

public class Utility {

    public static String generateRandomID() {
        Random rand = new Random();
        int id = 100000 + rand.nextInt(900000);
        return String.valueOf(id);
    }

    public static String[] parseArray(String input) {
        input = input.replaceAll("[\\[\\]]", "").trim();
        return input.split(";");
    }
}
