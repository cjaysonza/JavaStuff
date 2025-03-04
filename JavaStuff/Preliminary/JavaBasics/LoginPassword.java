import java.util.Scanner;

public class LoginPassword {
    public static void main (String[] args) {
        // This is for Account Creation and Login Page
        try (Scanner input = new Scanner(System.in)) {
            System.out.println("This is a login screen test\n");
            String username = null, usernameLogin;
            String password = null, passwordVerify;
            String passwordLogin;
            boolean accountCreated = false;
            boolean loggedIn = false;
            // Account Cration
            while (!accountCreated) { 
                System.out.println("ACCOUNT CREATION PAGE");
                System.out.println("Password must be greater than 8 characters");
                System.out.print("Enter your Username:\t");
                username = input.nextLine();
                System.out.print("Enter Password:\t\t");
                password = input.nextLine();
                System.out.print("Verify Password:\t");
                passwordVerify = input.nextLine();

                if (password.isEmpty() || !passwordVerify.equals(password) || password.length() < 8) {
                    System.out.println("\nPassword Input Error, Try Again\n");
                } else {
                    System.out.println("\nAccount Successfully Created");
                    System.out.println("Proceeding to Login Page\n");
                    accountCreated = true;
                }
            }
            // Login Page
            while (!loggedIn) {
                System.out.println("LOGIN PAGE");
                System.out.print("Enter Username:\t");
                usernameLogin = input.nextLine();
                System.out.print("Enter Password:\t");
                passwordLogin = input.nextLine();

                if (!usernameLogin.equals(username) || !passwordLogin.equals(password)) {
                    System.out.println("\nLogin Error. Wrong Username or Password");
                    System.out.println("Try Again\n");
                } else {
                    System.out.println("\nLogin Successful");
                    System.out.println("Hello, " + username + ". Welcome to my Program");
                    System.out.println("[Everything else is a TODO]");
                    System.out.println("[Will be Closing Current Program]");
                    System.out.println("\n");
                    loggedIn = true;
                }
            }
// End of Program
// Copy this program if you need a login screen
        }
    }
}
