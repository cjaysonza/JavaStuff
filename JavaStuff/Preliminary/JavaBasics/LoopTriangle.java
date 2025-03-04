public class LoopTriangle {
    public static void main(String[] args) {
        final int MAX_ROWS = 5;
        String star = "x ";
        System.out.println("Create the Triangle thingy");

        for (int i = 0; i < MAX_ROWS; i++) {
            System.out.println(star);
            star += "x ";
        }
    }
}
