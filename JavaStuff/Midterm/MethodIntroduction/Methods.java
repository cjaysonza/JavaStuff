

public class Methods {
    
    public static int larger(int x, int y) {
        return x >= y ? x : y; 
        // int ans = 0;
        // if (x > y){
        //     ans = x;
        // } else {
        //     ans = y;
        // }
        // return ans;
    }
    
    public static String menu(int x) {
        return String.format("Menu\n%d%% %s", x, "Is the item discount");
    }

    public static double larger(double x, double y) {
        return x >= y ? x : y; 
    }

    public static void changeString(String word) {
        word = "changed";
    }

    public static void main(String[] args) {
        int firstNum = 5;
        int secondNum = 7;
        double firstDouble = 14.0;
        String value = "Former";

        
        System.out.println(larger(firstNum, secondNum));

        System.out.println(menu(larger(firstNum, secondNum)));
        System.out.println(larger(firstDouble, secondNum));
        
        System.out.println(value);
        changeString(value);

    }
}
