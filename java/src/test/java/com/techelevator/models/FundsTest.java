package com.techelevator.models;

import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class FundsTest {

    private Funds testFund = new Funds();

//    @Before
//    public void setup(){

//    }

    @Test
    public void addFunds() {
        BigDecimal expectedValue = new BigDecimal("20");
        BigDecimal actualValue = testFund.addFunds(new BigDecimal("20"));
        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void subtractFunds() {
        BigDecimal expectedValue = new BigDecimal("10");
        testFund.addFunds(new BigDecimal("20"));
        BigDecimal actualValue = testFund.subtractFunds(new BigDecimal("10"));
        assertEquals(expectedValue, actualValue);

    }

    @Test
    public void getTotal() {
        testFund.addFunds(new BigDecimal("10"));
        BigDecimal expectedValue = new BigDecimal("10").setScale(2);
        BigDecimal actualValue = testFund.getTotal();
        assertEquals(expectedValue,actualValue);

    }

    @Test
    public void giveChange() {
        testFund.addFunds(new BigDecimal("7.90"));
        String expectedValue = "Returning 31 quarters\n" + "Returning 1 dimes\n" + "Returning 1 nickels";
        String actualValue = testFund.giveChange();
        assertEquals(expectedValue, actualValue);
    }
}