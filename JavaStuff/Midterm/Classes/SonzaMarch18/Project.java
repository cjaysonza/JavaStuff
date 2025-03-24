
import javax.swing.JOptionPane;

public class Project {
    public static void main(String[] args) {
        // METHOD NI SIR
        // String choice = menu();
        
        // switch (choice) {
        //     case "1" -> {
        //         Car car = new Car();
        //         car.setBrand("Ford");
        //     } 

        //     case "2" -> {
        //         Truck truck = new Truck();
        //     }
                
        // }
        // Vehicle vehicle = manageVehicle(menu());
        // vehicle.        

        Vehicle ve1 = new Vehicle();
        ve1.setPlaceManufacture("Phiilippines");
        System.out.println(ve1.vehicleNo);
        ve1.setMiles_driven(Double.parseDouble(JOptionPane.showInputDialog("Enter Miles Driven [DOUBLE]: ")));
        // ve1.vehicleNo = 4;
        System.out.println(ve1.vehicleNo);
        System.out.println(ve1);

        Car car1 = new Car();
        System.out.println(car1.vehicleNo);
        Truck truck1 = new Truck();
        System.out.println(truck1.vehicleNo);
    }

    public static String menu(){
        String userInput = "";
        
        do { 
            userInput = JOptionPane.showInputDialog(
            "[A] Car\n" + 
            "[B] Truck"
            );
            if("AB".contains(userInput)) {return userInput;}
        } while (true);
    }

    public static Vehicle manageVehicle(String choice) {
        switch (choice) {
            case "1" -> {
                return new Car();
            }

            case "2" -> {
                return new Truck();
            }
        }
        return new Vehicle();
    }

}
