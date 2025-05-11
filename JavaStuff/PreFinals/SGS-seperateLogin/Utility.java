/*
 *
 *  This is a utility class that provides various helper methods for certain things in the project.
 * 
 */
import java.util.ArrayList;
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

    // Bubble sorting students alphabetically.
    public static ArrayList<Student> bubbleSortStudents(ArrayList<Student> students) {
    int n = students.size();
    for (int i = 0; i < n - 1; i++) {
        for (int j = 0; j < n - i - 1; j++) {
            String fullName1 = students.get(j).getSurname().toLowerCase().replace(" ", "") + students.get(j).getFirstname().toLowerCase().replace(" ", "");
            String fullName2 = students.get(j + 1).getSurname().toLowerCase().replace(" ", "") + students.get(j + 1).getFirstname().toLowerCase().replace(" ", "");

            if (fullName1.compareTo(fullName2) > 0) {
                // Swap students[j] and students[j+1]
                Student temp = students.get(j);
                students.set(j, students.get(j + 1));
                students.set(j + 1, temp);
            }
        }
    }
    return students;
}
}
