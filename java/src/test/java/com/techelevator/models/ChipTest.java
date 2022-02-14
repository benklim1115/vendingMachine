package com.techelevator.models;

import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class ChipTest {

    Item testChip = new Chip("Stackers", new BigDecimal("1.45"), 5);

    @Test
    public void dispenseItemTest() {
        String expectedString = "Stackers $1.45";
        int expectedQuantity = 4;
        String actualString = testChip.dispenseItem();
        int actualQuantity = testChip.getQuantity();
        assertEquals(expectedQuantity, actualQuantity);
        assertEquals(expectedString, actualString);
    }

    @Test
    public void getNameTest(){
        String expectedName = "Stackers";
        String actualName = testChip.getName();
        assertEquals(expectedName,actualName);
    }

    @Test
    public void getPriceTest(){
        BigDecimal expectedVal = new BigDecimal("1.45");
        BigDecimal actualVal = testChip.getPrice();
        assertEquals(expectedVal, actualVal);
    }

    @Test
    public void getQuantityTest(){
        int expectedVal = 5;
        int actualVal = testChip.getQuantity();
        assertEquals(expectedVal,actualVal);
    }

    @Test
    public void toStringTest(){
        String expectedValFull = "Stackers $1.45 number available: 5";
        String expectedValEmpty = "Stackers $1.45 SOLD OUT";
        String actualValFull = testChip.toString();
        for(int i = 0; i<5; i++) {
            testChip.dispenseItem();
        }
        String actualValEmpty = testChip.toString();
        assertEquals(expectedValEmpty, actualValEmpty);
        assertEquals(expectedValFull, actualValFull);

    }





}