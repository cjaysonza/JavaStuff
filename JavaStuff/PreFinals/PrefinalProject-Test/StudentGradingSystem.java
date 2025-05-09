/*
 * 
 * This is a simple Java program that serves as a starting point for a student grading system.
 * @author: csonza, rmol, vgba
 * 
 * @Version-Update: 0.1
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

        // This is not the first time the system is run, so we need to read the database
        readAllSectionsFromFiles(allSections);
        readTeachingStaffFromFiles(allTeachingStaff);
        
        String schoolName = "Ateneo de Malayan International State Colleges of the Philippines";
        // AdMISCotP
        
        // Read the current academic year from a file. default: 2024
        int currentAcademicYear = getCurrentAcademicYear(); 
        
        
        boolean isRunning = true;
        while (isRunning) { 

            String usertypeLoggedIn = "";

            System.out.println("\n\n\n"); // For formatting purposes when running the program. So that there is space between the console and the menu.
            String userInput = Displays.displayStartMenu(schoolName, currentAcademicYear);
            switch (userInput) {
                case "1":
                    // Login as Teaching Staff
                    usertypeLoggedIn = Displays.displayLoginMenu(currentAdmin, allTeachingStaff); 
                    break;
                case "2":
                    // Exit the program
                    System.out.println("\nExiting the program...");
                    isRunning = false;
                    break;
                default:
                    System.out.println("\nInvalid input. Please try again.");
            }

            switch (usertypeLoggedIn) {
                case "admin":
                    // Admin menu
                    System.out.println("\n\n\n"); // For formatting purposes when running the program. So that there is space between the console and the menu.
                    System.out.println("Welcome, " + currentAdmin.getFirstname() + ", " + currentAdmin.getSurname() + "!");
                    System.out.println("You are logged in as an Administrator.");
                    break;
                case "teachingStaff":
                    // Teaching Staff menu
                    System.out.println("\n\n\n"); // For formatting purposes when running the program. So that there is space between the console and the menu.
                    System.out.println("Welcome, Teaching Staff!");
                    break;
                default:
                    System.out.println("\nInvalid input. Please try again.");
            }
        }   

        // // This is the first time the system is run, so we need to seed the database
        // seedSectionsAndStudents(allSections);
        // seedTeachingStaff(allTeachingStaff);
        
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

    // Current academic year is read from a file
    private static int getCurrentAcademicYear() throws FileNotFoundException {
        File file = new File("masterDatabase/currentAcademicYearData.txt");
        Scanner line = new Scanner(file);
        while (line.hasNextLine()) {
            String lineData = line.nextLine().trim();
            if (lineData.equals("---") || lineData.equals("")) {
                break; // End of the file
            }
            return Integer.parseInt(lineData);
        } 
        line.close();
        // If the file is empty or not found, return a default value
        return 2024;
    }

    // Read the admin's data from a file in the adminRecords directory
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
    
    // Read the teaching staff's data from a file in the allTeachingStaff directory
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
            // System.out.println(staff + "\n");
        }
    }
    
    // Seed the teaching staff's data from a file in the masterDatabase directory
    // This is the first time the system is run, so we need to seed the database
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

    // Seed the sections and students' data from a file in the masterDatabase directory
    // This is the first time the system is run, so we need to seed the database
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
        
    // Read the sections and students' data from a file in the allSections directory
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
    
    // Write the section and students' data to a file in the allSections directory
    // This is the first time the system is run, so we need to seed the database
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

    // Write the admin's data to a file in the adminRecords directory
    // This is the first time the system is run, so we need to seed the database
    private static void writeAdminToAdminRecords(Admin currentAdmin) throws IOException {
        FileWriter adminWriter = new FileWriter("adminRecords/" + currentAdmin.getAdminFileName());
            adminWriter.write("Name: " + currentAdmin.getFirstname() + " " + currentAdmin.getSurname() + "\n");
            adminWriter.write("Admin ID: " + currentAdmin.getAdminID() + "\n");
            adminWriter.write("Password: " + currentAdmin.getPassword() + "\n");
            adminWriter.write("Department: Adminstritative - Program Management\n");
            adminWriter.write("Records and Actions: \n");
        adminWriter.close();
    }
    
}

// TODO Functionality:
/*
 * 1.
 * 
 * 
 */