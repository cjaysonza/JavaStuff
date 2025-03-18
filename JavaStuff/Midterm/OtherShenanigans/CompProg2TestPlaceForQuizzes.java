public class CompProg2TestPlaceForQuizzes {
    public static void main(String[] args) {
        String name, course;
        int age;

        name = "Mark";
        course = "Accountancy";
        age = 21;

        // System.out.println(method(name, course, age));


        // System.out.print(Math.round(Math.pow(64, 1.0/3)));

        method(15/1+3);
        // System.out.println((int) 1.0/4.0);
        // System.out.println(Math.pow(16, (int) 1.0/4.0));
        // System.out.println(Math.round(Math.pow(16, (int) 1.0/4.0)));

        System.out.println(method(name, 22, course));
        

    }

    public static void method(int x) {
        System.out.println(x % 2 == 0 ? "Hidden " : "Revealed");
    }

    public static void method(double x) {
        System.out.println(x % 2 != 0 ? "revealed" : "hidden");
    }

    // public static String method(String name) {
    //     return "Hello " + name;
    // }

    // public static String method(String name, int age) {
    //     return "Hello " + name + " I am " + age + "-years old.";
    // }
    
    public static String method(String name, int age, String course) {
        return "Hello " + name + " I am " + age + "-years old. My course is " + course;
    }
}
