/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

//  package com.mycompany.sonzasis;

 /**
  *
  * @author csonza
  */
 import java.util.Scanner;
 
 public class SIS {    
     static void displayMain() {
         try (Scanner input = new Scanner(System.in)) {
             final int UNITS_PER_COURSE = 3;
 
             int numEnrolCourses = 0; //ITS A FUCKING TEMP VALUE INTELLISENSE
             int coursesQPI = 0;
             int gradeUnitSum = 0;
             
             double qualityPointIndex = 0.0d;
             double gradeValue = 0.0d;
             double gradeUnitsValue = 0.0d;
             double calcQPI = 0.0d;
 
             String courseName = ""; 
             String notCounted = "Not Counted";
             String display = "";
             char gradeInput;
 
             /// BEGINNING PAGE 
             
             SISHeader();
             border();
             System.out.print("Enter your Number of Courses:\t");
             numEnrolCourses = input.nextInt();
             System.out.println("NOTE: Only allowable Grades are the following\n(A, B, C, D, E, F, W)");
             input.nextLine();
             coursesQPI = numEnrolCourses;
 
             border();
 
             for (int tempX = 1; tempX <= numEnrolCourses; tempX++) {
                 System.out.print("Enter Name of Course #" + tempX + ":\t");
                 courseName = input.nextLine();
 
                 System.out.print("Enter Attained Letter Grade:\t");
                 gradeInput = input.nextLine().toUpperCase().charAt(0);
 
                 switch (gradeInput) {
                     case 'A':
                         gradeValue = 5.0d;
                     break;
 
                     case 'B':
                         gradeValue = 4.0d;
                     break;
                     
                     case 'C':
                         gradeValue = 3.0d;
                     break;
                     
                     case 'D':
                         gradeValue = 2.0d;
                     break;
                     
                     case 'E':
                         gradeValue = 1.0d;
                     break;
                     
                     case 'F':
                         gradeValue = 0.0d;
                     break;
 
                     case 'W':
                         gradeValue = 0.0d;
                         coursesQPI--;
                     break;
 
                     default:
                         System.out.println("\nInvalid Input was read, Try Again");
                         tempX--;
                     break;
                 }
             display += courseName;
             display += "\t\t\t";
             display += gradeInput;
             display += "\t";
             if (gradeInput == 'W') {
                 display += notCounted;
                 display += "\n";
             } else {
                 gradeUnitsValue = gradeValue * UNITS_PER_COURSE;
                 gradeUnitSum += gradeUnitsValue;
 
                 display += gradeValue;
                 display += "\t";
                 display += gradeUnitsValue;
                 display += "\n";
             } 
         }
             calcQPI = coursesQPI * UNITS_PER_COURSE;
             qualityPointIndex = (double)gradeUnitSum / calcQPI;
 
         /// DISPLAY TABLE AREA
             displayGrades(display, gradeUnitSum, calcQPI, qualityPointIndex);
             closingProgram();
             input.close();
         }
     }
     
     static void displayGrades(String display, double gradeUnitSum, double calcQPI, double qualityPointIndex) {
         border();
         displayGradesHeader();
         System.out.println("Hi, User!\nHere are your Grades:");
         border();
         tableHeader();
             
         System.out.println(display);
         border();
         System.out.println((double)gradeUnitSum + "/" + calcQPI + "\t\tQPI: " + qualityPointIndex);
     }
     static void border(){
         System.out.println("=-=-=-=-=-=-=-=--=-=-=-=-=");
     }
     static void tableHeader(){
         System.out.println("COURSE NAME\t\tGRADE\t#VALUE\tRUN.SUM");
     }
     static void SISHeader(){
         System.out.println("[ Student Information System ]");
     }
     static void displayGradesHeader(){
         System.out.println("[ Student Information System ]");
     }
     static void closingProgram() {
         System.out.println("Thank you for using my program...");
         System.out.println("Closing Program");
     }
     
     // MAIN PROGRAM
     public static void main(String[] args) {
         displayMain();
     }
 }