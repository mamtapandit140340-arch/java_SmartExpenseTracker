package main;
// Main.java

import Model.Catagory;
import Model.Catagory.*;
import Model.Expense;
import Service.ExpenseManager;

import java.util.Scanner;
import java.sql.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // ====================================================
        // DEMO USER
        int userId = 1;
        ExpenseManager manager = new ExpenseManager(userId);
        while (true) {
            System.out.println("\n\n=================================");

            System.out.println("      SMART EXPENSE TRACKER");

            System.out.println("=================================");

            System.out.println("1. Add Expense");

            System.out.println("2. View Expenses");

            System.out.println("3. Total Expense");

            System.out.println("4. Filter by Category");

            System.out.println("5. Delete Expense");

            System.out.println("6. Exit");

            System.out.print("Choose Option: ");

            String input = sc.nextLine();

            int choice;
            try {
                choice = Integer.parseInt(input.trim());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a number from 1 to 6.");
                continue;
            }
            switch (choice) {
                  // ADD EXPENSE
                    case 1:
                    System.out.print("Enter Expense Title: ");
                    String title = sc.nextLine();

                    System.out.print("Enter Amount: ");
                    double amount = sc.nextDouble();

                    sc.nextLine();

                    String category =
                            Catagory.detectCategory(title);

                    System.out.println(
                            "Detected Category: "+ category);

                    System.out.print(
                            "Enter Date (YYYY-MM-DD): ");
                    String date =sc.nextLine();

                    System.out.print("Enter Description: ");

                    String description =
                            sc.nextLine();

                        // When adding an expense:
                        Expense expense = new Expense(
                                userId, title, amount, category, date, description
                        );

                        manager.addExpense(expense);
                    break;

                // ============================================
                // VIEW EXPENSES
                 case 2:
                    manager.viewExpenses();
                    break;

                // ============================================
                // TOTAL EXPENSE
                case 3:
                    manager.showTotalExpense();
                    break;

                // ============================================
                // FILTER BY CATEGORY
                case 4:
                    System.out.print("Enter Category: ");


                    String selectedCategory =
                            sc.nextLine();

                    manager.filterByCategory(
                            selectedCategory
                    );

                    break;

                // ============================================
                // DELETE EXPENSE
                case 5:
                    System.out.print("Enter Expense ID: ");

                    int expenseId =
                            sc.nextInt();
                            sc.nextLine();

                    manager.deleteExpense(
                            expenseId
                    );
                    break;


                // ============================================
                // EXIT
                case 6:
                    System.out.println("Thank you for using Smart Expense Tracker!");
                    sc.close();
                    return;

                // ============================================
                // INVALID OPTION
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
