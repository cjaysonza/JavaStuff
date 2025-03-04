/*
 * @author csonza
 *  Yes, I made this code.
 */
import java.io.*;
import java.util.Scanner;
import javax.swing.*;

public class SonzaLabAct14 {
    public static void main(String[] args) throws IOException, FileNotFoundException {
        
        String usernameIn = JOptionPane.showInputDialog(null, "Enter your Full Name:");
        String ageIn = JOptionPane.showInputDialog(null, "Enter your Age:");
        String phoneNum = JOptionPane.showInputDialog(null, "Enter your Phone Number(Min. 11#):").toLowerCase();
        String occupation = JOptionPane.showInputDialog(null, "Enter your Occupation:").toLowerCase();
        String salaryIn = JOptionPane.showInputDialog("Enter your Salary(Must have 3 decimals):").toLowerCase();
        String homeaddress = JOptionPane.showInputDialog(null, "Enter your Home Address:").toLowerCase();
        String currentaddress = JOptionPane.showInputDialog(null, "Enter your Current Address:").toLowerCase();
        String emerNameIn = JOptionPane.showInputDialog(null, "Enter Emergency Contact Person Name:").toLowerCase();
        String emerPhoneNum = JOptionPane.showInputDialog(null, "Enter Emergency Contact Person's Number(Min. 11#):").toLowerCase();
        
        String space = " "; 
        
        double salary = Double.parseDouble(salaryIn);
        double taxRateFixed = 0.25d; // Used in File Processing
        
        int whitespace1 = usernameIn.indexOf(' ');
        int whitespace2 = emerNameIn.indexOf(' ');

        String firstNameU = usernameIn.substring(0, whitespace1).toLowerCase();
        String lastNameU = usernameIn.substring(whitespace1 + 1).toLowerCase();

        String firstNameE = emerNameIn.substring(0, whitespace2);
        String lastNameE = emerNameIn.substring(whitespace2 + 1).toLowerCase();

        String user1 = String.format("%s_%s %s %s %s %.3f %s %s %s_%s %s",
        firstNameU,
        lastNameU,
        ageIn,
        phoneNum,
        occupation,
        salary,
        homeaddress,
        currentaddress,
        firstNameE,
        lastNameE,
        emerPhoneNum
        );
        FileWriter outFile = new FileWriter("personalInfo.txt");
        outFile.write(user1);
        outFile.close();
        /// Where user Input ends
        
        /// File Processing to make GUI
        Scanner inFile = new Scanner(new FileReader("personalInfo.txt"));
        String outFUsername = inFile.next();
        String outAge = inFile.next();
        String UserPhoneNum = inFile.next();
        String outOccupation = inFile.next();
        double outSalary = inFile.nextDouble();
        String outHomeAddress = inFile.next();
        String outCurAddress = inFile.next();
        String outFEmerName = inFile.next();
        String FEmerPhoneNum = inFile.next();
        
        String oneUPhoneNum = UserPhoneNum.substring(0, 4);
        String twoUPhoneNum = UserPhoneNum.substring(4, 7);
        String threeUPhoneNum = UserPhoneNum.substring(7);

        String outPhoneNum = oneUPhoneNum + space + twoUPhoneNum + space + threeUPhoneNum;
        
        String oneEPhoneNum = FEmerPhoneNum.substring(0, 4);
        String twoEPhoneNum = FEmerPhoneNum.substring(4, 7);
        String threeEPhoneNum = FEmerPhoneNum.substring(7);
        
        String outEmerPhoneNum = oneEPhoneNum + space + twoEPhoneNum + space + threeEPhoneNum;

        double outTax = outSalary * taxRateFixed;
        double outTotalSalary = outSalary - outTax;
        
        int dash1 = outFUsername.lastIndexOf('_');
        int dash2 = outFEmerName.lastIndexOf('_');

        String outUsernameFinal = outFUsername.substring(0, 1).toUpperCase().concat(outFUsername.substring(1, dash1)) + space
        .concat(outFUsername.substring(dash1+1, dash1+2).toUpperCase().concat(outFUsername.substring(dash1 + 2)));

        String outEmerNameFinal = outFEmerName.substring(0, 1).toUpperCase().concat(outFEmerName.substring(1, dash2)) + space
        .concat(outFEmerName.substring(dash2+1, dash2+2).toUpperCase().concat(outFEmerName.substring(dash2 + 2)));

        String Occupation = outOccupation.substring(0,1).toUpperCase().concat(outOccupation.substring(1));
        String HomeAddress = outHomeAddress.substring(0,1).toUpperCase().concat(outHomeAddress.substring(1));
        String CurAddress = outCurAddress.substring(0,1).toUpperCase().concat(outCurAddress.substring(1));


        String showUser = String.format(
            "Name: %s\n" +
            "Age: %s\n" +
            "Phn. No.: %s\n" +
            "=-=-=-=-=-=-=-=-=-=-=-=-=\n" + 
            "Occupation:   %s\n" +
            "Salary:       $%,.3f\n" + 
            "Tax 20%%      $%,.3f\n" + 
            "Aft Deduc:    $%,.3f\n" + 
            "=-=-=-=-=-=-=-=-=-=-=-=-=\n" + 
            "Home:         %s\n" +
            "Current:      %s\n" +
            "=-=-=-=-=-=-=-=-=-=-=-=-=\n" + 
            "Emrgncy Cont: %s\n" +
            "Emrgncy N0.:  %s\n",
            outUsernameFinal,
            outAge,
            outPhoneNum,
            Occupation,
            outSalary,
            outTax,
            outTotalSalary,
            HomeAddress,
            CurAddress,
            outEmerNameFinal,
            outEmerPhoneNum

            );
        
        inFile.close();
        JOptionPane.showMessageDialog(null, showUser);
    }
}
