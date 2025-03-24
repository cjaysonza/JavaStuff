public class MainTest {
    public static void main(String[] args) {
        Pet myPet = new Pet();
        myPet.animalSound();
        myPet.sleeping();

        myPet.setName("Zozimo");
        System.out.println(myPet.getName());
    }
}
