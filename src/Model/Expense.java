// ============================================================
// Expense.java
// Package: model
// ============================================================

package Model;
public class Expense {

    private int expenseId;
    private int userId;
    private String title;
    private double amount;
    private String category;
    private String date;
    private String description;


    public Expense(int userId, String title, double amount, String category,
                   String date, String description) {

        this.userId = userId;
        this.title = title;
        this.amount = amount;
        this.category = category;
        this.date = date;
        this.description = description;
    }

    public Expense(int expenseId, int userId, String title,
                   double amount, String category,
                   String date, String description) {

        this.expenseId = expenseId;
        this.userId = userId;
        this.title = title;
        this.amount = amount;
        this.category = category;
        this.date = date;
        this.description = description;
    }


    public int getExpenseId() {
        return expenseId;
    }


    public int getUserId() {
        return userId;
    }


    public String getTitle() {
        return title;
    }


    public double getAmount() {
        return amount;
    }


    public String getCategory() {
        return category;
    }


    public String getDate() {
        return date;
    }


    public String getDescription() {
        return description;
    }


    public void displayExpense() {

        System.out.println(
                "Title: " + title +
                        " | Amount: " + amount +
                        " | Category: " + category +
                        " | Date: " + date +
                        " | Description: " + description
        );
    }
}