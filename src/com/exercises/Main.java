package com.exercises;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Expense> expensions =  new ArrayList<>();
        Tracker tracker = new Tracker(expensions);

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
