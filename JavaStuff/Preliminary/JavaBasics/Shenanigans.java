public class Shenanigans {
    public static void main (String[] args) {
        String sentence = "Name of Sub.\t\tGrade\tGradeValue\tRunSum\n";
        String subName1 = "Science";
        char sub1Grade = 'A';
        int sub1GradeValue = 4;
        int runsum = 0;

        sentence += subName1;
        sentence += "\t\t\t";
        sentence += sub1Grade;
        sentence += "\t";
        sentence += sub1GradeValue;
        sentence += "\t\t";
        sentence += runsum;
        sentence += "\n";
        
        System.out.println(sentence);
    }     
}
