//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import Model.Expense;
import Service.ExpenseManager;
import java.util.Scanner;
public class Main {

    public
    static void main(String[] args) {
                System.out.println("\nHello, Expense Tracker!");

                ExpenseManager Manage = new ExpenseManager();
                Scanner sc = new Scanner(System.in);

                System.out.println("\n----EXPENSE TRACKER----\n");
                System.out.println("1.Add Expense :");
                System.out.println("2.View Expense :");
                System.out.println("3.Total spending :");
                System.out.println("4.EXIT :\n");
                int choice = 0;
                while (choice != 4) {

                    System.out.print("Choose Option :");
                    choice = sc.nextInt();
                    sc.nextLine();

                    switch (choice) {
                        case 1:
                            System.out.print("Enter Title :");
                            String title = sc.nextLine();

                            System.out.print("Enter Amount :");
                            double amount = sc.nextDouble();
                            sc.nextLine();

                            // System.out.print("Enter Catagory :");
                            //String catagory=sc.nextLine();
                            Expense ex = new Expense(title, amount);
                            Manage.addExpense(ex);
                            break;

                        case 2:
                            Manage.showAllExpenses();
                            break;

                        case 3:
                            Manage.showTotalExpense();
                            break;

                        case 4:
                            System.out.println("----EXIT----\n");
                    }
                }
            }
        }