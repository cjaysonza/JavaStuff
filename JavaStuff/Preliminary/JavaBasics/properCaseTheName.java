public class properCaseTheName {
    public static void main  (String[] args) {
        // String name = "aLEJANDRo leONARdo";
        // String pname = name.substring(0, 1).toUpperCase().concat(name.substring(1, 9).toLowerCase()) 
        // + " ".concat(name.substring(10, 11).toUpperCase().concat(name.substring(11).toLowerCase()));
        // System.out.println(pname);

        String name1 = "cHRISTIan jAy sONZa";
        String name1Proper = name1.substring(0, 1).toUpperCase() + (name1.substring(1, 10).toLowerCase())
        + (name1.substring(10, 11).toUpperCase() + (name1.substring(11, 14).toLowerCase())
        + (name1.substring(14,15).toUpperCase() + (name1.substring(15).toLowerCase())));
        System.out.println(name1Proper);

    }
}
