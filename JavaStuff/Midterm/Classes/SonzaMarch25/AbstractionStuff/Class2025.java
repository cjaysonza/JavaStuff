public class Class2025 {
    public static void main(String[] args) {
        Person pers1 = new Student();
        System.out.println(Person.personCounter);
        showIntro(pers1);
        
        Person pers2 = new Staff();
        System.out.println(Person.personCounter);
        showIntro(pers2);

        Alumni pers3 = new Alumni();
        System.out.println(Person.personCounter);
        showIntro(pers3);

        



        // System.out.println();
    }

    public static void showIntro(Person person){
        System.out.println(person.intro());
    }
}