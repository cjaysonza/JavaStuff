import java.io.*;
import javax.swing.*;


public class CamposShenanigans {
    public static void main (String[] args) throws FileNotFoundException, IOException {
        FileWriter inpuFile = new FileWriter("input.txt", true);

        String sentinel = "DAWGEMO";
        String name;

        while(true) {
            name = JOptionPane.showInputDialog("Enter a name");

            if(name.equalsIgnoreCase(sentinel)) {

            }
        }
    }
}