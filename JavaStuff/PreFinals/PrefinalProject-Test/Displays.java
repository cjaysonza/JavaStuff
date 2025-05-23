
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

    // Class within a Class. This is used to return multiple values from the login menu. 
    // This is just a workaround for not being able to return multiple values from a method in Java.
    static class LoginMenuResult {
        public enum LoginResult {
            ADMIN, TEACHING_STAFF, PREV, INVALID
        }
        public LoginResult result;
        public TeachingStaff teachingStaff; // Only used if result is 1

        public LoginMenuResult(LoginResult result) {
            this.result = result;
            this.teachingStaff = null;
        }

        public LoginMenuResult(TeachingStaff teachingStaff) {
            this.result = LoginResult.TEACHING_STAFF;
            this.teachingStaff = teachingStaff;
        }
    }

    // Login Menu
    public static LoginMenuResult displayLoginMenu(Admin admin, ArrayList<TeachingStaff> teachingStaff) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(borderEqual + borderEqual);
        System.out.println("Login Menu");
        System.out.println("Input 'prev' to return to the start menu.");
        System.out.println(borderEqual + borderEqual);

        System.out.print("Enter your username: ");
        String username = scanner.nextLine();
        System.out.print("Enter your password: ");
        String password = scanner.nextLine();
        scanner.close();
        
        // Check if the username is in the admin database
        if (username.equals((admin.getFirstname() + " " + admin.getSurname())) && password.equals(admin.getPassword())) {
            System.out.println("Logged in as: Administrator!");
            return new LoginMenuResult(LoginMenuResult.LoginResult.ADMIN);
        }

        // Check if the username is in the teaching staff database
        for (TeachingStaff staff : teachingStaff) {
            if (username.equals(staff.getFirstname() + " " + staff.getSurname()) && password.equals(staff.getPassword())) {
                System.out.println("Logged in as: Teaching Staff!");
                return new LoginMenuResult(staff);
            }
        }

        // Check if user just mispressed and wants to return to the start menu
        if (username.equals("prev") || password.equals("prev")) {
            System.out.println("returning to the start menu...");
            return new LoginMenuResult(LoginMenuResult.LoginResult.PREV);
        }

        // If no match is found, return a value to trigger an error message
        System.out.println("Invalid username or password. Please try again.");
        return new LoginMenuResult(LoginMenuResult.LoginResult.INVALID);

    }


    // IF a teaching staff member is logged in, this method will be used to display their menu.
    public static int displayTeachingStaffMenu(TeachingStaff teachingStaff) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println(borderEqual + borderEqual);
        System.out.println("Welcome " + teachingStaff.getFirstname() + ", " + teachingStaff.getSurname() + "!");
        System.out.println(teachingStaff.callInfo());
        System.out.println(borderEqual + borderEqual);
        System.out.println("1. View Courses");
        System.out.println("2. View Students");
        System.out.println("3. Grade Students of a Section");
        System.out.println("3. Logout");
        System.out.print("\nPlease select an option: ");
        String userInput = scanner.nextLine();
        scanner.close();

        return Integer.parseInt(userInput); // Return the user's choice as an integer
    }

    public static void chooseSectionToGrade(TeachingStaff teachingStaff) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(borderEqual + borderEqual);
        System.out.println("Choose a section to grade: ");
        for (int i = 0; i < teachingStaff.getSectionsHandled().size(); i++) {
            System.out.println((i + 1) + ". " + teachingStaff.getSectionsHandled().get(i));
        }
        System.out.print("\nPlease select an option: ");
        String userInput = scanner.nextLine();
        scanner.close();

        int sectionIndex = Integer.parseInt(userInput) - 1;
        if (sectionIndex >= 0 && sectionIndex < teachingStaff.getSectionsHandled().size()) {
            String selectedSection = teachingStaff.getSectionsHandled().get(sectionIndex);
            System.out.println("You have selected: " + selectedSection);
            // Add logic to grade students in the selected section
        } else {
            System.out.println("Invalid selection. Please try again.");
        }
    }

    public static void chooseCourseToGrade(TeachingStaff teachingStaff) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(borderEqual + borderEqual);
        System.out.println("Choose a course to grade: ");
        for (int i = 0; i < teachingStaff.getCoursesTaught().size(); i++) {
            System.out.println((i + 1) + ". " + teachingStaff.getCoursesTaught().get(i));
        }
        System.out.print("\nPlease select an option: ");
        String userInput = scanner.nextLine();
        scanner.close();

        int courseIndex = Integer.parseInt(userInput) - 1;
        if (courseIndex >= 0 && courseIndex < teachingStaff.getCoursesTaught().size()) {
            String selectedCourse = teachingStaff.getCoursesTaught().get(courseIndex);
            System.out.println("You have selected: " + selectedCourse);
            // Add logic to grade students in the selected course
        } else {
            System.out.println("Invalid selection. Please try again.");
        }

        }

        // public static 


}
    // Determine login result





//shift+alt+f to format the code