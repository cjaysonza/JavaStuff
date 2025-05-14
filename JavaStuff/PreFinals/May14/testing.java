import java.util.Scanner;

public class testing {
    public static void main(String[] args) {
        String line = "name name, name2. name3, name 4.";
        
        Scanner scan = new Scanner(line);
        scan.useDelimiter("\\.");

        String value1 = scan.next().trim();
        String value2 = scan.next().trim();

        System.out.println(value1);
        System.out.println(value2);

        scan.close();

    }
}
