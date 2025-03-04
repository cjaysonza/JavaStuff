/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

//  package com.mycompany.storeactivity;

 /**
  *
  * @author csonza
  */
 import java.util.Scanner;
 
 public class StoreActivity {
 
     public static void main(String[] args) {
         Scanner input = new Scanner(System.in);
         
         int itemNumber = 1;
         String storeName = "";
         String item1 = "", item2 = "", item3 = "";
         double price1 =0.0d, price2 = 0.0, price3 = 0.0;
         double total = 0.0d;
         double totalNaTotal = 0.0d;
         double tax = 0.0d;
         
         System.out.println("STORE ACTIVITY");
         System.out.print("Enter the Store Name:\t");
         storeName = input.nextLine();
         
         // Item 1
         System.out.print("Enter Item #" + itemNumber + " Name:\t");
         item1 = input.nextLine();
         
         System.out.print("Enter Item #" + itemNumber + " Price:\t");
         price1 = input.nextDouble();
         input.nextLine();
         itemNumber += 1;
         
         // Item 2
         System.out.print("Enter Item #" + itemNumber + " Name:\t");
         item2 = input.nextLine();
         
         System.out.print("Enter Item #" + itemNumber + " Price:\t");
         price2 = input.nextDouble();
         input.nextLine();
         itemNumber += 1;
         
         // Item 3
         System.out.print("Enter Item #" + itemNumber + " Name:\t");
         item3 = input.nextLine();
         
         System.out.print("Enter Item #" + itemNumber + " Price:\t");
         price3 = input.nextDouble();
         input.nextLine();
         
         // TAXES
         System.out.println("=-=-=-=-=-=-=-=-=-=-=-=");
         System.out.println("TAX ON PAYMENTS");
         System.out.print("Enter Tax:\t");
         tax = input.nextDouble();
         input.nextLine();
         
         // TAX is turned into a % out of 100
         total = (price1 + price2 + price3);
         tax = total * (tax);
         totalNaTotal = tax + total;
         
         System.out.println("=-=-=-=-=-=-=-=-=-=-=-=");
         System.out.println("\n" + storeName);
         System.out.println("ITEMS\tPRICE");
         System.out.println(item1 + "\t" + price1);
         System.out.println(item2 + "\t" + price2);
         System.out.println(item3 + "\t" + price3);
         System.out.println("=-=-=-=-=-=-=-=-=-=-=-=");
         
         System.out.println("SUM:\tP" + total);
         System.out.println("TAX:\tP" + tax);
         System.out.println("TOTAL:\t" + totalNaTotal);
         
         input.close();
     }
 }