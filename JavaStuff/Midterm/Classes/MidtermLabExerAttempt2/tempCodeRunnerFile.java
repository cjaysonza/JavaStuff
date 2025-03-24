

        // MENU CONTROL FOR THE PURCHASING
        boolean running = true;
        double subtotal = 0.0d;

        while (running) {
            int userInput;
            boolean validInput = false;
            
            while (!validInput) {
                userInput = Integer.parseInt(JOptionPane.showInputDialog("[MUST BE INT INPUT]\n[0] Complete Purchase\n" + drinksData));
                if (userInput == 0) {
                    running = false;
                    break;
                }
                
                Scanner drinks = new Scanner(new FileReader("Data.txt")); // Reopen file scanner for each loop
                while (drinks.hasNext()) {
                    int drinkId = drinks.nextInt();
                    String drinkName = drinks.next();
                    double drinkPrice = drinks.nextDouble();

                    if (drinkId == userInput) {
                        int boughtAmount = Integer.parseInt(JOptionPane.showInputDialog("How many?"));
                        JOptionPane.showMessageDialog(null, drinkName + " Has been Added to Bill");
                        subtotal += (drinkPrice * boughtAmount);
                        receipt += String.format("%dx    %s\n", boughtAmount, drinkName);
                        validInput = true;
                        break;
                    }
                }
                drinks.close();
                
                if (!validInput) {
                    JOptionPane.showMessageDialog(null, "Input Invalid. Please enter a valid option.");
                }
            }
        }


        // SHOW RECIEPT
        double taxedAmmount = subtotal * .14;
        double totalFinal = subtotal + taxedAmmount;
        receipt += String.format (
            "\n=-=-=-=-=-=-=-=-=-=-=-=-=-=\n" +
            "Subtotal: $%.2f\n" +
            "Tax: $%.2f\n" +
            "Total: $%.2f\n",
            subtotal, taxedAmmount, totalFinal
        );

        JOptionPane.showMessageDialog(null, receipt);
        FileWriter saveReceipt = new FileWriter("Receipt.txt");
        saveReceipt.write(receipt);
        saveReceipt.close();

    }    



    // This is to properCase any words needed.
    private String toProperCase(String input) {
        return Character.toUpperCase(input.charAt(0)) + input.substring(1).toLowerCase();
    }
}
