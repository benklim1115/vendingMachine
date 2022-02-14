package com.techelevator.ui;

import com.techelevator.models.Funds;
import com.techelevator.models.Item;

import java.math.BigDecimal;
import java.util.*;

/**
 * Responsibilities: This class should handle receiving ALL input from the User
 * 
 * Dependencies: None
 */
public class UserInput {
    private static Scanner scanner = new Scanner(System.in);

    public static String getHomeScreenOption() {
        System.out.println("What would you like to do?");
        System.out.println();

        System.out.println("1) Display Vending Machine Items");
        System.out.println("2) Purchase");
        System.out.println("3) Exit");

        System.out.println();
        System.out.print("Please select an option: ");

        String selectedOption = scanner.nextLine();
        String option = selectedOption.trim().toLowerCase();

        if (option.equals("1")) {
            return "display";
        } else if (option.equals("2")) {
            return "purchase";
        } else if (option.equals("3")) {
            return "exit";
        } else if (option.equals("4")){
            return "Sales";
        } else {
            return "";
        }

    }

    public static String getPurchaseOptions(Funds funds) {

        System.out.println("Purchase menu: ");
        System.out.println();

        System.out.println("1) Feed Money");
        System.out.println("2) Select Product");
        System.out.println("3) Finish Transaction");
        System.out.println("\nCurrent Money Provided: $" + funds.getTotal());

        System.out.println();
        System.out.print("Please select an option: ");

        String selectedOption = scanner.nextLine();
        String option = selectedOption.trim();

        if (option.equals("1")) {
            return "Feed";
        } else if (option.equals("2")) {
            return "Select";
        } else if (option.equals("3")) {
            return "Finish";
        } else {
            return "";
        }
    }

    public static BigDecimal getFeed() {

        System.out.println("Please enter money into the machine: ");
        String moneyEntered = scanner.nextLine();
        BigDecimal feedMoney = null;
        try {
            feedMoney = new BigDecimal(moneyEntered);
        } catch (NumberFormatException e){
            return new BigDecimal("0");
        }
        return feedMoney;
    }

    public static String getFeedOptions() {
        System.out.println("Feed Menu\n");

        System.out.println("1) Add Additional Funds");
        System.out.println("2) Return to Purchase Menu");

        String selectedOption = scanner.nextLine();
        String option = selectedOption.trim();

        if (option.equals("1")) {
            return "Feed";
        } else if (option.equals("2")) {
            return "Finish";
        } else {
            return "";
        }
    }

    public static String getSelectOptions() {
        System.out.println("Enter product code: ");

        String selectedOption = scanner.nextLine();
        String option = selectedOption.trim();
        return option;
    }
}
