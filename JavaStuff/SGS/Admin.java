import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Admin extends Person {
    public String adminID;
    public String password;
    public String adminFileName;

    public String getAdminID() {
        return adminID;
    }

    public String getPassword() {
        return password;
    }   

    public String getAdminFileName() {
        return adminFileName;
    }

    public Admin(String surname, String firstname, String adminID, String password, String adminFilePath) {
        super(surname, firstname);
        this.adminID = adminID;
        this.password = password;
        this.adminFileName= adminFilePath;
    }

    // There can only be one admin in the system, so this method will return the first admin found in the file only.
    public static Admin readAdminFromFile() throws FileNotFoundException {
        try (Scanner adminScanner = new Scanner(new File("masterDatabase/adminDatabase.txt"))) {
            adminScanner.hasNextLine();
                String line = adminScanner.nextLine().trim();
                Admin admin = fromString(line);
                if (admin != null) {
                    return admin;
                }
            }
            System.out.println("No admin found in the file.");
            return null;
        }
    

    public static Admin fromString(String adminString) {
        if(adminString == null || adminString.isEmpty()) {
            return null;
        }
        Scanner adminStringScanner = new Scanner(adminString);
        adminStringScanner.useDelimiter(",");
        String surname = adminStringScanner.next();
        String firstname = adminStringScanner.next();
        String adminID = adminStringScanner.next();
        String password = adminStringScanner.next();
        String adminFileName = "TheAdmin-" + adminID + ".txt";
        adminStringScanner.close();
        return new Admin(surname, firstname, adminID, password, adminFileName);
    }

    @Override
    public String toString() {
        return surname + "," + firstname + "," + adminID + "," + password;
    }


}
