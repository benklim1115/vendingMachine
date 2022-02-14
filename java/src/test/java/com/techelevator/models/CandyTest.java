package com.techelevator.models;

import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class CandyTest {

    Item testCandy = new Candy("Moonpie", new BigDecimal("1.80"), 5);

    @Test
    public void dispenseItemTest() {
        String expectedString = "Moonpie $1.80";
        int expectedQuantity = 4;
        String actualString = testCandy.dispenseItem();
        int actualQuantity = testCandy.getQuantity();
        assertEquals(expectedQuantity, actualQuantity);
        assertEquals(expectedString, actualString);
    }

    @Test
    public void getNameTest(){
        String expectedName = "Moonpie";
        String actualName = testCandy.getName();
        assertEquals(expectedName,actualName);
    }

    @Test
    public void getPriceTest(){
        BigDecimal expectedVal = new BigDecimal("1.80");
        BigDecimal actualVal = testCandy.getPrice();
        assertEquals(expectedVal, actualVal);
    }

    @Test
    public void getQuantityTest(){
        int expectedVal = 5;
        int actualVal = testCandy.getQuantity();
        assertEquals(expectedVal,actualVal);
    }

    @Test
    public void toStringTest(){
        String expectedValFull = "Moonpie $1.80 number available: 5";
        String expectedValEmpty = "Moonpie $1.80 SOLD OUT";
        String actualValFull = testCandy.toString();
        for(int i = 0; i<5; i++) {
            testCandy.dispenseItem();
        }
        String actualValEmpty = testCandy.toString();
        assertEquals(expectedValEmpty, actualValEmpty);
        assertEquals(expectedValFull, actualValFull);

    }

}
