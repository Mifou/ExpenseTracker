package com.exercises;

public class Main {

    public static void main(String[] args) {
        Tracker tracker = new Tracker();

        Expense expense1 = new Expense("Bread", "Food", 10);
        Expense expense2 = new Expense("Flour", "Food", 4);
        Expense expense3 = new Expense("Toothpaste", "Health", 8);

        tracker.addExpense(expense1);
        tracker.addExpense(expense2);
        tracker.addExpense(expense3);

        tracker.saveToFile();
        tracker.calculateExpensesSum("march");
    }
}
