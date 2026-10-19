package com.expensetracker.Model;
import static Model.Catagory.*;
import static com.expensetracker.Model.Catatory.detectCatagory;

public class Expense {

    private String title;
        private double amount;
        private String catagory;

        public Expense(String title,double amount) {
            this.title = title;
            this.amount = amount;
           // this.catagory = catagory;
        }
        public String getTitle(){
            return title;
        }

        public double getAmount(){
            return amount;
        }

        public String getCatagory(){
            return catagory;
        }

        public void displayExpense() {
            System.out.println("Title: " + title +" | Amount: " + amount +" | Category: " +detectCatagory(title));
            System.out.println();
        }

    }

