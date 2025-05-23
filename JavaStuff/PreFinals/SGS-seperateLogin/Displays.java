
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/*
 * 
 * This class will contain certain display methods and menu screens for the project.
 * 
 * 
 */
public class Displays {
    
    // Borders
    public static String border = "--------------------------------------------------";
    public static String borderDash = "--------------------------------------------------";
    public static String borderEqual = "==================================================";


    // Start Menu
    public static String displayStartMenu(String schoolName, int currentAcademicYear, int currentSemester) {        
        Scanner scanner = new Scanner(System.in);
        System.out.println(borderEqual + borderEqual);
        System.out.println(schoolName + "\nAcademic Year: " + currentAcademicYear + "-" + (currentAcademicYear + 1));
        System.out.println("Semester: " + currentSemester);
        System.out.println(borderEqual + borderEqual);
        System.out.println("Welcome to the University Management System");
        System.out.println("1. Login as Administrator");        
        System.out.println("2. Login as Teaching Staff");
        System.out.println("0. Exit Program");
        System.out.print("\nPlease select an option [INT]: ");
        String userInput = scanner.nextLine();
        // scanner.close();
        return userInput; 
    }

    public static void displayExitMessage() throws IOException {
        String exitMessage = "Thank you for using the University Management System. Goodbye!";
        System.out.println(borderEqual + borderEqual);
        System.out.println(exitMessage);
        System.out.println(borderEqual + borderEqual);
    }

    public static boolean displayLoginMenuAdmin(Admin admin) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(borderEqual + borderEqual);
        System.out.println("Administrator Login Menu");
        System.out.println("Input \"prev\" in the username to return to the start menu.");
        System.out.println(borderEqual + borderEqual);
        System.out.print("Enter your username: ");
        String username = scanner.nextLine();
        
        // Check if user just mispressed and wants to return to the start menu
        if (username.equalsIgnoreCase("prev")) {
            System.out.println("returning to the start menu...");
            return false;
        }

        System.out.print("Enter your password: ");
        String password = scanner.nextLine();
        // scanner.close();

        // Check if the username is in the admin database
        if (username.equals((admin.getFirstname() + " " + admin.getSurname())) && password.equals(admin.getPassword())) {
            System.out.println("Logged in as: Administrator!");
            return true;
        }

