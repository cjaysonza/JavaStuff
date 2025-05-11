public class ZTestingMethods {
    public static void main(String[] args) {
        double num1 = 344.0000002d;
        System.out.println(Utility.clampGrade(num1));
        double num2 = -1.0d;
        System.out.println(Utility.clampGrade(num2));
        
    }
}
