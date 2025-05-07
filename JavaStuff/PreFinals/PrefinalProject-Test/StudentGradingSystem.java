/*
 * 
 * This is a simple Java program that serves as a starting point for a student grading system.
 * 
 */

 import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class StudentGradingSystem {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        ArrayList<Section> allSections = new ArrayList<>();

        // ✅ Reads from folder 'masterDatabase'
        File file = new File("masterDatabase/studentDatabase.txt");
        Scanner scan = new Scanner(file);
        scan.useDelimiter(",");

        String currentSectionName = "";
        ArrayList<Student> currentStudents = new ArrayList<>();

        while (scan.hasNextLine()) {
            String line = scan.nextLine().trim();

            if (line.startsWith("-")) {
                currentSectionName = line.substring(1).trim(); // Remove the "-"
                currentStudents = new ArrayList<>();
                continue;
            }

            if (line.equals("---")) {
                Section newSection = new Section(currentSectionName);
                for (Student s : currentStudents) {
                    newSection.addStudent(s);
                }
                allSections.add(newSection);

                writeSectionToFile(newSection);
                continue;
            }

            Scanner lineScan = new Scanner(line);
            lineScan.useDelimiter(",");

            String surname = lineScan.next().trim();
            String firstname = lineScan.next().trim();
            String studentID = lineScan.next().trim();
            String major = lineScan.next().trim();
            String[] courses = Utility.parseArray(lineScan.next().trim());

            Student newStudent = new Student(surname, firstname, studentID, major, courses);
            currentStudents.add(newStudent);
        }

        scan.close();

    }

    public static void writeSectionToFile(Section section) throws IOException, FileNotFoundException {
        // ✅ Writes to 'allSections/SectionName_Graded.txt'
        FileWriter writer = new FileWriter("allSections/" + section.getSectionName() + "_Graded.txt");
        for (Student s : section.getStudents()) {
            writer.write(s.toString() + "\n");
        }
        writer.close();
    }
}
