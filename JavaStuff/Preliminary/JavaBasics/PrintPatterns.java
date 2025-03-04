public class PrintPatterns {
    public static void printPattern1(int n) {
        int i, j;

        // outer loop to handle rows
        for (i = 1; i <= n; i++) {

            // inner loop to handle columns
            for (j = 1; j <= i; j++) {
                System.out.print("*");
            }

            // printing new line for each row
            System.out.println();
        }
    }

    public static void printPattern2(int n) {
        int i, j;

        for (i = n; i >= 1; i--) {

            // inner loop to handle columns
            for (j = 1; j <= i; j++) {
                System.out.print("*");
            }

            // printing new line for each row
            System.out.println();
        }
    }

    // Driver Function
    public static void main(String args[]) {
        int n1 = 6;
        int n2 = 5;
        printPattern1(n1);
        printPattern2(n2);
    }
}
