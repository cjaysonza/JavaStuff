/*
 * 
 * This is a simple Java program that serves as a starting point for a student grading system.
 * @author: csonza, rmol, vgba
 * 
 */

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class StudentGradingSystem {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        ArrayList<Section> allSections = new ArrayList<>();
        ArrayList<TeachingStaff> allTeachingStaff = new ArrayList<>();

        // There can only be one admin in the system
        Admin currentAdmin = Admin.readAdminFromFile();
        writeAdminToAdminRecords(currentAdmin);

        readTeachingStaffFromFiles(allTeachingStaff);
        readAllSectionsFromFiles(allSections);


        teachingStaffInput(allTeachingStaff, allSections);

       
        

        // // This is the first time the system is run, so we need to seed the database
        // seedSectionsAndStudents(allSections);
        // seedTeachingStaff(allTeachingStaff);
        
        // // This is not the first time the system is run, so we need to read the database
        // readTeachingStaffFromFiles(allTeachingStaff);
        // readAllSectionsFromFiles(allSections);
        


        // Temporary code to test the system
        // while (true) {
        //     System.out.println("Welcome to the Student Grading System!");
        //     System.out.println("1. Seed Sections and Students");
        //     System.out.println("2. Seed Teaching Staff");
        //     System.out.println("3. Read Teaching Staff from Files");
        //     System.out.println("4. Read All Sections from Files");
        //     System.out.println("5. Write Section to File");
        //     System.out.println("6. Write Teaching Staff to File");
        //     System.out.println("7. Print First Student of Every Section");
        //     System.out.println("8. Exit");
        //     Scanner scanner = new Scanner(System.in);
        //     int choice = scanner.nextInt();
        //     switch (choice) {
        //         case 1:
        //             seedSectionsAndStudents(allSections);
        //             break;
        //         case 2:
        //             seedTeachingStaff(allTeachingStaff);
        //             break;
        //         case 3:
        //             readTeachingStaffFromFiles(allTeachingStaff);
        //             break;
        //         case 4:
        //             readAllSectionsFromFiles(allSections);
        //             break;
        //         case 5:
        //             writeSectionToFile(allSections.get(0)); // Example: write the first section
        //             break;
        //         case 6:
        //             writeTeachingStaffToFile(allTeachingStaff);
        //             break;
        //         case 7:
        //             printFirstStudentOfEverySection(allSections);
        //             break;
        //         case 8:
        //             System.exit(0);
        //         default:
        //             System.out.println("Invalid choice. Please try again.");
        //     }
        // }


        
        // Uncomment the following lines to run the program without user input
        // printFirstStudentOfEverySection(allSections);
        
    }

    private static void teachingStaffInput(ArrayList<TeachingStaff> allTeachingStaff, ArrayList<Section> allSections) throws FileNotFoundException, IOException{
        Scanner scanner = new Scanner(System.in);
        TeachingStaff currentStaff = null;

        //login
        while (currentStaff == null) {
            System.out.println("Teaching Staff Login");
            System.out.println("Staff ID: ");
            String staffID = scanner.nextLine().trim();
            System.out.println("Password: ");
            String password = scanner.nextLine().trim();

            currentStaff = null;
            for (TeachingStaff staff : allTeachingStaff) {
                if (staff.getStaffID().equals(staffID) && staff.getPassword().equals(password)) {
                    currentStaff = staff;
                    break;
                }
            }

            if (currentStaff == null) {
                System.out.println("Invalid Staff ID or Password. Please try again.");
                return; // Exit or loop back to retry
            }

        }
        System.out.println("Welcome, " + currentStaff.getFirstname() + " " + currentStaff.getSurname() + "!");

        while (true) {
            System.out.println("\n Teaching Staff Menu");
            System.out.println("1. Grade Students");
            System.out.println("2. Exit");
            System.out.println("Enter choice(1-2): ");

            int choice = scanner.nextInt();

            if(choice < 1 || choice > 2) {
                System.out.println("Invalid choice. Please try again.");
                continue;
            }

            switch (choice) {
                case 1:
                    selectSection(currentStaff, scanner, allSections);
                    break;
                case 2:
                    System.out.println("Logging out...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void selectSection(TeachingStaff staff, Scanner scanner, ArrayList<Section> allSections) throws IOException, FileNotFoundException {
        ArrayList<String> sections = staff.getSectionsHandled();
        if (sections.isEmpty()) {
            System.out.println("No sections handled.");
            return;
        }

        System.out.println("Sections Handled:");
        for (int i = 0; i < sections.size(); i++) {
            System.out.println((i + 1) + ". " + sections.get(i));
        }
        System.out.println("3. Back to Menu");
        System.out.println("Select a section (1-" + sections.size() +"): ");
        System.out.flush();

        if (scanner.hasNextLine()) {
            scanner.nextLine();
        }

        String input = scanner.nextLine().trim();
        int choice;
        if (input.matches("\\d+")) {
            choice = Integer.parseInt(input);
        } else {
            System.out.println("Invalid input. Please enter a number.");
            return;
        }

        if (choice < 1 || choice > sections.size() + 1) {
            System.out.println("Invalid section number. Please select a number between 1 and " + sections.size());
            return;
        }

        if (choice == sections.size() + 1) {
            System.out.println("Going back to menu...");
            return;
        }

        String selectedSection = sections.get(choice - 1);
        System.out.println("Selected section: " + selectedSection);

        for (Section section : allSections) {
            if (section.getSectionName().equals(selectedSection)) {
                System.out.println("Grading students in " + selectedSection + ":\n");
                selectCourse(staff, scanner, section, allSections);
                break;
            }
        }
    }

    private static void selectCourse(TeachingStaff staff, Scanner scanner, Section section, ArrayList<Section> allSections) throws IOException, FileNotFoundException {
        ArrayList<String> courses = staff.getCoursesTaught();
        if (courses.isEmpty()) {
            System.out.println("No courses taught.");
            return;
        }

        System.out.println("Courses Taught:");
        for (int i = 0; i < courses.size(); i++) {
            System.out.println((i + 1) + ". " + courses.get(i));
        }
        System.out.println((courses.size() + 1) + ". Back to Menu");
        System.out.print("Select a course to grade (1-" + (courses.size() + 1) + "): ");

        String input = scanner.nextLine().trim();
        if (!input.matches("\\d+")) {
            System.out.println("Invalid input. Please enter a number.");
            return;
        }
        int choice = Integer.parseInt(input);

        if (choice < 1 || choice > courses.size() + 1) {
            System.out.println("Invalid course number. Please select a number between 1 and " + (courses.size() + 1));
            return;
        }

        if (choice == courses.size() + 1) {
            System.out.println("Going back to menu...");
            return;
        }

        String selectedCourse = courses.get(choice - 1);
        System.out.println("Selected course: " + selectedCourse);

        gradeStudent(staff, section, scanner, selectedCourse, allSections);
    }

    private static void gradeStudent(TeachingStaff staff, Section section, Scanner scanner, String selectedCourse, ArrayList<Section> allSections) 
            throws IOException, FileNotFoundException {
        ArrayList<Student> students = section.getStudents();

        if (students.isEmpty()) {
            System.out.println("No students in this section.");
            return;
        }
        System.out.println("Students in " + section.getSectionName() + ":");
        for (int i = 0; i < students.size(); i++) {
            Student student = students.get(i);
            System.out.println((i + 1) + ". " + student.getFirstname() + " " + student.getSurname());
        }
        System.out.println((students.size() + 1) + ". Back to Menu");
        System.out.print("Enter student name (Firstname Surname) or select number (1-" + (students.size() + 1) + "): ");

        String input = scanner.nextLine().trim();
        Student selectedStudent = null;

        String[] nameParts = input.trim().split("\\s+");

        if (input.matches("\\d+")) {
            int choice = Integer.parseInt(input);
            if (choice == students.size() + 1) return;
            if (choice < 1 || choice > students.size()) {
                System.out.println("Invalid number. Please select a number between 1 and " + (students.size() + 1));
                return;
            }
            selectedStudent = students.get(choice - 1);
        } else if (nameParts.length >= 2) {
            String firstname = nameParts[0];
            String surname = nameParts[nameParts.length - 1];
            for (Student stud : students) {
                if (stud.getFirstname().equalsIgnoreCase(firstname) && stud.getSurname().equalsIgnoreCase(surname)) {
                    selectedStudent = stud;
                    break;
                }
            }
            if (selectedStudent == null) {
                System.out.println("Student not found.");
                return;
            }
        } else {
            System.out.println("Please enter a number or both first and last name.");
            return;
        }

        System.out.println("Student courses: " + Arrays.toString(selectedStudent.getCourses()));   // just to check if the student is enrolled in the course

        String[] studentCourses = selectedStudent.getCourses();
        int courseIndex = -1;
        String courseSelected = selectedCourse.trim().replaceAll("\\s+", " ").toLowerCase();   
        for (int i = 0; i < studentCourses.length; i++) {
            String studentCourse = studentCourses[i].trim().replaceAll("\\s+", " ").toLowerCase();
            if (studentCourse.equals(courseSelected)) {
                courseIndex = i;
                break;
            }
        }

        if (courseIndex == -1) {
            System.out.println("Student is not enrolled in " + selectedCourse + ".");
            return;
        }

        // Input grade
        System.out.print("Enter numerical grade for " + selectedStudent.getFirstname() + " " + selectedStudent.getSurname() + " in " + selectedCourse + " (0-100): ");
        String gradeInput = scanner.nextLine().trim();
        if (!gradeInput.matches("\\d+(\\.\\d+)?")) {
            System.out.println("Invalid grade format. Please enter a number (e.g., 85 or 85.5).");
            return;
        }
        double grade = Double.parseDouble(gradeInput);
        if (grade < 0 || grade > 100) {
            System.out.println("Grade must be between 0 and 100.");
            return;
        }

        // Convert numerical grade to letter grade
        String letterGrade = convertToLetterGrade(grade);

        // Update student's grades
        double[] numGrades = selectedStudent.getNumGrades();
        String[] letterGrades = selectedStudent.getLetterGrades();
        numGrades[courseIndex] = grade;
        letterGrades[courseIndex] = letterGrade;
        selectedStudent.setNumGrades(numGrades);
        selectedStudent.setLetterGrades(letterGrades);

        System.out.println("Student: " + selectedStudent.getFirstname() + " " + selectedStudent.getSurname());
        System.out.println("numGrades: " + Arrays.toString(selectedStudent.getNumGrades()));

        // Save the updated section to file
        writeSectionToFile(section);
        System.out.println("After saving:" + section.getSectionName());

        System.out.println("Grade assigned: " + letterGrade + " (" + grade + ") for " + selectedStudent.getFirstname() + " " + selectedStudent.getSurname() + " in " + selectedCourse);
    }

    private static String convertToLetterGrade(double grade) {
        if (grade >= 92) return "A";
        if (grade >= 88) return "B+";
        if (grade >= 84) return "B";
        if (grade >= 80) return "C+";   //I forgot the equivalent of the letter grades
        if (grade >= 76) return "C";
        if (grade >= 72) return "D";
        else return "F";
    }

    private static void writeAdminToAdminRecords(Admin currentAdmin) throws IOException {
        FileWriter adminWriter = new FileWriter("adminRecords/" + currentAdmin.getAdminFileName());
            adminWriter.write("Name: " + currentAdmin.getFirstname() + " " + currentAdmin.getSurname() + "\n");
            adminWriter.write("Admin ID: " + currentAdmin.getAdminID() + "\n");
            adminWriter.write("Password: " + currentAdmin.getPassword() + "\n");
            adminWriter.write("Department: Adminstritative - Program Management\n");
            adminWriter.write("Records and Actions: \n");
        adminWriter.close();
    }

    private static void printFirstStudentOfEverySection(ArrayList<Section> allSections) {
        for (Section section : allSections) {
            Student student = section.getStudents().get(3);

            System.out.println(section.getSectionName());
            System.out.println(student.getSurname() + " " + student.getFirstname() + "\n" + student.getStudentID() + "\n" + student.getMajor()
                    + "\n" + Arrays.toString(student.getCourses()) + "\n" + Arrays.toString(student.getLetterGrades())
                    + "\n" + Arrays.toString(student.getNumGrades()));

            System.out.println("--------------------------------------------------\n\n\n");
        }
    }

    private static void readTeachingStaffFromFiles(ArrayList<TeachingStaff> allTeachingStaff)
            throws FileNotFoundException {
        File allTeachingStaffFile = new File("allTeachingStaff/all-teaching-staff.txt");
        if (!allTeachingStaffFile.exists()) {
            System.out.println("all-teaching-staff.txt file not found.");
            return;
        }
        Scanner allTeachingStaffScanner = new Scanner(allTeachingStaffFile);
        while (allTeachingStaffScanner.hasNextLine()) {
            String line = allTeachingStaffScanner.nextLine();
            TeachingStaff staff = TeachingStaff.fromString(line);
            if (staff == null) {
                break; // End of the file
            }
            allTeachingStaff.add(staff);

            if (staff.getStaffID().equals("000001")) {
                continue; // Skip the admin staff
            }
            System.out.println(staff + "\n");
        }
    }

    private static void seedTeachingStaff(ArrayList<TeachingStaff> allTeachingStaff)
            throws FileNotFoundException, IOException {
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

            Scanner lineScanner = new Scanner(line);
            lineScanner.useDelimiter(",");

            if (line.equals("---")) {
                break; // End of the file
            }

            String surname = lineScanner.next().trim();
            String firstname = lineScanner.next().trim();
            String staffID = lineScanner.next().trim();
            String password = lineScanner.next().trim();
            String department = lineScanner.next().trim();
            String sectionsStr = lineScanner.next().trim();
            String coursesStr = lineScanner.next().trim();
            String teachingRecord = lineScanner.hasNext() ? lineScanner.next().trim() : "-";

            // NOTE: the following lines is different from Utility.praseArray()
            sectionsStr = sectionsStr.replaceAll("\\[|\\]", "");
            coursesStr = coursesStr.replaceAll("\\[|\\]", "");

            ArrayList<String> sectionsHandled = new ArrayList<>(Arrays.asList(sectionsStr.split(";")));
            ArrayList<String> coursesTaught = new ArrayList<>(Arrays.asList(coursesStr.split(";")));

            TeachingStaff newStaff = new TeachingStaff(surname, firstname, staffID, password, department,
                    sectionsHandled, coursesTaught, teachingRecord);

            allTeachingStaff.add(newStaff);

            // Create a custom filename per teaching staff
            String filename = newStaff.getSurname().replace(" ", "") + "-" + newStaff.getStaffID();
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

        // System.out.println("All Teaching Staff:");
        // for (TeachingStaff teachingStaff : allTeachingStaff) {
        // if (teachingStaff.getSurname().equals("admin")) {
        // continue;
        // }
        // System.out.println(teachingStaff);
        // }

        // Prints all teachers into a single file
        writeTeachingStaffToFile(allTeachingStaff);
    }

    private static void seedSectionsAndStudents(ArrayList<Section> allSections)
            throws FileNotFoundException, IOException {
        ArrayList<Student> currentStudents = new ArrayList<>();
        Scanner scan = new Scanner(new FileReader("masterDatabase/studentDatabase.txt"));
        scan.useDelimiter(",");
        String currentSectionName = "";

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
                System.out.println(newSection + "\n\n\n");

                writeSectionToFile(newSection);
                continue;
            }

            currentStudents.add(Student.fromString(line));
        }

        scan.close();

        // create an all-sections.txt file
        File allSectionsFile = new File("allSections/all-sections.txt");
        if (!allSectionsFile.exists()) {
            allSectionsFile.createNewFile();
        }
        FileWriter allSectionsWriter = new FileWriter(allSectionsFile);
        for (Section section : allSections) {
            String line = section.getSectionName() + "\n";
            allSectionsWriter.write(line);
        }
        allSectionsWriter.close();

        // Print all sections and students
        // System.out.println("All Sections and Students:");
        // for (Section section : allSections) {
        // System.out.println(section);
        // }
    }

    private static void readAllSectionsFromFiles(ArrayList<Section> allSections)
            throws IOException, FileNotFoundException {
        File allSectionsFile = new File("allSections/all-sections.txt");
        if (!allSectionsFile.exists()) {
            System.out.println("all-sections.txt file not found.");
            return;
        }
        Scanner allSectionsScanner = new Scanner(allSectionsFile);
        while (allSectionsScanner.hasNextLine()) {
            String line = allSectionsScanner.nextLine().trim();
            Section section = new Section(line);
            section.loadFromFile();
            allSections.add(section);
        }

        // print out all sections and students
        System.out.println("All Sections and Students:");

    }

    public static void writeSectionToFile(Section section) throws IOException, FileNotFoundException {
        // ✅ Writes to 'allSections/SectionName_Graded.txt'
        String fileName = "allSections/" + section.getSectionName() + "_Data.txt";
        // create a filewriter that truncates the file if it exists
        FileWriter writer = new FileWriter(fileName);
        for (Student s : section.getStudents()) {
            writer.write(s.toString() + "\n");
        }
        writer.close();
    }

    // ✅ Writes to 'allTeachingStaff/all-teaching-staff.txt'
    public static void writeTeachingStaffToFile(ArrayList<TeachingStaff> staffList) throws IOException {
        FileWriter writer = new FileWriter("allTeachingStaff/all-teaching-staff.txt");
        for (TeachingStaff staff : staffList) {
            String line = staff.getSurname() + "," +
                    staff.getFirstname() + "," +
                    staff.getStaffID() + "," +
                    staff.getPassword() + "," +
                    staff.getDepartment() + "," +
                    "[" + String.join(";", staff.getSectionsHandled()) + "]," +
                    "[" + String.join(";", staff.getCoursesTaught()) + "]," +
                    staff.getTeachingRecord();
            writer.write(line + "\n");
        }

        writer.write("---\n");
        writer.close();
    }

}

// TODO Functionality:
/*
 * 1.
 * 
 * 
 */