package com.techelevator.application;

import static org.junit.Assert.*;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class AuditLogTest {

    // Add $10
    // Purchase A3 $2.75
    // Return Change

    @Test
    public void auditLogTest(){
        String expectedFeed = "11/19/2021 04:22:17 PM FEED MONEY:  $0 $10";
        String expectedPurchase = "11/19/2021 04:22:22 PM Grain Waves A3 $10.00 $7.25";
        String expectedChange =  "11/19/2021 04:22:24 PM GIVE CHANGE:  $7.25 $0.00";

        File logFile = new File("Log.txt");
        Scanner logScanner = null;
        try {
            logScanner = new Scanner(logFile);
        }catch(FileNotFoundException e){
            System.out.println("FAILED TEST");
        }

        int counter = 0;
        String[] actualStrings = new String[3];
        while(logScanner.hasNextLine() && counter <= 2){
           String currentLine = logScanner.nextLine();
           actualStrings[counter] = currentLine;
           counter++;
        }

        assertEquals(expectedFeed, actualStrings[0]);
        assertEquals(expectedPurchase, actualStrings[1]);
        assertEquals(expectedChange, actualStrings[2]);




    }
}
