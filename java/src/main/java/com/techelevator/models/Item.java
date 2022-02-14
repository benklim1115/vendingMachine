package com.techelevator.models;

import java.math.BigDecimal;

public abstract class Item {

    private String name;
    private BigDecimal price;
    private int quantity;

    //abstract constructor
    public Item(String name, BigDecimal price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    //abstract method will be individualized by child classes
    public abstract String dispenseItem();

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String toString() {
        String itemString = "";
        if (this.quantity > 0) {
            itemString = this.name + " $" + this.price + " number available: " + this.quantity;
        } else {
            itemString = this.name + " $" + this.price + " SOLD OUT";
        }
        return itemString;
    }
}