        // If no match is found, return a value to trigger an error message
        System.out.println("Invalid username or password. Please try again.");
        return false;
    }

    // Login as Teaching Staff
    public static TeachingStaff teachingStaffLogin(ArrayList<TeachingStaff> allTeachingStaff) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(borderEqual + borderEqual);
        System.out.println("Teaching Staff Login Menu");
        System.out.println("Input \"prev\" in the username to return to the start menu.");
        System.out.println(borderEqual + borderEqual);
        System.out.print("Username(Firstname + Lastname): ");
        String username = scanner.nextLine();
        
        // Check if user just mispressed and wants to return to the start menu
        if (username.equalsIgnoreCase("prev")) {
            System.out.println("returning to the start menu...");
            return null;
        }

        System.out.print("Enter your password: ");
        String password = scanner.nextLine();
        // scanner.close();

        // Check if the username is in the allTeachingStaff database
        for (TeachingStaff staff : allTeachingStaff) {
            String fullName = staff.getFirstname().trim() + " " + staff.getSurname().trim();
            if (username.equalsIgnoreCase(fullName) && password.equals(staff.getPassword())) {
                System.out.println("Login successful. Welcome, " + fullName + "!");
                return staff;
            }
        }

        // If no match is found, return a value to trigger an error message
        System.out.println("Invalid username or password. Please try again.");
        return null;
    
    }

    // IF a teaching staff member is logged in, this method will be used to display their menu.
    public static void displayTeachingStaffMenu(TeachingStaff teachingStaff, ArrayList<Section> allSections) throws IOException {
        Scanner scanner = new Scanner(System.in);
        boolean loggedIn = true;

        while (loggedIn) {
            int acadYear = StudentGradingSystem.getCurrentAcademicYear();
            int semester = StudentGradingSystem.getCurrentSemester();
            String currentData = String.format("Acad.Year: %d-%d\t\tSemester: %d", acadYear, acadYear + 1, semester);
            System.out.println(borderEqual + borderEqual);
            System.out.println("Welcome " + teachingStaff.getFirstname() + ", " + teachingStaff.getSurname() + "!");
            System.out.println(teachingStaff.callInfo());
            System.out.println(currentData);
            System.out.println(borderEqual + borderEqual);
            System.out.println("1. View Teaching Record");
            System.out.println("2. View Class List");
            System.out.println("3. Grade Students of a Section");
            System.out.println("0. Logout");
            System.out.print("\nPlease select an option: ");
            String userInput = scanner.nextLine();

            switch (userInput) {
                case "1":
                    // View Teachers Teaching Record from txt file.
                    viewTeachingRecord(teachingStaff);
                    confirmNextPage();
                    break;
                case "2":
                    // View Class List. all Students of Sections Handled.
                    viewClassListForTeacher(teachingStaff, allSections);
                    confirmNextPage();
                    break;
                case "3":
                    // Actually Grading their Students.
                    gradeStudentsInSectionCourseConsole(allSections, teachingStaff);
                    confirmNextPage();
                    break;
                case "0":
                    // Logout
                    System.out.println("Logging out. Returning to Start Menu");
                    loggedIn = false;
                    confirmNextPage();
                    break;
                default:
                    System.out.println("Invalid Input, Please Try Again");
                    confirmNextPage();
                    break;

            }
        }
        // scanner.close();
    }

    // This is a confirmation page to ensure that the user wants to proceed to the next screen
    public static void confirmNextPage() {
            Scanner confirmInput = new Scanner(System.in);
            boolean runConfirm = true;
            while (runConfirm) { 
                System.out.println("\n");
                System.out.println("Proceed with Next Page: ");
                System.out.println("[Y] Yes");
                System.out.print(":> ");
                String confirm = confirmInput.nextLine();
                System.out.println("\n");

                if (confirm.equalsIgnoreCase("y") || confirm.equalsIgnoreCase("yes")) {
                    runConfirm = false;
                } else {
                    System.out.println("Invalid Input, Please Try again");
                    System.out.println("\n");
                    runConfirm = true;
                }
            }
            
        }

    // View current teachingStaff's teaching record from respective .txt file
    public static void viewTeachingRecord(TeachingStaff ts) throws FileNotFoundException, IOException {
        String specFilename = ts.getStaffID() + "-" + ts.getSurname().replace(" ", "") + ".txt";
        File teachingRecord = new File("allTeachingStaff/" + specFilename);

        Scanner filScan = new Scanner(teachingRecord);
        while (filScan.hasNext()) {
            String tsRecord = filScan.nextLine();
            System.out.println(tsRecord);
        }
        filScan.close();
    }

    // Prints all the students of all sections. If you handle that said section, it prints all their students. Otherwise, throws a message.
    public static void viewClassListForTeacher(TeachingStaff staff, ArrayList<Section> allSections) {
        System.out.println("\n📋 CLASS LIST FOR " + staff.getFirstname() + " " + staff.getSurname());

        boolean anyMatches = false;

        for (String sectionName : staff.getSectionsHandled()) {
            // Find the matching section object in allSections
            for (Section sec : allSections) {
                if (sec.getSectionName().equalsIgnoreCase(sectionName)) {
                    ArrayList<Student> studentsInSection = sec.getStudents();

                    for (String course : staff.getCoursesTaught()) {
                        // Track if this course has any matching students
                        boolean foundAny = false;
                        String Header = String.format("--%-16s %-16s | %-8s   | %s","Surname", "Firstname", "Student ID", "Major");

                        System.out.println("\n  Section: " + sectionName + " | Course: " + course);
                        System.out.println(border + border);
                        System.out.println(Header);
                        System.out.println(border + border);


                        for (Student student : studentsInSection) {
                            for (String studentCourse : student.getCourses()) {
                                if (studentCourse.trim().equalsIgnoreCase(course.trim())) {
                                    // Match found, print student info
                                    String output = String.format("> %-16s %-16s | ID: %-8s | Major: %s",
                                                                    student.getSurname(),
                                                                    student.getFirstname(),
                                                                    student.getStudentID(),
                                                                    student.getMajor()            
                                                                    );

                                    // System.out.println("> " + student.getFirstname() + " " + student.getSurname()
                                    //         + " | ID: " + student.getStudentID()
                                    //         + " | Major: " + student.getMajor());
                                    System.out.println(output);
                                    foundAny = true;
                                    anyMatches = true;
                                    break; // No need to keep looping student's courses
                                }
                            }
                        }

                        if (!foundAny) {
                            System.out.println("No students enrolled in " + course + " for section " + sectionName + ".");
                            System.out.println("Or, does not teach this course to this section");
                        }
                    }
                }
            }
        }

        if (!anyMatches) {
            System.out.println("No matching students found in any sections/courses handled by this staff member.");
        }

        System.out.println(); // extra newline
    }

    // Choose a Section -> Choose a Course to grade -> Validates all userinputs -> Grade the section's students of said course -> store data in respective section_data.txt 
    public static void gradeStudentsInSectionCourseConsole(ArrayList<Section> allSections, TeachingStaff teacher) throws IOException {
        Scanner scan = new Scanner(System.in);

        // Display sections handled by this teacher
        System.out.println("\nSections you handle:");
        for (String sectionName : teacher.getSectionsHandled()) {
            System.out.println("- " + sectionName);
        }

        // Prompt for section name
        System.out.print("\nEnter section to grade: ");
        String sectionInput = scan.nextLine().trim();

        Section selectedSection = null;
        for (Section s : allSections) {
            if (s.getSectionName().equalsIgnoreCase(sectionInput)) {
                selectedSection = s;
                break;
            }
        }

        if (selectedSection == null) {
            System.out.println("Section not found.");
            return;
        }

        // Display all Courses Taught by this teacher
        System.out.println("\nCourses you handle:");
        for (String courseName : teacher.getCoursesTaught()) {
            System.out.println("- " + courseName);
        } System.out.println("\n");

        // Prompt for course name
        System.out.print("Enter course to grade: ");
        String courseInput = scan.nextLine().trim();

        boolean courseFound = false;
        for (Student student : selectedSection.getStudents()) {
            for (String course : student.getCourses()) {
                if (course.equalsIgnoreCase(courseInput)) {
                    courseFound = true;
                    break;
                }
            }
            if (courseFound) break;
        }

        // Check if course is found
        if (!courseFound) {
            System.out.println("Course not found in this section. Please check the course name and try again.");
            return;
        }

        boolean alreadyGraded = Displays.isCourseAlreadyGraded(selectedSection, courseInput);
        // Check if any student of the current selection has a numGrade value that is not "0.0"
        if (alreadyGraded) {
            System.out.println("This section has already been graded for the course '" + courseInput + "'.");
            return;
        }

        // Check if user inputs were a valid assignment
        if (!isValidTeacherAssignment(teacher, sectionInput, courseInput)) {
            System.out.println("You are not authorized to grade this section or course.");
            return;
        }

        int acadYear = StudentGradingSystem.getCurrentAcademicYear();
        int semester = StudentGradingSystem.getCurrentSemester();
        String currentData = String.format("Acad.Year: %d-%d\t\tSemester: %d", acadYear, acadYear + 1, semester);
        String output = "\nGrading for Section: " + selectedSection.getSectionName() + ", Course: " + courseInput + "\n";
        output += currentData + "\n";
        output += border + border + "\n";

        System.out.println(output);
        for (Student student : selectedSection.getStudents()) {
            int courseIndex = -1;
            for (int i = 0; i < student.getCourses().length; i++) {
                if (student.getCourses()[i].equals(courseInput)) {
                    courseIndex = i;
                    break;
                }
            }
            String studFullName = student.getFirstname() + " " + student.getSurname();

            if (courseIndex != -1) {
                System.out.print("Enter grade for " + studFullName + " (" + student.getStudentID() + "): ");
                double grade = Utility.clampGrade(Double.parseDouble(scan.nextLine().trim()));
                student.getNumGrades()[courseIndex] = grade;
                student.getLetterGrades()[courseIndex] = Utility.toLetterGrade(grade);

                output += studFullName + " | " + student.getStudentID();
                output += " | Grade: " + grade + " (" + Utility.toLetterGrade(grade) + ")\n";
            }
        
        }
        scan.close();

        System.out.println("\n--- Grading Summary ---");
        System.out.println(output);

        // filename to append to teaching record
        String proFile = teacher.getStaffID() + "-" + teacher.getSurname().replace(" ", "");
        Utility.appendToTeachingRecord(output, proFile);

        StudentGradingSystem.writeSectionToFile(selectedSection);
        StudentGradingSystem.appendToFormattedGradedFile(selectedSection, courseInput);
        StudentGradingSystem.readAllSectionsFromFiles(allSections);
    }

    // Helper method in assessing if a section has already been graded.
    public static boolean isCourseAlreadyGraded(Section section, String courseName) {
        for (Student student : section.getStudents()) {
            for (int i = 0; i < student.getCourses().length; i++) {
                if (student.getCourses()[i].equalsIgnoreCase(courseName) &&
                    student.getNumGrades()[i] > 0.0) {
                    return true;
                }
            }
        }
        return false;
    }

    // Check if the teacher's inputs are a valid assignment
    public static boolean isValidTeacherAssignment(TeachingStaff teacher, String sectionInput, String courseInput) {
        boolean handlesSection = false;
        boolean teachesCourse = false;

        for (String section : teacher.getSectionsHandled()) {
            if (section.equalsIgnoreCase(sectionInput)) {
                handlesSection = true;
                break;
            }
        }

        for (String course : teacher.getCoursesTaught()) {
            if (course.equalsIgnoreCase(courseInput)) {
                teachesCourse = true;
                break;
            }
        }

        return handlesSection && teachesCourse;
    }


}
    // Determine login result





//shift+alt+f to format the code