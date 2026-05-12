package Service;

import Model.Expense;
import java.util.ArrayList;
import java.util.List;
import Model.Catagory;


public class ExpenseManager {
    private List<Expense> expenses = new ArrayList<>();

    public void addExpense(Expense expense) {
        expenses.add(expense);
        System.out.println("\nExpense added sucessfully!\n");
    }

    public void showAllExpenses() {
        if (expenses.isEmpty()) {
            System.out.println("Expense not found !\n");
            return;
        }

        for (Expense e : expenses) {
            e.displayExpense();        }
    }
    public void filterByCatagory(String catagory) {
        if (expenses.isEmpty()) {
            System.out.println("Expense Not Found !");
        }
        for (Expense e : expenses) {
            e.displayExpense();
        }
    }
    public void showTotalExpense() {
        double total = 0;
        for (Expense e : expenses) {
            total += e.getAmount();
        }
        System.out.print("Total spended Amount :" + total + "\n\n");
    }


}


