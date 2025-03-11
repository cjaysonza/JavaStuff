public class CompProg2TestPlaceForQuizzes {
    public static void main(String[] args) {
        String name, course;
        int age;

        name = "Mark";
        course = "Accountancy";
        age = 21;

        // System.out.println(method(name, course, age));
    }

    public static String method(String name) {
        return "Hello " + name;
    }

    public static String method(String name, int age) {
        return "Hello " + name + "I am " + age + "-years old.";
    }
    
    public static String method(String name, int age, String course) {
        return "Hello " + name + "I am " + age + "-years old. My course is " + course;
    }
}
