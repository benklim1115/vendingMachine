package com.techelevator.application;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class AuditLog {

    private static File logFile = new File("Log.txt");
//    private static File logFile = new


    public static void feedAudit(BigDecimal previousTotal, BigDecimal currentTotal) {
        //check the current time matches somehow for test
        LocalDateTime currentDateTime = LocalDateTime.now();
        DateTimeFormatter targetFormat = DateTimeFormatter.ofPattern("MM/dd/yyyy hh:mm:ss a");

        try (PrintWriter pw = new PrintWriter(new FileOutputStream(logFile, true))) {
            pw.println(currentDateTime.format(targetFormat) + " FEED MONEY: " + " $" + previousTotal + " $" + currentTotal);

        } catch (FileNotFoundException e) {
            System.out.println("Trouble with audit file");
            System.exit(1);
        }
    }

    public static void purchaseAudit(String name, String location, BigDecimal previousTotal, BigDecimal currentTotal) {
        LocalDateTime currentDateTime = LocalDateTime.now();
        DateTimeFormatter targetFormat = DateTimeFormatter.ofPattern("MM/dd/yyyy hh:mm:ss a");

        try (PrintWriter pw = new PrintWriter(new FileOutputStream(logFile, true))) {
            pw.println(currentDateTime.format(targetFormat) + " " + name + " " + location + " $" + previousTotal + " $" + currentTotal);

        } catch (FileNotFoundException e) {
            System.out.println("Trouble with audit file");
            System.exit(1);
        }
    }

    public static void changeAudit(BigDecimal previousTotal, BigDecimal currentTotal) {
        LocalDateTime currentDateTime = LocalDateTime.now();
        DateTimeFormatter targetFormat = DateTimeFormatter.ofPattern("MM/dd/yyyy hh:mm:ss a");

        try (PrintWriter pw = new PrintWriter(new FileOutputStream(logFile, true))) {
            pw.println(currentDateTime.format(targetFormat) + " GIVE CHANGE: " + " $" + previousTotal + " $" + currentTotal);

        } catch (FileNotFoundException e) {
            System.out.println("Trouble with audit file");
            System.exit(1);
        }
    }

}
