package com.techelevator.models;

import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class GumTest {

    Item testGum = new Gum("Chiclets", new BigDecimal(".75"), 5);

    @Test
    public void dispenseItemTest() {
        String expectedString = "Chiclets $0.75";
        int expectedQuantity = 4;
        String actualString = testGum.dispenseItem();
        int actualQuantity = testGum.getQuantity();
        assertEquals(expectedQuantity, actualQuantity);
        assertEquals(expectedString, actualString);
    }

    @Test
    public void getNameTest(){
        String expectedName = "Chiclets";
        String actualName = testGum.getName();
        assertEquals(expectedName,actualName);
    }

    @Test
    public void getPriceTest(){
        BigDecimal expectedVal = new BigDecimal(".75");
        BigDecimal actualVal = testGum.getPrice();
        assertEquals(expectedVal, actualVal);
    }

    @Test
    public void getQuantityTest(){
        int expectedVal = 5;
        int actualVal = testGum.getQuantity();
        assertEquals(expectedVal,actualVal);
    }

    @Test
    public void toStringTest(){
        String expectedValFull = "Chiclets $0.75 number available: 5";
        String expectedValEmpty = "Chiclets $0.75 SOLD OUT";
        String actualValFull = testGum.toString();
        for(int i = 0; i<5; i++) {
            testGum.dispenseItem();
        }
        String actualValEmpty = testGum.toString();
        assertEquals(expectedValEmpty, actualValEmpty);
        assertEquals(expectedValFull, actualValFull);

    }





}