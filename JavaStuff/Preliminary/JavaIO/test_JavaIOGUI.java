import java.io.*;
import javax.swing.JOptionPane;

public class test_JavaIOGUI {
    public static void main(String[] args) throws IOException, FileNotFoundException {
        FileWriter outFile = new FileWriter("dataUserInput.txt");
        
        String username = JOptionPane.showInputDialog(null, "Enter your full name:");
        // outFile.write(username.toLowerCase().replace(' ', '_'));
    

        // String input = "Christian Sonza";
        // String expected = "christian-sonza";
        String emername = "Dad Sonza".toLowerCase();
        int space = username.indexOf(' ');
        int spaceforEmer = emername.indexOf(' ');
        // String USERNAME = username.substring(0, username.indexOf(' ')).concat("-").concat(username.substring(space + 1)).toLowerCase();
        /// Code above is for bitch ni   s
        
        String firstName = username.substring(0, space).toLowerCase();
        String lastName = username.substring(space + 1).toLowerCase();  
        
        String EMERFIRSTNAME = emername.substring(0, spaceforEmer).toLowerCase();
        String EMERLASTNAME = emername.substring(spaceforEmer + 1).toLowerCase();


        String AGE = "20";
        String PHONENUM = "12345678909";
        String ADDRESS = "Home".toLowerCase();
        String SALARY = "5000.00";
        double taxRate = 0.25;
        String TAXAMOUNT = "1250.00"; // Must be computed
        String AFTERDEDUC = "3250.00"; // Must be computed
        String EMERNPHONENUM = "12345678909";

        // String user = String.format("%s-%s %s %s %s %s %s %s %s ", firstName, lastName, AGE, PHONENUM, ADDRESS, SALARY, 
        // taxRate, TAXAMOUNT, AFTERDEDUC, EMERNAME, EMERNPHONENUM);

        String user = String.format("%s-%s %s %s %s %s %.2f %s %s %s-%s %s",
        firstName,
        lastName,
        AGE,
        PHONENUM,
        ADDRESS,
        SALARY,
        taxRate,
        TAXAMOUNT,
        AFTERDEDUC,
        EMERFIRSTNAME,
        EMERLASTNAME,
        EMERNPHONENUM
        );

        outFile.write(user);        
        
        // outFile.write(USERNAME);
        
        outFile.close();
       }
}
