package com.techelevator.models;

import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class DrinkTest {

    Item testDrink = new Drink("Cola", new BigDecimal("1.25"), 5 );

    @Test
    public void dispenseItem() {
        String expectedString = "Cola $1.25";
        int expectedQuantity = 4;
        String actualString = testDrink.dispenseItem();
        int actualQuantity = testDrink.getQuantity();
        assertEquals(expectedQuantity, actualQuantity);
        assertEquals(expectedString, actualString);
    }

    @Test
    public void getNameTest(){
        String expectedName = "Cola";
        String actualName = testDrink.getName();
        assertEquals(expectedName,actualName);
    }

    @Test
    public void getPriceTest(){
        BigDecimal expectedVal = new BigDecimal("1.25");
        BigDecimal actualVal = testDrink.getPrice();
        assertEquals(expectedVal, actualVal);
    }

    @Test
    public void getQuantityTest(){
        int expectedVal = 5;
        int actualVal = testDrink.getQuantity();
        assertEquals(expectedVal,actualVal);
    }

    @Test
    public void toStringTest(){
        String expectedValFull = "Cola $1.25 number available: 5";
        String expectedValEmpty = "Cola $1.25 SOLD OUT";
        String actualValFull = testDrink.toString();
        for(int i = 0; i<5; i++) {
            testDrink.dispenseItem();
        }
        String actualValEmpty = testDrink.toString();
        assertEquals(expectedValEmpty, actualValEmpty);
        assertEquals(expectedValFull, actualValFull);

    }

}