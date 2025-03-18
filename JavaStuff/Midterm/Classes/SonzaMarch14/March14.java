import javax.swing.*;
public class March14 {
    public static void main(String[] args) {
        // Somethign about classes and stuff
        
        Student student1;
        boolean running =  true;
        
        String id = JOptionPane.showInputDialog("Input Student ID: ");
        String course = JOptionPane.showInputDialog("Input Student Course: ");
        String section = JOptionPane.showInputDialog("Input Student Section: ");
        String yearLevel = JOptionPane.showInputDialog("Input Student Year Level (INT): ");
        
        int yrlevel = Integer.parseInt(yearLevel);
        
        while (running) {    
        String userInput = JOptionPane.showInputDialog(
                "What would you like to do?" +
                "\n[1] See id" +
                "\n[2] See id, course" +
                "\n[3] See id, course, and section" +
                "\n[4] See id, course, section, and year-level" +
                "\n[5] Exit Program"
            );
        
        switch (userInput.charAt(0)) {
            case '1':
                student1 = new Student(id);
                JOptionPane.showMessageDialog(null, "Student ID: " + student1.getId());
            break;
            
            case '2':
                student1 = new Student(id, course);
                JOptionPane.showMessageDialog(null, 
                        "Student ID: " + student1.getId() +
                        "\nStudent Course: " + student1.getCourse() 
                        );
            break;
            
            case '3':
                student1 = new Student(id, course, section);
                JOptionPane.showMessageDialog(null, 
                        "Student ID: " + student1.getId() +
                        "\nStudent Course: " + student1.getCourse() +
                        "\nStudent Course: " + student1.getSection() 
                );

            break;
            
            case '4':
                student1 = new Student(id, course, section, yrlevel);
                JOptionPane.showMessageDialog(null,                         
                        "Student ID: " + student1.getId() +
                        "\nStudent Course: " + student1.getCourse() +
                        "\nStudent Course: " + student1.getSection() +
                        "\nStudent Course: " + student1.getYrlvl() +
                        "\nStudent Course: " + student1.getName()

                );

            break;
            
            case '5':
                JOptionPane.showMessageDialog(null, "Exiting Program");
                running = false;
            break;
            
            default:
                JOptionPane.showMessageDialog(null, "Invalid User Input");
                break;
        }
        
        
        }
        // End of Loop
        
    
    }
}