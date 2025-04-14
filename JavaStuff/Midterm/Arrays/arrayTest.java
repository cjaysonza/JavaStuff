public class arrayTest {
    public static void main(String args[]) {

        // April 10, 2025: Arrays

        
        // int[] list = {1, 2, 3, 4, 5};
        // for (int i = 0; i < list.length; i++) {
        //     System.out.print(list[i] + " ");
        // }
        // To print out an Array


        int[] _storage;
        _storage = new int[3];

        _storage[2] = 5;
        System.out.println(_storage[1] + _storage[2]);

        String[] names = {"John", "Mark", "Apple", "Luke", "Brendan", "May"};
        for (int i = 0; i < names.length; i++) {
            System.out.println(names[i]);
        } System.out.println(); // Just to add spacing after loop finishes


        String[] othernames = {"Allan", "Brody", "Caitlyn", "Drake", "Edwin"};
        for (String name : othernames) {
            System.out.println(name);
        }


        // int[] list = {1, 2, 3, 4, 5};
        // for (int i = 0; i < list.length; i++) {
        //     System.out.print(list[i] + " ");
        // }
        // System.out.println();

        // for (int i = 0; i < list.length; i++) {
        //     System.out.print((list[i] * list[i]) + " ");
        // }

    }
}