package com.techelevator.application;

import com.techelevator.models.*;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.*;

import static org.junit.Assert.*;

public class VendingMachineScannerTest {

    VendingMachine vendingTest = new VendingMachine();

    @Test
    public void fillVendingMachineTest() {

        Map<String, Item> itemMap = vendingTest.fillVendingMachine();
        List<String> keys = new ArrayList<>(itemMap.keySet());
        //A1
        String expectedChipName = "Potato Crisps";
        //B1
        BigDecimal expectedCandyPrice = new BigDecimal("1.80");
        //C1
        int expectedDrinkQ = 5;
        //D1
        String expectedGumName = "U-Chews";

        String actualChipName = itemMap.get("A1").getName();
        BigDecimal actualCandyPrice = itemMap.get("B1").getPrice();
        int actualDrinkQ = itemMap.get("C1").getQuantity();
        String actualGumName = itemMap.get("D1").getName();

        assertEquals(expectedChipName, actualChipName);
        assertEquals(expectedDrinkQ, actualDrinkQ);
        assertEquals(expectedGumName, actualGumName);
        assertEquals(expectedCandyPrice, actualCandyPrice);



    }

}