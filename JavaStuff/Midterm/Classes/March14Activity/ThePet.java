import javax.swing.JOptionPane;

public class ThePet {
    public static void main(String[] args) {
        boolean running = true;
        
        Animal animal;

        String name = "", initialLifeExpect = "", species = "", kingdom = "";
        boolean hasOwner = false;
        int lifeExpectancy = 0;
        while (running) {
        // Initial Selection.
        String input = JOptionPane.showInputDialog(
            "What would you like to do?\n"  +
            "[1] View Pet: Name\n"  +
            "[2] View Pet: Name, Has Owner\n"  +
            "[3] View Pet: Name, Has Owner, Life Expectancy\n"  +
            "[4] View Pet: Name, Has Owner, Life Expectancy, Animal Species\n"  +
            "[5] View Pet: Name, Has Owner, Life Expectancy, Animal Species, Animal Kingdom\n"  +
            "[6] End Program"
        );

        switch(input.charAt(0)) {
            // Name of Pet
            case '1':
                name = JOptionPane.showInputDialog("Enter Pet Name: ");
                animal = new Animal(name);
                JOptionPane.showMessageDialog(null, 
                "PET INFO:\n" +
                "Pet Name: " + animal.getName());
            break;
            // Name, Owner Status
            case '2':
                name = JOptionPane.showInputDialog("Enter Pet Name: ");
                hasOwner = JOptionPane.showConfirmDialog(null, "Does Pet have an owner?", "Owner Status", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION;
                
                animal = new Animal(name, hasOwner);
                JOptionPane.showMessageDialog(null, 
                "PET INFO:\n" +
                "Pet Name: " + animal.getName() + "\n" +
                "Pet Owner: " + animal.isHasOwner()+ "\n"
                );
            break;
            
            /// Name, Owner Status, Life Expect
            case '3':
                name = JOptionPane.showInputDialog("Enter Pet Name: ");
                hasOwner = JOptionPane.showConfirmDialog(null, "Does Pet have an owner?", "Owner Status", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION;
                initialLifeExpect = JOptionPane.showInputDialog("How long does this Pet live?(yrs): ");
                lifeExpectancy = Integer.parseInt(initialLifeExpect);
                
                animal = new Animal(name, hasOwner, lifeExpectancy);
                JOptionPane.showMessageDialog(null, 
                "PET INFO:\n" +
                "Pet Name: " + animal.getName() + "\n" +
                "Pet Owner: " + animal.isHasOwner()+ "\n" +
                "Life Expectancy(yr/s): " + animal.getLifeExpectancy()+ "\n"
                );
            break;

            /// Name, Owner Status, Life Expect, Species
            case '4':
                name = JOptionPane.showInputDialog("Enter Pet Name: ");
                hasOwner = JOptionPane.showConfirmDialog(null, "Does Pet have an owner?", "Owner Status", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION;
                initialLifeExpect = JOptionPane.showInputDialog("How long does this Pet live?(yrs): ");
                species = JOptionPane.showInputDialog("Pet animal species is?: ");
                lifeExpectancy = Integer.parseInt(initialLifeExpect);
                
                animal = new Animal(name, hasOwner, lifeExpectancy, species);
                JOptionPane.showMessageDialog(null, 
                "PET INFO:\n" +
                "Pet Name: " + animal.getName() + "\n" +
                "Pet Owner: " + animal.isHasOwner()+ "\n" +
                "Life Expectancy(yr/s): " + animal.getLifeExpectancy()+ "\n" +
                "Animal Species: " + animal.getSpecies()+ "\n"
                );
            break;

            /// Name, Owner Status, Life Expect, Species, Kingdom
            case '5':
                name = JOptionPane.showInputDialog("Enter Pet Name: ");
                hasOwner = JOptionPane.showConfirmDialog(null, "Does Pet have an owner?", "Owner Status", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION;
                initialLifeExpect = JOptionPane.showInputDialog("How long does this Pet live?(yrs): ");
                species = JOptionPane.showInputDialog("Pet animal species is?: ");
                kingdom = JOptionPane.showInputDialog("Pet animal kingdom is?: ");
                lifeExpectancy = Integer.parseInt(initialLifeExpect);
                
                animal = new Animal(name, hasOwner, lifeExpectancy, species, kingdom);
                JOptionPane.showMessageDialog(null, 
                "PET INFO:\n" +
                "Pet Name: " + animal.getName() + "\n" +
                "Pet Owner: " + animal.isHasOwner()+ "\n" +
                "Life Expectancy(yr/s): " + animal.getLifeExpectancy()+ "\n" +
                "Animal Species: " + animal.getSpecies()+ "\n" +
                "Animal Kingdom: " + animal.getKingdom()+ "\n"
                );
            break;
            
            case '6':
                JOptionPane.showMessageDialog(null, "Ending Program");
                running = false;
            break;

            default:
                JOptionPane.showMessageDialog(null, "Invalid User Input");
            break;
            }
        }
    }    
}
