import javax.swing.JOptionPane;

public class SonzaMar6Calculator {
    public static void main(String[] args) {
        boolean running = true;
        
        while (running) {
            String programStart = JOptionPane.showInputDialog(
                "What would you like to do?\n" +
                "1. Use Calculator\n" + 
                "2. Introduce Yourself\n" +
                "3. Exit Program\n"
                );

            switch (programStart.toUpperCase().charAt(0)) {
                case '1':
                    useCalculator();
                break;

                case '2':
                    IntroduceYourself();
                break;

                case '3':
                JOptionPane.showMessageDialog(null, "Exiting Program");
                running = false;
                break;
            }
        }
    }
    // Use Calculator
    private static void useCalculator() {
        String option = JOptionPane.showInputDialog(
            "What operation would you like to use?\n" +
            "+ Addition\n" +
            "- Subtraction\n" +
            "* Multiplication\n" +
            "/ Division\n"
            ).toUpperCase();

            char operation = option.charAt(0); 

            switch (operation) {
                case '+':
                    getInputs(operation);
                break;
                case '-':
                    getInputs(operation);
                break;
                
                case '*':
                    getInputs(operation);
                break;
                
                case '/':
                    getInputs(operation);
                break;

                default:
                    JOptionPane.showMessageDialog(null, "Invalid Operation");
                break;
            }
    }

    private static void getInputs(char operation) {
        String input1 = JOptionPane.showInputDialog("Input first variable\nCan be INT or DOUBLE");
        String input2 = JOptionPane.showInputDialog("Input Second variable\nCan be INT or DOUBLE");

        if (input1.contains(".") || input2.contains(".")) {
            double num1 = Double.parseDouble(input1);
            JOptionPane.showMessageDialog(null, doMath(operation, Double.parseDouble(input1), Double.parseDouble(input2)));
        } else {
            JOptionPane.showMessageDialog(null, doMath(operation, Integer.parseInt(input1), Integer.parseInt(input2)));
        }
    } 
    
    private static double doMath(char operation, double num1, double num2) {
        // String operrand = operation;
        double result = 0.0d;
        switch (operation) {
            case '+':
                result = (num1 + num2);
            break;
            case '-':
                result = (num1 - num2);
            break;
            case '*':
                result = (num1 * num2);
            break;
            case '/':
                if (num1 == 0.0d || num2 == 0.0d) {
                    result = 0.0d;
                } else {
                    result = (num1 / num2);
                }
            break;
            default:
                JOptionPane.showMessageDialog(null, "Error. Misinput Somewhere");
                return result;
            // break;
        }
        return result;
    }

    private static int doMath(char operation, int num1, int num2) {
        int result = 0;
        switch (operation) {
            case '+':
                result = (num1 + num2);
            break;
            case '-':
                result = (num1 - num2);
            break;
            case '*':
                result = (num1 * num2);
            break;
            case '/':
                if (num1 == 0 || num2 == 0) {
                    result = 0;
                } else {
                    result = (num1 / num2);
                }
            break;
            default:
                JOptionPane.showMessageDialog(null, "Error. Misinput Somewhere");
                return result;
            // break;
        }
        return result;
    }
    
    
    // Introduce yourself
    private static void IntroduceYourself() {
        
        String name = JOptionPane.showInputDialog("Enter your Name: ");
        String age = JOptionPane.showInputDialog("Enter your Age: ");
        String course = JOptionPane.showInputDialog("Enter your Course: ");
        
        
        String option = JOptionPane.showInputDialog(
            "What would you like to do\n" +
            "1. Name only\n" +
            "2. Name and Age\n" +
            "3. Name, Age, and Course\n"
            ).toUpperCase();

            char operation = option.charAt(0); 

            switch (operation) {
                case '1':
                    JOptionPane.showMessageDialog(null, intro(name));
                break;

                case '2':
                    JOptionPane.showMessageDialog(null, intro(name, age));
                break;
                
                case '3':
                    JOptionPane.showMessageDialog(null, intro(name, age, course));
                break;
                
                default:
                    JOptionPane.showMessageDialog(null, "Invalid input was entered");;
                break;
            }
    }


    private static String intro(String name) {
         return "Hello, I am " + name;
    }

    private static String intro(String name, String age) {
        return "Hello, I am " + name + ", and I am currently " + age + "-years old";
    }

   private static String intro(String name, String age, String course) {
        return "Hello, I am " + name + ", and I am currently " + age + "-years old.\n" +
                "My current course is: " + course;
    }

}
