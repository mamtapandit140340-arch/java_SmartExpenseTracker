// ============================================================
// ExpenseDAO.java
// Package: dao
// ============================================================

package dao;

import util.DBConnection;
import Model.Expense;

import java.sql.*;
import java.util.ArrayList;

public class ExpenseDAO {


    // ========================================================
    // ADD EXPENSE
    // ========================================================

    public void addExpense(Expense expense) {

        String categorySql =
                "SELECT category_id FROM categories " +
                        "WHERE category_name = ?";


        String expenseSql =
                "INSERT INTO expenses " +
                        "(user_id, title, amount, category_id, expense_date, description) " +
                        "VALUES (?, ?, ?, ?, ?, ?)";


        try (Connection connection =
                     DBConnection.getConnection();

             PreparedStatement categoryStatement =
                     connection.prepareStatement(categorySql)) {


            categoryStatement.setString(
                    1,
                    expense.getCategory()
            );


            ResultSet resultSet =
                    categoryStatement.executeQuery();


            if (resultSet.next()) {

                int categoryId =
                        resultSet.getInt("category_id");


                try (PreparedStatement expenseStatement =
                             connection.prepareStatement(expenseSql)) {


                    expenseStatement.setInt(
                            1,
                            expense.getUserId()
                    );


                    expenseStatement.setString(
                            2,
                            expense.getTitle()
                    );


                    expenseStatement.setDouble(
                            3,
                            expense.getAmount()
                    );


                    expenseStatement.setInt(
                            4,
                            categoryId
                    );


                    expenseStatement.setString(
                            5,
                            expense.getDate()
                    );


                    expenseStatement.setString(
                            6,
                            expense.getDescription()
                    );


                    expenseStatement.executeUpdate();

                    System.out.println(
                            "Expense saved to database successfully!"
                    );
                }
            }

        } catch (Exception e) {

            System.out.println(
                    "Error while adding expense: "
                            + e.getMessage()
            );
        }
    }


    // ========================================================
    // VIEW ALL EXPENSES
    // ========================================================

    public ArrayList<Expense> getAllExpenses(int userId) {

        ArrayList<Expense> expenses =
                new ArrayList<>();


        String sql =
                "SELECT e.expense_id, e.user_id, e.title, " +
                        "e.amount, c.category_name, " +
                        "e.expense_date, e.description " +
                        "FROM expenses e " +
                        "JOIN categories c " +
                        "ON e.category_id = c.category_id " +
                        "WHERE e.user_id = ? " +
                        "ORDER BY e.expense_date DESC";


        try (Connection connection =
                     DBConnection.getConnection();

             PreparedStatement statement =
                     connection.prepareStatement(sql)) {


            statement.setInt(1, userId);


            ResultSet resultSet =
                    statement.executeQuery();


            while (resultSet.next()) {

                Expense expense =
                        new Expense(

                                resultSet.getInt(
                                        "expense_id"
                                ),

                                resultSet.getInt(
                                        "user_id"
                                ),

                                resultSet.getString(
                                        "title"
                                ),

                                resultSet.getDouble(
                                        "amount"
                                ),

                                resultSet.getString(
                                        "category_name"
                                ),

                                resultSet.getString(
                                        "expense_date"
                                ),

                                resultSet.getString(
                                        "description"
                                )
                        );


                expenses.add(expense);
            }


        } catch (Exception e) {

            System.out.println(
                    "Error while fetching expenses: "
                            + e.getMessage()
            );
        }


        return expenses;
    }


    // ========================================================
    // TOTAL EXPENSE
    // ========================================================

    public double getTotalExpense(int userId) {

        double total = 0;


        String sql =
                "SELECT SUM(amount) AS total " +
                        "FROM expenses " +
                        "WHERE user_id = ?";


        try (Connection connection =
                     DBConnection.getConnection();

             PreparedStatement statement =
                     connection.prepareStatement(sql)) {


            statement.setInt(1, userId);


            ResultSet resultSet =
                    statement.executeQuery();


            if (resultSet.next()) {

                total =
                        resultSet.getDouble("total");
            }


        } catch (Exception e) {

            System.out.println(
                    "Error while calculating total: "
                            + e.getMessage()
            );
        }


        return total;
    }


    // ========================================================
    // FILTER BY CATEGORY
    // ========================================================

    public ArrayList<Expense> getExpensesByCategory(
            int userId,
            String category) {


        ArrayList<Expense> expenses =
                new ArrayList<>();


        String sql =
                "SELECT e.expense_id, e.user_id, e.title, " +
                        "e.amount, c.category_name, " +
                        "e.expense_date, e.description " +
                        "FROM expenses e " +
                        "JOIN categories c " +
                        "ON e.category_id = c.category_id " +
                        "WHERE e.user_id = ? " +
                        "AND c.category_name = ?";


        try (Connection connection =
                     DBConnection.getConnection();

             PreparedStatement statement =
                     connection.prepareStatement(sql)) {


            statement.setInt(1, userId);

            statement.setString(2, category);


            ResultSet resultSet =
                    statement.executeQuery();


            while (resultSet.next()) {

                Expense expense =
                        new Expense(

                                resultSet.getInt(
                                        "expense_id"
                                ),

                                resultSet.getInt(
                                        "user_id"
                                ),

                                resultSet.getString(
                                        "title"
                                ),

                                resultSet.getDouble(
                                        "amount"
                                ),

                                resultSet.getString(
                                        "category_name"
                                ),

                                resultSet.getString(
                                        "expense_date"
                                ),

                                resultSet.getString(
                                        "description"
                                )
                        );


                expenses.add(expense);
            }


        } catch (Exception e) {

            System.out.println(
                    "Error while filtering expenses: "
                            + e.getMessage()
            );
        }


        return expenses;
    }


    // ========================================================
    // DELETE EXPENSE
    // ========================================================

    public void deleteExpense(
            int expenseId,
            int userId) {


        String sql =
                "DELETE FROM expenses " +
                        "WHERE expense_id = ? " +
                        "AND user_id = ?";


        try (Connection connection =
                     DBConnection.getConnection();

             PreparedStatement statement =
                     connection.prepareStatement(sql)) {


            statement.setInt(1, expenseId);

            statement.setInt(2, userId);


            int rows =
                    statement.executeUpdate();


            if (rows > 0) {

                System.out.println(
                        "Expense deleted successfully!"
                );

            } else {

                System.out.println(
                        "Expense not found!"
                );
            }


        } catch (Exception e) {

            System.out.println(
                    "Error while deleting expense: "
                            + e.getMessage()
            );
        }
    }
}