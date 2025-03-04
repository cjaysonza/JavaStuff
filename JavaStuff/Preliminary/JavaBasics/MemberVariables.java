import java.util.Scanner;

public class MemberVariables {
    public static void main (String[] args) {
        Scanner input = new Scanner(System.in); 

        String border = "\n=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=\n";
        String firstName = "", middleName = "", lastName = "";
        int age = 0;
        double weight = 0.0d;
        double height = 0.0d;

        System.out.print("Enter your First Name:\t");
        firstName = input.nextLine();

        System.out.print("Enter your Middle Name:\t");
        middleName = input.nextLine();
        
        System.out.print("Enter your Last Name:\t");
        lastName = input.nextLine();

        System.out.print("Enter your current Age:\t");
        age = input.nextInt();
        input.nextLine();

        System.out.print("Enter your Weight:\t");
        weight = input.nextDouble();
        input.nextLine();

        System.out.print("Enter your Height:\t");
        height= input.nextDouble();
        input.nextLine();


        System.out.printf(border + "Hi there, I am %s.%nMy full name is " + firstName + " " + middleName.toUpperCase().charAt(0) + ". " + lastName + 
        ".%nI am %d-years old, I weight %.3fKGs and stand currently at %.2f ft. tall" + border, firstName.toUpperCase(), age, weight, height);

        input.close();
    }
}
