import javax.swing.JOptionPane;

public class Displays {
    public static String typeOfDrink() {
        return JOptionPane.showInputDialog("Enter drink type (Drink, Beer, Wine, Juice):" +"\n [Exit]");
    }

    public static Drink createDrink() {
        String type = typeOfDrink();
        if (type == null || type.equalsIgnoreCase("exit")) return null;

        switch (type.toLowerCase()) {
            case "beer": return createBeer();
            case "drink": return createDrink();
            case "juice": return createJuice();
            case "wine": return createWine();
            default:
                JOptionPane.showMessageDialog(null, "Invalid drink type!");
                return null;
        }
    }

    public static Beer createBeer() {
        String name = JOptionPane.showInputDialog("Enter beer name:");
        double liters = Double.parseDouble(JOptionPane.showInputDialog("Enter liters:"));
        boolean bottled = JOptionPane.showInputDialog("Is it bottled? (yes/no):").equalsIgnoreCase("yes");
        double alcoholContent = Double.parseDouble(JOptionPane.showInputDialog("Enter alcohol content %:"));
        String color = JOptionPane.showInputDialog("Enter beer color:");
        return new Beer(name, liters, bottled, alcoholContent, color);
    }

    public static Juice createJuice() {
        String name = JOptionPane.showInputDialog("Enter juice name:");
        double liters = Double.parseDouble(JOptionPane.showInputDialog("Enter liters:"));
        boolean bottled = JOptionPane.showInputDialog("Is it bottled? (yes/no):").equalsIgnoreCase("yes");
        boolean hasPulp = JOptionPane.showInputDialog("Does it have pulp? (yes/no):").equalsIgnoreCase("yes");
        String flavor = JOptionPane.showInputDialog("Enter flavor:");
        return new Juice(name, liters, bottled, hasPulp, flavor);
    }

    public static Wine createWine() {
        String name = JOptionPane.showInputDialog("Enter wine name:");
        double liters = Double.parseDouble(JOptionPane.showInputDialog("Enter liters:"));
        boolean bottled = JOptionPane.showInputDialog("Is it bottled? (yes/no):").equalsIgnoreCase("yes");
        int alcoholPercent = Integer.parseInt(JOptionPane.showInputDialog("Enter alcohol percentage:"));
        String brand = JOptionPane.showInputDialog("Enter brand:");
        return new Wine(name, liters, bottled, alcoholPercent, brand);
    }
}
