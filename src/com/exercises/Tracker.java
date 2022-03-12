package com.exercises;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Tracker {

    private List<Expense> Expensions;
    private Month month = LocalDate.now().getMonth();
    private Path path = Paths.get(month + ".txt");

    public Tracker() {
        Expensions = new ArrayList<Expense>();
    }

    public void addExpense(Expense expense) {

        Expensions.add(expense);

    }

    public void removeExpense(Expense expense) {
        Expensions.remove(expense);
    }

    public void saveToFile() {


        StandardOpenOption standardOpenOption;


        if (!path.toFile().isFile()) {
            standardOpenOption = StandardOpenOption.CREATE_NEW;
        } else {
            standardOpenOption = StandardOpenOption.APPEND;
        }
        try (BufferedWriter writer = Files.newBufferedWriter(path,
                StandardCharsets.UTF_8, standardOpenOption)) {
            for (Expense expense : Expensions) {
                writer.write(expense.toString() + System.lineSeparator());
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public void calculateExpensesSum(String month) {
        List<String> list = new ArrayList<>();
        int wholePrice=0;
        Path pathToExpenses = Paths.get(month.toUpperCase() + ".txt");
        Path pathToExpensesSumFile = Paths.get(month.toUpperCase()+"_expenses sum" + ".txt");

        try (BufferedReader bufferedReader = Files.newBufferedReader(pathToExpenses)) {
            list = bufferedReader.lines().collect(Collectors.toList());


        } catch (IOException exception) {
            exception.printStackTrace();
        }
        for (String expense : list) {
           wholePrice+=Integer.parseInt(expense.substring(expense.indexOf("price=")+6,expense.indexOf("}")));
        }

        try (BufferedWriter writer = Files.newBufferedWriter(pathToExpensesSumFile,
                StandardCharsets.UTF_8, StandardOpenOption.CREATE)) {

             writer.write(String.valueOf(wholePrice));

        } catch (Exception exception) {
            exception.printStackTrace();
        }

    }
}
