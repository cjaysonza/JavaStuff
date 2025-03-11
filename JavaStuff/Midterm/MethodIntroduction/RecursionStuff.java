public class RecursionStuff {
    public static void main(String[] args) {
        String name = "jOHn leSTer mARKus jONathaN";
        int num1 = 5;
        int sumFac = 0;
        int numFac;

        System.out.println(toProperCase(name));

        System.out.println(factorial(num1));

        // for (int x = 1; x <= num1; x++) {
            
        //     sumFac += * (num1 - 1);
        //     num1 = (num1-1);
        // }
    }

    /// To Proper-Case a word
    public static String toProperCase(String name) {
        if (name.contains(" ")) {
            return toProperCase(name.substring(0, name.indexOf(" "))) + 
            " " + 
            toProperCase(name.substring(name.indexOf(" ") + 1));
        } else {
            return name.substring(0, 1).toUpperCase().concat(name.substring(1).toLowerCase());
        }
    }
    /// Factorial Method
    public static int factorial(int x) {
        if (x == 1) {
            return 1;
        } else {
            return x * factorial(x - 1);
        }
    }

}
