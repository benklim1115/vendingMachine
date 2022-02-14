package com.techelevator.models;

import java.math.BigDecimal;

public class Gum extends Item{
    public Gum (String name, BigDecimal price, int quantity){
        super(name, price, quantity);
    }


    public String dispenseItem(){
        String output = "";
            output = this.getName() + " $" + this.getPrice();
            this.setQuantity(this.getQuantity()-1);
        System.out.println("Chew Chew, Yum!");
        return output;
    }
}
