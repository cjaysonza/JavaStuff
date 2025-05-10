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
        // AdMISCotP, Temporary name for the school
        
        // Read the current academic year from a file. default: 2024
        int currentAcademicYear = getCurrentAcademicYear();
    
        // Read the current semester from a file. default: 1
        int currentSemester = getCurrentSemester();

        // System.out.println("" + allSections);
        // clearSection(allSections);
        // System.out.println( ""+ allSections);
        
        // Uncomment the following lines to run the program without user input
        // for (TeachingStaff staff : allTeachingStaff) {
        //     System.out.println(staff.getSurname() + " " + staff.getFirstname() + "\n" + staff.getStaffID() + "\n" + staff.getDepartment()
        //     + "\n" + Arrays.toString(staff.getSectionsHandled().toArray()) + "\n" + Arrays.toString(staff.getCoursesTaught().toArray())
        //     + "\n" + staff.getTeachingRecord());
            
        //     System.out.println("--------------------------------------------------\n\n\n");
        // }
        
        System.out.println(allSections + "\n\n\n");
        clearCurrentSections(allSections);
        System.out.println(allSections + "\n\n\n");
        seedSectionsAndStudents(allSections);
        System.out.println(allSections + "\n\n\n");


     
        boolean isRunning = true;
        while (isRunning) { 

            // Remnant code of mk.1 v0.1
            // Displays.LoginMenuResult loginResult = null;

            System.out.println("\n\n\n"); // For formatting purposes when running the program. So that there is space between the console and the menu.
            String userInput = Displays.displayStartMenu(schoolName, currentAcademicYear, currentSemester);

            boolean isAdminLoggedIn = false;
            boolean isTeachingStaffLoggedIn = false;

            // START MENU
            switch (userInput) {
                case "1":
                    // Administrator login
                    // loginResult = Displays.displayLoginMenu(currentAdmin, allTeachingStaff); 
                    isAdminLoggedIn = Displays.displayLoginMenuAdmin(currentAdmin);

                    break;
                case "2":
                    // Login as Teaching Staff
                    // loginResult = Displays.displayLoginMenu(currentAdmin, allTeachingStaff); 
                    break;
                case "3":
                    // Exit the program
                    System.out.println("\nExiting the program...");
                    isRunning = false;
                    break;
                default:
                    System.out.println("\nInvalid input. Please try again.");
            }
        }

        //     // Remnant code of mk.1 v0.1
        //     // switch (loginResult.result) {
        //     //     case ADMIN:
        //     //         // Admin login
        //     //         // System.out.println("\nWelcome, " + currentAdmin.getFirstname() + " " + currentAdmin.getSurname() + "!");
        //     //         // TODO Make the admin menu in Display.java
        //     //         break;
        //     //     case TEACHING_STAFF:
        //     //         // Teaching staff login
        //     //         Displays.displayTeachingStaffMenu(loginResult.teachingStaff);
        //     //         break;
        //     //     case PREV:
        //     //         // Go back to the start menu
        //     //         break;
        //     //     case INVALID:
        //     //         // Invalid login
        //     //         System.out.println("\nInvalid login. Please try again.");
        //     //         break;
        //     // }

            
        //     // if 

        // }   

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
            String lineData = line.nextLine().trim();
            // If the file is empty or not found, return a default value
            line.close();
            if (lineData.equals("")) {
                return 2024;
            } else {
                return Integer.parseInt(lineData);
            }
                
    }

    private static int getCurrentSemester() throws FileNotFoundException {
        File file = new File("masterDatabase/currentSemesterData.txt");
        Scanner line = new Scanner(file);
        String lineData = line.nextLine().trim();
        line.close();
            // If the file is empty or not found, return a default value
            if (lineData.equals("")) {
                return 1;
            } else {
                return Integer.parseInt(lineData);
            }
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
    private static void readTeachingStaffFromFiles(ArrayList<TeachingStaff> allTeachingStaff) throws FileNotFoundException {
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

            //Uncomment the following lines to print all teaching staff
        // System.out.println("All Teaching Staff:");
        // for (TeachingStaff teachingStaff : allTeachingStaff) {
        // if (teachingStaff.getSurname().equals("admin")) {
        //     continue;
        // }
        //     System.out.println(teachingStaff);
        // }
            // System.out.println(staff + "\n");
        }
    }
    
    // Seed the teaching staff's data from a file in the masterDatabase directory
    // This is the first time the system is run, so we need to seed the database
    private static void seedTeachingStaff(ArrayList<TeachingStaff> allTeachingStaff) throws FileNotFoundException, IOException {
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
        
            //Uncomment the following lines to print all teaching staff
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
    private static void seedSectionsAndStudents(ArrayList<Section> allSections) throws FileNotFoundException, IOException {
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
    private static void readAllSectionsFromFiles(ArrayList<Section> allSections) throws IOException, FileNotFoundException {
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
        
        // System.out.println("All Sections and Students:");
        // for (Section section : allSections) {
            // System.out.println(section);
            // }

    }
    
    // Write the section and students' data to a file in the allSections directory
    // This is the first time the system is run, so we need to seed the database
    // ✅ Writes to 'allSections/SectionName_Graded.txt'
    public static void writeSectionToFile(Section section) throws IOException, FileNotFoundException {
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
    

    // ---------------------------------------------    MOST ADMIN FUNCTIONS    --------------------------------------------------------------------------

    public static void displayAdminMenu(Admin currentAdmin) throws FileNotFoundException, IOException {
        Scanner scanner = new Scanner(System.in);
        int adminInput = scanner.nextInt();
        while(adminInput != 0) {
            System.out.println(Displays.borderEqual);
            System.out.println("Admin Menu");
            System.out.println("Current Admin Logged in: " + currentAdmin.getFirstname() + " " + currentAdmin.getSurname());
            System.out.println(Displays.borderEqual);
            System.out.println("NOTE: User Input is type [INT]");
            System.out.println("1. View current Admin Records");
            System.out.println("2. View Admin Functions and Responsibilities");
            System.out.println("3. Save current Semester's (Sections, Students, and Teaching Staff) data");
            System.out.println("4. Push to next Semester");
            System.out.println("5. Clear current allSections and allTeachingStaff files");
            System.out.println("6. Clear current allSection and allTeachingStaff in memory (Do this only while program is running)");
            System.out.println("7. Seed New Information of all Teaching Staff, and all Sections");
            System.out.println("8. Push to next Academic Year");
            System.out.println("0. Logout as Admin");
        
            System.out.println("\nInput Selected Option: ");
            adminInput = scanner.nextInt();

            switch (adminInput) {
                case 1:
                    // View current Admin Records
                    viewAdminRecords(currentAdmin);
                    break;
                case 2:
                    // View Admin Functions and Responsibilities
                    viewAdminFunctionsAndResponsibilities();
                    break;
                case 3: 
                    // Save current Semester (Sections, Students, and Teaching Staff)
                    // TODO functionality
                    System.out.println("Saving current Semester's data...");
                    break;
                case 4:
                    // Push program to next Semester
                    pushSemester(new File("masterDatabase/currentSemesterData.txt"));
                    break;
                case 5:
                    // Clear the current files within the allSections, allTeachingStaff, and allStudents directories
                    //TODO atm
                    System.out.println("Clearning current allSections, allTeachingStaff, and allStudents files...");
                    break;
                case 6: 
                    // Seed new Infomation of allTeachingStaff, and allSections



            }
        }
        // default will always make the admin logout

    }

    // View the current admin's records from adminRecords directory
    private static void viewAdminRecords(Admin currentAdmin) throws FileNotFoundException {
        File adminFile = new File("adminRecords/" + currentAdmin.getAdminFileName());
        if (!adminFile.exists()) {
            System.out.println("Admin file not found.");
        } else {
            try (Scanner adminScanner = new Scanner(adminFile)) {
                while (adminScanner.hasNextLine()) {
                    String currentAdminRecord = adminScanner.nextLine();
                    System.out.println(currentAdminRecord);
                }
                adminScanner.close();
            }
        }
    }

    // View the admin functions and responsibilities from masterDatabase directory
    private static void viewAdminFunctionsAndResponsibilities() throws FileNotFoundException {
        File adminFunctionsFile = new File("masterDatabase/adminFunctions.txt");
        if (!adminFunctionsFile.exists()) {
            System.out.println("Admin functions file not found.");
        } else {
            try (Scanner adminFunctionsScanner = new Scanner(adminFunctionsFile)) {
                while (adminFunctionsScanner.hasNextLine()) {
                    String currentAdminFunctions = adminFunctionsScanner.nextLine();
                    System.out.println(currentAdminFunctions);
                }
            }
        }
    }

    // Push the current semester to the next semester
    // This is done by reading the current semester from a file, and writing the new semester to the same file
    private static void pushSemester(File semFile) throws IOException {
        Scanner scan = new Scanner(semFile);
        
            int currentSemester = Integer.parseInt(scan.nextLine().trim());
            if (currentSemester == 1) {
                currentSemester = 2;
            } else if (currentSemester == 2) {
                currentSemester = 1;
            }
        scan.close();

        // Write the new semester to the same file
        FileWriter semWriter = new FileWriter(semFile);
        semWriter.write(String.valueOf(currentSemester));
        semWriter.close();
        System.out.println("Pushed to next semester: " + currentSemester);
    }

    // Clear the current allSections and allTeachingStaff in memory
    private static ArrayList<Section> clearCurrentSections(ArrayList<Section> allSections) {
        allSections.clear();
        return allSections;
    }

    private static ArrayList<TeachingStaff> clearCurrentTeachingStaffs(ArrayList<TeachingStaff> allTeachingStaff) {
        allTeachingStaff.clear();
        return allTeachingStaff;
    }

    // ---------------------------------------------    MOST ADMIN FUNCTIONS    --------------------------------------------------------------------------

    // END OF FILE OF THE STUDENT GRADING SYSTEM
    }




// TODO Functionality:
/*
 * 1.
 * 
 * 
 */