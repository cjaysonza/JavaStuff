import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Section {
    public String sectionName;
    public ArrayList<Student> students;

    public Section() {
        students = new ArrayList<>();
    }

    public Section(String sectionName) {
        this.sectionName = sectionName;
        this.students = new ArrayList<>();
    }

    public void loadFromFile() throws FileNotFoundException, IOException {
        // parse the data under allSections/sectionName.txt
        // and add the students to this section
        String fileName = "allSections/" + sectionName + "_Data.txt";
        File checkFile = new File(fileName);
        if(!checkFile.exists()) {
            System.out.println("File not found: " + sectionName + "_Data.txt");
            return;
        }
        FileReader fileReader = new FileReader(checkFile);
        Scanner scan = new Scanner(fileReader);
        while (scan.hasNextLine()) {
            String line = scan.nextLine();
            students.add(Student.fromString(line));
        }
        scan.close();
    }

    public String getSectionName() {
        return sectionName;
    }

    public void setSectionName(String sectionName) {
        this.sectionName = sectionName;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void addStudent(Student s) {
        students.add(s);
    }

    @Override
    public String toString() {
        String output = sectionName + "\n";
        for (int i = 0; i < students.size(); i++) {
            Student student = students.get(i);
            output += String.format("%d. %s, %s: %s\n", i, student.surname, student.firstname, student.getStudentID());
        }
        return output;
    }

}