
import javax.swing.JOptionPane;

public class Displays {
    
    public static String typeOfDrink(){
        return JOptionPane.showInputDialog("Enter Drink type\n" +
        "(Drink)\n" +
        "(Beer)\n" +
        "(Wine)\n" +
        "(Juice)\n" +
        "(Exit)\n" +
        "[STRING INPUT]"
        );
    }

    // Make new Drink
    public static Drink createDrink() {
        String name = JOptionPane.showInputDialog("Enter Drink Name: ");
        double liters = Double.parseDouble(JOptionPane.showInputDialog("Enter liters [Int]:"));
        boolean bottled = JOptionPane.showConfirmDialog(null, "Is it Bottled?", "Bottled Status", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION;
        return new Drink(name, liters, bottled);
    }

    // Make new Beer
    public static Beer createBeer() {
        String name = JOptionPane.showInputDialog("Enter Beer name:");
        double liters = Double.parseDouble(JOptionPane.showInputDialog("Enter liters [Int]:"));
        boolean bottled = JOptionPane.showConfirmDialog(null, "Is it Bottled?", "Bottled Status", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION;
        double alcoholContent = Double.parseDouble(JOptionPane.showInputDialog("Enter alcohol content % [Double]:"));
        String color = JOptionPane.showInputDialog("Enter Beer color:");
        return new Beer(name, liters, bottled, alcoholContent, color);
    }

    // Make new Juice
    public static Juice createJuice() {
        String name = JOptionPane.showInputDialog("Enter Juice name:");
        double liters = Double.parseDouble(JOptionPane.showInputDialog("Enter liters [Int]:"));
        boolean bottled = JOptionPane.showConfirmDialog(null, "Is it Bottled?", "Bottled Status", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION;
        boolean hasPulp = JOptionPane.showConfirmDialog(null, "Does it have Pulp?", "Has Pulp?", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION;
        String flavor = JOptionPane.showInputDialog("Enter flavor:");
        return new Juice(name, liters, bottled, hasPulp, flavor);
    }

    public static Wine createWine() {
        String name = JOptionPane.showInputDialog("Enter Wine name:");
        double liters = Double.parseDouble(JOptionPane.showInputDialog("Enter liters [Int]:"));
        boolean bottled = JOptionPane.showConfirmDialog(null, "Is it Bottled?", "Bottled Status", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION;
        int alcoholPercent = Integer.parseInt(JOptionPane.showInputDialog("Enter alcohol percentage [Int]:"));
        String brand = JOptionPane.showInputDialog("Enter Brand:");
        return new Wine(name, liters, bottled, alcoholPercent, brand);
    }
}
