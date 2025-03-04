import javax.swing.JOptionPane;
/*
 * 
 * @author csonza
 */

public class SonzaJan24 {
    public static void main(String [] args) {
        // Scanner input = new Scanner(System.in);
        
        /// Most things are the same as lecture during Jan24,2025 ComSci 1-C 6:00PM-8:00PM
        
        // double something = 1.5;

        // S
        
        // String number1 = "8654";
        // String double1 = "5678.123";
        // int num1 = Integer.parseInt(number1);
        // System.out.println(num1);tring name = "Alejandro";
        // int age = 21;
        // double height = 5.8;
        // double weight = 65.43;

        // // System.out.printf("%05.2f", something); // Only 0 is for flagging, the rest is # of spacing
        
        // System.out.printf("Hello World!, I am %s, %d-years old. %n" + 
        // "I weigh %.4fKGs and I am %.2f-ft. tall", name, age, weight, height);

        /// PARSING NUMERIC STRINGS

        // double doub1 = Double.parseDouble(double1);
        // System.out.println(doub1);


        /// ||
        /// ||
        /// ||
        /// \/
        /// JOPTION PANE We doing Graphics now bois
        
        // String num1 = "";
        // num1 = JOptionPane.showInputDialog("Enter a numeric value: ");
        // // int NUM1 = Integer.parseInt(num1);
        // double priceValue = Double.parseDouble(num1);
        // // JOptionPane.showMessageDialog(null, "The sum is: " + (NUM1 + 10));

        // String output = String.format("The Price is: $%.2f", priceValue + 10);
        // System.out.println(output);
        // JOptionPane.showMessageDialog(null, output);

        /// ACIVITY
        String firstName = "", middleName = "", lastName = "";
        String age = "";
        String weight = "";
        String height = "";

        int AGE = 0;
        double WEIGHT = 0.0d;
        double HEIGHT = 0.0d;

        String outputMessage = "";

        firstName = JOptionPane.showInputDialog("Enter your First Name: ");
        middleName = JOptionPane.showInputDialog("Enter your Middle Name: ");
        lastName = JOptionPane.showInputDialog("Enter your Last Name: ");

        age = JOptionPane.showInputDialog("Enter your age: ");
        AGE = Integer.parseInt(age);
        weight = JOptionPane.showInputDialog("Enter your Weight: ");
        WEIGHT = Double.parseDouble(weight);
        height = JOptionPane.showInputDialog("Enter your Height: ");
        HEIGHT = Double.parseDouble(height);

        // outputMessage = String.format("Hi there, I am %s!%nMy full name is " + firstName + " " + middleName.toUpperCase().charAt(0) + ". " + lastName + 
        // ".%nI am %d-years old, I weigh %.3fKGs and stand currently at %.2f ft. tall", firstName, AGE, WEIGHT, HEIGHT);

        outputMessage = String.format("Hi there, I am %s!%nMy full name is %s %s %s.%nI am %d-years old, I weigh %.3fKGs and stand currently at %.2f ft. tall", firstName, firstName, middleName.toUpperCase().charAt(0), lastName, AGE, WEIGHT, HEIGHT);

        JOptionPane.showMessageDialog(null, outputMessage);
        System.out.println(outputMessage);

        // input.close();
    }
}
