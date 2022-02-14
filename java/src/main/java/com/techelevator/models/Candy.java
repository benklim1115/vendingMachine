package com.techelevator.models;

import java.math.BigDecimal;

public class Candy extends Item{

    public Candy (String name, BigDecimal price, int quantity){
        super(name, price, quantity);
    }

    public String dispenseItem(){
            String output = "";
            output = this.getName() + " $" + this.getPrice();
            this.setQuantity(this.getQuantity()-1);
            System.out.println("Munch Munch, Yum!");
            return output;
        }
    }

