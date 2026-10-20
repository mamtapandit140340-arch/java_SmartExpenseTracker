// ============================================================
// ExpenseManager.java
// Package: service
// ============================================================

package Service;
import dao.ExpenseDAO;
import Model.Expense;
import java.util.ArrayList;

public class ExpenseManager {

    private ArrayList<Expense> expenses;

    private ExpenseDAO expenseDAO;

    private int userId;

    // ========================================================
    // CONSTRUCTOR
    // ========================================================
    public ExpenseManager(int userId) {
        this.userId = userId;

        this.expenses =
                new ArrayList<>();

        this.expenseDAO =
                new ExpenseDAO();
    }


    // ========================================================
    // ADD EXPENSE
    // ========================================================

    public void addExpense(Expense expense) {

        expenses.add(expense);

        expenseDAO.addExpense(expense);
    }


    // ========================================================
    // VIEW EXPENSES
    // ========================================================

    public void viewExpenses() {

        expenses =
                expenseDAO.getAllExpenses(userId);


        if (expenses.isEmpty()) {

            System.out.println(
                    "No expenses found."
            );

            return;
        }


        for (Expense expense : expenses) {

            expense.displayExpense();
        }
    }


    // ========================================================
    // TOTAL EXPENSE
    // ========================================================

    public void showTotalExpense() {

        double total =
                expenseDAO.getTotalExpense(userId);


        System.out.println(
                "Total Expense: " + total
        );
    }


    // ========================================================
    // FILTER BY CATEGORY
    // ========================================================

    public void filterByCategory(
            String category) {


        ArrayList<Expense> filteredExpenses =
                expenseDAO.getExpensesByCategory(
                        userId,
                        category
                );


        if (filteredExpenses.isEmpty()) {

            System.out.println(
                    "No expenses found in "
                            + category
            );

            return;
        }


        for (Expense expense :
                filteredExpenses) {

            expense.displayExpense();
        }
    }


    // ========================================================
    // DELETE EXPENSE
    // ========================================================

    public void deleteExpense(
            int expenseId) {


        expenseDAO.deleteExpense(
                expenseId,
                userId
        );
    }
}