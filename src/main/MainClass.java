package main;

import database.DbConnectivity;

import java.util.Scanner;

public class MainClass {
    public static void main(String[] args) {

        DbConnectivity db = new DbConnectivity();
        Scanner sc = new Scanner(System.in);

        boolean x = true;
        while(x){
            System.out.println();
            System.out.println("<--------Student Record System--------->");
            System.out.println("Press 1 to add new record.");
            System.out.println("Press 2 to update record by Roll number.");
            System.out.println("Press 3 to view record by Roll number");
            System.out.println("Press 4 to show all record.");
            System.out.println("Press 5 to Exit.");
            System.out.print("Enter Your Choice : ");
            int choice = sc.nextInt();
            System.out.println();
            switch (choice){
                case 1:
                    System.out.println("Enter Roll Number : ");
                    int rollno = sc.nextInt();
                    System.out.println("Enter Name : ");
                    String name = sc.next();
                    System.out.println("Enter Mobile : ");
                    String mobile = sc.next();
                    System.out.println("Enter Email : ");
                    String email = sc.next();
                    db.add(rollno, name, mobile, email);

                    break;

                case 2:
                    System.out.println("Enter Roll Number : ");
                    int rollno1 = sc.nextInt();
                    System.out.println("Enter Name : ");
                    String name1 = sc.next();
                    System.out.println("Enter Mobile : ");
                    String mobile1 = sc.next();
                    System.out.println("Enter Email : ");
                    String email1 = sc.next();
                    db.update(rollno1, name1, mobile1, email1);

                    break;

                case 3:
                    System.out.println("Enter Roll Number : ");
                    int rollno2 = sc.nextInt();
                    db.viewByRollNo(rollno2);
                    break;

                case 4:
                    db.showAllRecord();
                    break;

                case 5:
                    x = false;
                    break;

                default:
                    System.out.println("Invalid Input...");
                    break;

            }
        }

    }
}
