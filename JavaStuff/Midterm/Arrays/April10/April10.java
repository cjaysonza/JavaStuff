

public class April10 {
    public static void main(String[] args) {
        Animal[] animals = new Animal[2];

        // for (int i = 0; i < animals.length; i++) {
        //     animals[i] = new Animal();
        //     animals[i].setName(JOptionPane.showInputDialog("Animal " + i + " Name: "));
        //     animals[i].setSpecies(JOptionPane.showInputDialog("Animal " + i + " Species: "));
        //     animals[i].setKingdom(JOptionPane.showInputDialog("Animal " + i + " Kingdom: "));
        // }

        // for (Animal an : animals) {
        //     JOptionPane.showMessageDialog(null, an.introduction());
        // }


        // 2D Array Shenanigans
        // int[][] price = new int[4][2];
        
        // C++ way
        // int[][] price = new int[3][3];
        // for (int x = 0; x < price.length; x++) {
        //     for (int y = 0; y < price[x].length; y++) {
        //         System.out.print(price[x][y] + " ");
        //     }
        //     System.out.println();
        // }

        // JAVA way
        int[][] price = new int[3][3];
        for (int[] price1 : price) {
            for (int y = 0; y < price1.length; y++) {
                System.out.print(price1[y] + " ");
            }
            System.out.println();
        }

    }    
}
