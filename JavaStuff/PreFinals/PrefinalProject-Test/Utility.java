import java.util.Random;

public class Utility {

    public static String generateRandomID() {
        Random rand = new Random();
        int id = 100000 + rand.nextInt(900000);
        return String.valueOf(id);
    }

    public static String[] parseArray(String input) {
        input = input.replaceAll("[\\[\\]]", "").trim();
        String[] output = input.split(";");
        for (int i = 0; i < output.length; i++) {
            output[i] = output[i].trim();
        }
        return output;
    }

    public static double[] parseDoubleArray(String input) {
        return stringArrayToDoubleArray(parseArray(input));
    }

    public static double[] stringArrayToDoubleArray(String[] stringArray) {
        double[] doubleArray = new double[stringArray.length];
        for (int i = 0; i < stringArray.length; i++) {
            // doubleArray[i] = Double.parseDouble(stringArray[i].trim());
            doubleArray[i] = 0;
        }
        return doubleArray;
    }
}
