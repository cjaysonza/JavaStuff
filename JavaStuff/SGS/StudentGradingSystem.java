/*
 * 
 * This is a simple Java program that serves as a starting point for a student grading system.
 * @author: csonza, rmol, vgba
 * 
 * @Mark-Update: 0.3
 * @Version-Update: 0.2
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
        // seedSectionsAndStudents(allSections);
        // seedTeachingStaff(allTeachingStaff);
        readAllSectionsFromFiles(allSections);
        readTeachingStaffFromFiles(allTeachingStaff);
        
        String schoolName = "University of Advance Studies, Training, Research, and Academia";
        // Now: University of Advance Studies, Training, Research, and Academia (U-ASTRA) 
        
        boolean isRunning = true;
        while (isRunning) { 
            // Read the current academic year from a file. default: 2024
            int currentAcademicYear = getCurrentAcademicYear();
        
            // Read the current semester from a file. default: 1
            int currentSemester = getCurrentSemester();   

            boolean isAdminLoggedIn = false;
            TeachingStaff loggedInTeachStaff;

            String userInput = Displays.displayStartMenu(schoolName, currentAcademicYear, currentSemester);
            // START MENU
            switch (userInput) {
                case "1":
                    // Administrator login
                    // loginResult = Displays.displayLoginMenu(currentAdmin, allTeachingStaff); 
                    isAdminLoggedIn = Displays.displayLoginMenuAdmin(currentAdmin);
                    if (isAdminLoggedIn != true) {
                        System.out.println("returning to start menu");
                    } else if (isAdminLoggedIn == true) {
                        displayAdminMenu(currentAdmin, allSections, allTeachingStaff);
                    }
                    break;
                case "2":
                    // Login as Teaching Staff
                    // loginResult = Displays.displayLoginMenu(currentAdmin, allTeachingStaff); 
                    loggedInTeachStaff = Displays.teachingStaffLogin(allTeachingStaff);
                    if (loggedInTeachStaff == null) {
                        System.out.println("returning to start menu");
                    } else if (loggedInTeachStaff != null) {
                        Displays.displayTeachingStaffMenu(loggedInTeachStaff, allSections);
                    }
                    break;
                case "0":
                    // Exit the program
                    Displays.displayExitMessage();
                    System.out.println("Exiting the program...");
                    isRunning = false;
                    Utility.appendToAdminRecord("\nProgram was ended\n\n");
                    break;
                default:
                    System.out.println("\nInvalid input. Please try again.");
                    Utility.appendToAdminRecord("\nuser made invalid input");
                break;
            }
        }

// END OF START MENU

        // // This is the first time the system is run, so we need to seed the database
        // seedSectionsAndStudents(allSections);
        // seedTeachingStaff(allTeachingStaff);
        
        // Uncomment the following lines to run the program without user input
        // printFirstStudentOfEverySection(allSections);
        
    }

    // Current academic year is read from a file
    public static int getCurrentAcademicYear() throws FileNotFoundException {
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

    public static int getCurrentSemester() throws FileNotFoundException {
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

    // THIS WAS JUST A TESTER METHOD
    // Read the admin's data from a file in the adminRecords directory
    // private static void printFirstStudentOfEverySection(ArrayList<Section> allSections) {
    //     for (Section section : allSections) {
    //         Student student = section.getStudents().get(3);
    //         System.out.println(section.getSectionName());
    //         System.out.println(student.getSurname() + " " + student.getFirstname() + "\n" + student.getStudentID() + "\n" + student.getMajor()
    //         + "\n" + Arrays.toString(student.getCourses()) + "\n" + Arrays.toString(student.getLetterGrades())
    //         + "\n" + Arrays.toString(student.getNumGrades()));
    //         System.out.println("--------------------------------------------------\n\n\n");
    //     }
    // }
    
    // Read the teaching staff's data from a file in the allTeachingStaff directory
    private static void readTeachingStaffFromFiles(ArrayList<TeachingStaff> allTeachingStaff) throws IOException {
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
        allTeachingStaffScanner.close();
    }
    
    // Seed the teaching staff's data from a file in the masterDatabase directory
    // This is the first time the system is run, so we need to seed the database
    private static void seedTeachingStaff(ArrayList<TeachingStaff> allTeachingStaff) throws FileNotFoundException, IOException {
        File staffFile = new File("masterDatabase/teachingStaffDatabase.txt");
        try (Scanner staffScanner = new Scanner(staffFile)) {
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
                // staffID + "-" + surname 
                String filename = newStaff.getStaffID() + "-" + newStaff.getSurname().replace(" ", "");
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
        }
        // Prints all teachers into a single file
        writeTeachingStaffToFile(allTeachingStaff);
        
            //Uncomment the following lines to print all teaching staff
        // System.out.println("All Teaching Staff:");
        // for (TeachingStaff teachingStaff : allTeachingStaff) {
            // if (teachingStaff.getSurname().equals("admin")) {
                // continue;
        // }
        // System.out.println(teachingStaff);
        // }
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
                currentSectionName = line.substring(1).trim(); // Remove the ">"
                currentStudents = new ArrayList<>();
                continue;
            }
            
            if (line.equals("---")) {
                currentStudents = Utility.bubbleSortStudents(currentStudents);

                Section newSection = new Section(currentSectionName);
                for (Student s : currentStudents) {
                    newSection.addStudent(s);
                }
                allSections.add(newSection);
                System.out.println(newSection + "\n");

                writeSectionToFile(newSection);
                writeFormattedGradedFile(newSection);
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
    public static void readAllSectionsFromFiles(ArrayList<Section> allSections) throws IOException, FileNotFoundException {
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
        allSectionsScanner.close();
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
    
    //  Writes to 'allTeachingStaff/all-teaching-staff.txt'
    public static void writeTeachingStaffToFile(ArrayList<TeachingStaff> staffList) throws IOException {
        FileWriter writer = new FileWriter("allTeachingStaff/all-teaching-staff.txt");
        // File allTeachingStaffFile = new File("allTeachingStaff/all-teaching-staff.txt");
        // if (!allTeachingStaffFile.exists()) {
        //     System.out.println("all-teaching-staff.txt does not exist yet");
        //     allTeachingStaffFile.createNewFile();
        //     System.out.println("all-teaching-staff.txt has been made");
        // }

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
        
        writer.write("");
        writer.close();
    }

    // Create a <sectionname>_Graded.txt for each section
    public static void writeFormattedGradedFile(Section section) throws IOException {
        File dir = new File("allSectionsGraded");
        if (!dir.exists()) dir.mkdir();

        File gradedFile = new File(dir, section.getSectionName() + "_Graded.txt");
        FileWriter writer = new FileWriter(gradedFile); // Overwrite during seeding

        int acadYear = StudentGradingSystem.getCurrentAcademicYear();
        int semester = StudentGradingSystem.getCurrentSemester();

        writer.write(String.format("Formatted Grade Report for Section: %s\n", section.getSectionName()));
        writer.write("Academic Year: " + acadYear + "-" + (acadYear + 1) + "\n");
        writer.write("Semester: " + semester + "\n");
        writer.write(Displays.border + Displays.border + "\n");
        writer.write("\n\n");

        writer.close();
    }

    // Append the actions in Displays.gradeStudentInSectionCourseConsole to the sections respective Graded.txt
    public static void appendToFormattedGradedFile(Section section, String courseInputName) throws IOException {
        File dir = new File("allSectionsGraded");
        if (!dir.exists()) dir.mkdir();

        File gradedFile = new File(dir, section.getSectionName() + "_Graded.txt");
        FileWriter writer = new FileWriter(gradedFile, true);

        writer.write(Displays.border + Displays.border + "\n");
        writer.write(String.format("Formatted Grade Report for Section: %s\n", section.getSectionName()));
        writer.write("-> Course Graded: " + courseInputName + "\n");
        writer.write(String.format("%-25s %-10s %-32s %-10s %-20s\n", "Full Name", "ID", "Course", "Num Grade", "Letter Grade"));
        writer.write(Displays.border + Displays.border + "\n");

        for (Student student : section.getStudents()) {
            String fullName = student.getFirstname() + " " + student.getSurname();
            String id = student.getStudentID();
            String[] courses = student.getCourses();
            String[] letterGrades = student.getLetterGrades();
            double[] numGrades = student.getNumGrades();

            for (int i = 0; i < courses.length; i++) {
                if (courses[i].equalsIgnoreCase(courseInputName) && numGrades[i] > 0.0) {
                    writer.write(String.format("%-25s %-10s %-32s %-10.2f %-20s\n",
                            fullName, id, courses[i], numGrades[i], letterGrades[i]));
                    break; // Stop checking further courses for this student
                }
            }
        }

        writer.write("\n\n");
        writer.close();
    }

    // Write the admin's data to a file in the adminRecords directory
    // This is the first time the system is run, so we need to seed the database
    private static void writeAdminToAdminRecords(Admin currentAdmin) throws FileNotFoundException, IOException {
        FileWriter adminWriter = new FileWriter("adminRecords/" + currentAdmin.getAdminFileName());
            adminWriter.write("Name: " + currentAdmin.getFirstname() + " " + currentAdmin.getSurname() + "\n");
            adminWriter.write("Admin ID: " + currentAdmin.getAdminID() + "\n");
            adminWriter.write("Password: " + currentAdmin.getPassword() + "\n");
            adminWriter.write("Department: Adminstritative - Program Management\n");
            adminWriter.write("Records and Actions: \n");
            adminWriter.write("\n");
        adminWriter.close();
    }
    

    // ---------------------------------------------    MOST ADMIN FUNCTIONS    --------------------------------------------------------------------------
    
    public static void displayAdminMenu(Admin currentAdmin, ArrayList<Section> allSections, ArrayList<TeachingStaff> allTeachingStaff) throws FileNotFoundException, IOException {
        Scanner scanner = new Scanner(System.in);
        boolean loggedIn = true;
        while(loggedIn) {
            int acadYear = getCurrentAcademicYear();
            int semester = getCurrentSemester();
            String currentData = String.format("Acad.Year: %d-%d\t\tSemester: %d", acadYear, acadYear + 1, semester);
            System.out.println(Displays.borderEqual);
            System.out.println("Admin Menu");
            System.out.println("Current Admin Logged in: " + currentAdmin.getFirstname() + " " + currentAdmin.getSurname());
            System.out.println(currentData);
            System.out.println(Displays.borderEqual);
            System.out.println("NOTE: User Input is type [INT]");
            System.out.println("1. View current Admin Records");
            System.out.println("2. View Admin Functions and Responsibilities");
            System.out.println("3. Save current Semester's (Sections, Students, and Teaching Staff) data");
            System.out.println("4. Push to next Semester");
            System.out.println("5. Clear current allSections and allTeachingStaff files");
            System.out.println("6. Clear current allSection and allTeachingStaff in memory (Do this only while program is running)");
            System.out.println("7. Seed and Read New Information of all Teaching Staff, and all Sections");
            System.out.println("8. Push to next Academic Year");
            System.out.println("0. Logout as Admin");
            
            System.out.print("\nInput Selected Option: ");
            String adminInput = scanner.next().substring(0,1);
            // adminInput = scanner.nextInt();
            // Takes userInput that must be a number. Parses it from String just incase
            
            switch (adminInput) {
                case "1":
                    // View current Admin Records
                    viewAdminRecords(currentAdmin);
                    Displays.confirmNextPage();
                    break;
                case "2":
                    // View Admin Functions and Responsibilities
                    viewAdminFunctionsAndResponsibilities();
                    Displays.confirmNextPage();
                    break;
                case "3": 
                    // Save current Semester (Sections, Students, and Teaching Staff)
                    // NOTE: Very complicated, you have to do it manually :(
                    saveDataToRecords();
                    System.out.println("Saving current Semester's data...");
                    Displays.confirmNextPage();
                    break;
                case "4":
                    // Push program to next Semester
                    pushSemester(new File("masterDatabase/currentSemesterData.txt"));
                    Displays.confirmNextPage();
                    break;
                case "5":
                    // Clear the current files within the allSections, allTeachingStaff, and allStudents directories
                    clearAllCurrentFolders();
                    System.out.println("Clearning current allSections, allTeachingStaff, and allStudents files...");
                    System.out.println(allSections);
                    System.out.println(allTeachingStaff);
                    Displays.confirmNextPage();
                    break;
                case "6": 
                    // Clear current allSection and allTeachingStaff in memory (Do this only while program is running)
                    // This clears the current allSections and allTeachingStaff in memory
                    clearCurrentSections(allSections);
                    clearCurrentTeachingStaffs(allTeachingStaff);
                    System.out.print("Current allSections and allTeachingStaff has been cleared...");
                    Displays.confirmNextPage();
                    break;

                case "7":
                    // Seed and Read new semester and/or academic year from masterDatabase
                    seedSectionsAndStudents(allSections);
                    seedTeachingStaff(allTeachingStaff);

                    // readAllSectionsFromFiles(allSections);
                    // readTeachingStaffFromFiles(allTeachingStaff);
                    Displays.confirmNextPage();
                    break;

                case "8":
                    // Push to next Academic Year
                    pushAcademicYear(new File("masterDatabase/currentAcademicYearData.txt"));
                    Displays.confirmNextPage();
                    break;
                case "0":
                    System.out.println("Logging out. Returning to Start Menu");
                    Displays.confirmNextPage();
                    loggedIn = false;
                break;

                default:
                    System.out.println("Invalid Input, Please Try Again");
                    Displays.confirmNextPage();
                    break;
            }
        }
        // default will always make the admin logout
        // scanner.close();
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

    private static void pushAcademicYear(File AYFile) throws IOException {
        Scanner scan = new Scanner (AYFile);
        int currentAY = Integer.parseInt(scan.nextLine().trim());
        currentAY += 1;
        scan.close();

        FileWriter ayWriter = new FileWriter(AYFile);
        ayWriter.write(String.valueOf(currentAY));
        ayWriter.close();
        System.out.println("Pushed to next Academic Year: " + currentAY);
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

    private static void clearAllCurrentFolders() throws FileNotFoundException{
        // Deletes all content in allSections folder
        // String allTeachingStaffFile = "all-teaching-staff.txt";
        File sectionsFolder = new File("allSections");
        for (File file : sectionsFolder.listFiles()) {
            System.out.println("Deleted File: " + file.getName());
            file.delete();
        }
        // Deletes all content in allTeachingStaff folder
        File teachingStaffFolder = new File("allTeachingStaff");
        for (File file : teachingStaffFolder.listFiles()) {
            file.delete();
            System.out.println("Deleted File: " + file.getName());
        }

        // Deletes all content in allSectionsGraded folder
        File sectionsGradedFolder = new File("allSectionsGraded");
        for (File file : sectionsGradedFolder.listFiles()) {
            System.out.println("Deleted File: " + file.getName());
            file.delete();
        }

        System.out.println("all current folders have been deleted");
    }

    private static void saveDataToRecords() throws IOException {
        int acadYear = getCurrentAcademicYear();
        int semester = getCurrentSemester();
        File dirCurrentAY = new File("Records/AcadYear" + acadYear + "-" + (acadYear + 1));
        if (!dirCurrentAY.exists()){
            dirCurrentAY.mkdir();
            System.out.println("Folder \"" + dirCurrentAY.getName() + "\" has been created in Records");
        } else {
            System.out.println(dirCurrentAY.getName() + " has already been created");
        }

        File dirCurrentSem = new File("Records/" + dirCurrentAY.getName() + "/" + "Semester-" + semester);
        if (!dirCurrentSem.exists()){
            dirCurrentSem.mkdir();
            System.out.println("Folder \"" + dirCurrentSem.getName() + "\" has been created in Records/" + dirCurrentAY.getName());
        } else {
            System.out.println(dirCurrentSem.getName() + " has already been created");
        }

        File dirCreatedStarterFile = new File("Records/"+dirCurrentAY.getName()+"/"+dirCurrentSem.getName()+"/starterFile.txt");
        if(!dirCreatedStarterFile.exists()){
           dirCreatedStarterFile.createNewFile(); 
            System.out.println("Starter File has been made for accessible content");
        } 

        FileWriter writeStarterFile = new FileWriter(dirCreatedStarterFile);
        writeStarterFile.write("Just a starter file so you can access this folder much easier :)");
        writeStarterFile.close();

    }
    
    // ---------------------------------------------    MOST ADMIN FUNCTIONS    --------------------------------------------------------------------------

    // END OF FILE OF THE STUDENT GRADING SYSTEM
    }
