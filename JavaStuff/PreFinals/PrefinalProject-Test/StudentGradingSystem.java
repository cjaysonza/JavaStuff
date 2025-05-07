/*
 * 
 * This is a simple Java program that serves as a starting point for a student grading system.
 * 
 */

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class StudentGradingSystem {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        ArrayList<Section> allSections = new ArrayList<>();


        //---------------------------------------MAKING OF STUDENTS--------------------------------------------------------
        // ✅ Reads from folder 'masterDatabase'
        // File file = new File("masterDatabase/studentDatabase.txt");
        Scanner scan = new Scanner(new FileReader("masterDatabase/studentDatabase.txt"));
        scan.useDelimiter(",");

        String currentSectionName = "";

        ArrayList<Student> currentStudents = new ArrayList<>();

        // Make the Sections and Students
        while (scan.hasNextLine()) {
            String line = scan.nextLine().trim();

            if (line.startsWith(">")) {
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
        
        
        // Print all sections and students
        System.out.println("All Sections and Students:");
        for (Section section : allSections) {
            System.out.println(section);
        }

        //---------------------------------------MAKING OF TEACHING STAFF--------------------------------------------------------

        //Creates the Teaching Staff
        ArrayList<TeachingStaff> allTeachingStaff = new ArrayList<>();

        File staffFile = new File("masterDatabase/teachingStaffDatabase.txt");
        Scanner staffScanner = new Scanner(staffFile);
        staffScanner.useDelimiter(",");

        // Ensure the directory exists
        File staffDir = new File("allTeachingStaff");
        if (!staffDir.exists()) {
            staffDir.mkdir();
        }

        while (staffScanner.hasNextLine()) {
            String line = staffScanner.nextLine().trim();
            if (line.equals("---")) {
                break;
            }

            Scanner lineScanner = new Scanner(line);
            lineScanner.useDelimiter(",");

            String surname = lineScanner.next().trim();
            String firstname = lineScanner.next().trim();
            String staffID = lineScanner.next().trim();
            String password = lineScanner.next().trim();
            String department = lineScanner.next().trim();
            String sectionsStr = lineScanner.next().trim();
            String coursesStr = lineScanner.next().trim();
            String teachingRecord = lineScanner.hasNext() ? lineScanner.next().trim() : "-";

            sectionsStr = sectionsStr.replaceAll("\\[|\\]", "");
            coursesStr = coursesStr.replaceAll("\\[|\\]", "");

            ArrayList<String> sectionsHandled = new ArrayList<>(Arrays.asList(sectionsStr.split(";")));
            ArrayList<String> coursesTaught = new ArrayList<>(Arrays.asList(coursesStr.split(";")));

            TeachingStaff newStaff = new TeachingStaff(surname, firstname, staffID, password, department, sectionsHandled, coursesTaught, teachingRecord);

            allTeachingStaff.add(newStaff);

            // Create a custom filename
            String filename = newStaff.getSurname().replace(" ", "") + newStaff.getStaffID();
            FileWriter staffWriter = new FileWriter("allTeachingStaff/" + filename + ".txt");

            // Write the staff's personal data
            staffWriter.write("Name: " + firstname + " " + surname + "\n");
            staffWriter.write("Staff ID: " + staffID + "\n");
            staffWriter.write("Department: " + department + "\n");
            staffWriter.write("Sections Handled: " + sectionsStr + "\n");
            staffWriter.write("Courses Taught: " + coursesStr + "\n");
            staffWriter.write("Teaching Record: " + teachingRecord + "\n");

            staffWriter.close();
            lineScanner.close();
        }

        staffScanner.close();

        System.out.println("All Teaching Staff:");
        for (TeachingStaff teachingStaff : allTeachingStaff) {
            System.out.println(teachingStaff);
        }

    }

    public static void writeSectionToFile(Section section) throws IOException, FileNotFoundException {
        // ✅ Writes to 'allSections/SectionName_Graded.txt'
        String fileName = "allSections/" + section.getSectionName() + "_Graded.txt";
        FileWriter writer = new FileWriter(fileName);
        for (Student s : section.getStudents()) {
            writer.write(s.toString() + "\n");
        }
        writer.close();
    }
}
