
import java.util.ArrayList;
import java.util.Scanner;

/*
 * 
 * This class will contain certain display methods and menu screens for the project.
 * 
 * 
 */
public class Displays {
    
    public static String borderDash = "--------------------------------------------------";
    public static String borderEqual = "==================================================";


    // Start Menu
    public static String displayStartMenu(String schoolName, int currentAcademicYear) {        
        Scanner scanner = new Scanner(System.in);
        System.out.println(borderEqual + borderEqual);
        System.out.println(schoolName + "\nAcademic Year: " + currentAcademicYear + "-" + (currentAcademicYear + 1));
        System.out.println(borderEqual + borderEqual);
        System.out.println("Welcome to the University Management System");
        System.out.println("1. Login as Teaching Staff");
        System.out.println("2. Exit");
        System.out.print("\nPlease select an option: ");
        String userInput = scanner.nextLine();
        return userInput; 
    }

    public static void displayExitMessage() {
        System.out.println(borderEqual + borderEqual);
        System.out.println("Thank you for using the University Management System. Goodbye!");
        System.out.println(borderEqual + borderEqual);
    }

    // Login Menu
    public static String displayLoginMenu(Admin admin, ArrayList<TeachingStaff> teachingStaff) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(borderEqual + borderEqual);
        System.out.println("Login Menu");
        System.out.println(borderEqual + borderEqual);

        System.out.print("Enter your username: ");
        String username = scanner.nextLine();
        System.out.print("Enter your password: ");
        String password = scanner.nextLine();

        // Check if the username is in the admin database
        if (username.equals((admin.getFirstname() + " " + admin.getSurname())) && password.equals(admin.getPassword())) {
            System.out.println("Logged in as: Administrator!");
            return "admin"; // Return as a single string separated by a comma
        }

        // Check if the username is in the teaching staff database
        for (TeachingStaff staff : teachingStaff) {
            if (username.equals(staff.getFirstname() + " " + staff.getSurname()) && password.equals(staff.getPassword())) {
                System.out.println("Logged in as: Teaching Staff!");
                return "teachingStaff"; // Return as a single string separated by a comma
            }
        }

        // Check if user just mispressed and wants to return to the start menu
        if (username.equals("exit") || password.equals("exit")) {
            System.out.println("returning to the start menu...");
            return "exit"; // Return as a single string separated by a comma
        }

        // If no match is found, return a value to trigger an error message
        System.out.println("Invalid username or password. Please try again.");
        return "invalid"; // Return as a single string separated by a comma
    }


    

}
    // Determine login result
    // String loginResult = "invalid";
    // if (username.equals((admin.getFirstname() + " " + admin.getSurname())) && password.equals(admin.getPassword())) {
    //     loginResult = "admin";
    // } else {
    //     for (TeachingStaff staff : teachingStaff) {
    //         if (username.equals(staff.getFirstname() + " " + staff.getSurname()) && password.equals(staff.getPassword())) {
    //             loginResult = "teachingStaff";
    //             break;
    //         }
    //     }
    // }

    // if (username.equals("exit") || password.equals("exit")) {
    //     loginResult = "exit";
    // }

    // // Handle login result using switch-case
    // switch (loginResult) {
    //     case "admin":
    //         System.out.println("Logged in as: Administrator!");
    //         break;
    //     case "teachingStaff":
    //         System.out.println("Logged in as: Teaching Staff!");
    //         break;
    //     case "exit":
    //         System.out.println("Returning to the start menu...");
    //         break;
    //     default:
    //         System.out.println("Invalid username or password. Please try again.");
    //         break;
    // }

    // return loginResult;
    // }




//shift+alt+f to format the code