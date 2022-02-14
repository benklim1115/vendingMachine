package com.techelevator.models;

import java.math.BigDecimal;

public class Chip extends Item{

    public Chip (String name, BigDecimal price, int quantity){
        super(name, price, quantity);
    }

    public String dispenseItem(){
        String output = "";
        output = this.getName() + " $" + this.getPrice();
        this.setQuantity(this.getQuantity()-1);
        System.out.println("Crunch Crunch, Yum!");
        return output;
    }
}
