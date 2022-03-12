package com.exercises;

import java.io.Serializable;

public class Expense implements Serializable {

    private String name;
    private String type;
    private int price;

    public int getPrice() {
        return price;
    }

    public Expense(String name, String type, int price) {
        this.name = name;
        this.type = type;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Expense{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", price=" + price +
                '}';
    }
}
