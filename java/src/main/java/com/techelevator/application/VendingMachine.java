package com.techelevator.application;

import com.techelevator.models.Funds;
import com.techelevator.models.*;
import com.techelevator.ui.UserInput;
import com.techelevator.ui.UserOutput;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

public class VendingMachine {



    public void run() {
        Map<String, Item> itemMap = fillVendingMachine();

        while (true) {
            UserOutput.displayHomeScreen();
            String choice = UserInput.getHomeScreenOption();

            if (choice.equals("display")) {
                List<String> itemLocations = new ArrayList<>(itemMap.keySet());
                Collections.sort(itemLocations);
                for (String location : itemLocations) {
                    Item currentItem = itemMap.get(location);
                    System.out.println(location + "| " + currentItem);
                }
            } else if (choice.equals("purchase")) {
                Funds funds = new Funds();
                handlePurchaseMenu(funds, itemMap);
            } else if (choice.equals("Sales")) {

                salesReport(itemMap);
            } else if (choice.equals("exit")) {
                // good bye
                break;
            }
        }
    }

    public void salesReport(Map<String, Item> itemMap) {
        List<String> itemLocations = new ArrayList<>(itemMap.keySet());

        for (String location : itemLocations) {
            File logToRead = new File("Log.txt");
            Scanner logReader = null;
            try {
                logReader = new Scanner(logToRead);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            int counter = 0;
            while (logReader.hasNextLine()) {
                String currentLine = logReader.nextLine();
                if (currentLine.contains(location)) {
                    counter += 1;
                }
            }
            BigDecimal totalSales = itemMap.get(location).getPrice().multiply(BigDecimal.valueOf(counter));
            System.out.println(itemMap.get(location).getName() + "  $" + totalSales);
        }
    }

    public void handlePurchaseMenu(Funds funds, Map<String, Item> itemMap) {

        boolean keepGoing = true;
        do {
            String choice = UserInput.getPurchaseOptions(funds);
            if (choice.equals("Feed")) {
                handleFeedMenu(funds);
            } else if (choice.equals("Select")) {
                handleSelectMenu(funds, itemMap);
            } else if (choice.equals("Finish")) {
                System.out.println(funds.giveChange());
                keepGoing = false;
            }

        } while (keepGoing);

    }

    public void handleFeedMenu(Funds funds) {

        BigDecimal fundsToAdd = UserInput.getFeed();
        funds.addFunds(fundsToAdd);
        boolean keepGoing = true;
        do {
            System.out.println("Current Money Provided: $" + funds.getTotal());
            String choice = UserInput.getFeedOptions();
            if (choice.equals("Feed")) {
                fundsToAdd = UserInput.getFeed();
                funds.addFunds(fundsToAdd);
            } else if (choice.equals("Finish")) {
                keepGoing = false;
            }

        } while (keepGoing);

    }

    public void handleSelectMenu(Funds funds, Map<String, Item> itemMap) {
        List<String> itemLocations = new ArrayList<>(itemMap.keySet());
        Collections.sort(itemLocations);
        for (String location : itemLocations) {
            Item currentItem = itemMap.get(location);
            System.out.println(location + "| " + currentItem);
        }
        String option = UserInput.getSelectOptions();

        if (!itemLocations.contains(option)) {
            System.out.println("Invalid Product Code");
        } else if (funds.getTotal().compareTo(itemMap.get(option).getPrice()) == -1) {
            System.out.println("Insufficient Funds");
        } else if (itemMap.get(option).getQuantity() == 0) {
            System.out.println(" SOLD OUT");
        } else {
            BigDecimal tempCurrentTotal = funds.getTotal();
            funds.subtractFunds(itemMap.get(option).getPrice());
            AuditLog.purchaseAudit(itemMap.get(option).getName(), option, tempCurrentTotal, funds.getTotal());
            String outMessage = itemMap.get(option).dispenseItem() + " Current Balance: $" + funds.getTotal();
            System.out.println(outMessage);
        }
    }

    //Method to make all vendingMachine csv instances and pass back Map
    public Map<String, Item> fillVendingMachine() {
        Map<String, Item> itemsMap = new HashMap<>();

        File file = new File("vendingmachine.csv");
        Scanner fileReader = null;
        try {
            fileReader = new Scanner(file);
        } catch (FileNotFoundException e) {
            System.out.println("VENDING MACHINE ERROR");
            System.exit(1);
        }

        while (fileReader.hasNextLine()) {
            String currentLine = fileReader.nextLine();
            String[] parsedCurrentLine = currentLine.split("\\|");

            String tempName = parsedCurrentLine[1];
            BigDecimal tempPrice = new BigDecimal(parsedCurrentLine[2]);
            int tempStock = Integer.parseInt(parsedCurrentLine[4]);
            Item tempItem = null;

            if (parsedCurrentLine[3].equals("Chip")) {
                tempItem = new Chip(tempName, tempPrice, tempStock);
                itemsMap.put(parsedCurrentLine[0], tempItem);
            } else if (parsedCurrentLine[3].equals("Candy")) {
                tempItem = new Candy(tempName, tempPrice, tempStock);
                itemsMap.put(parsedCurrentLine[0], tempItem);
            } else if (parsedCurrentLine[3].equals("Drink")) {
                tempItem = new Drink(tempName, tempPrice, tempStock);
                itemsMap.put(parsedCurrentLine[0], tempItem);
            } else if (parsedCurrentLine[3].equals("Gum")) {
                tempItem = new Gum(tempName, tempPrice, tempStock);
                itemsMap.put(parsedCurrentLine[0], tempItem);
            }
        }

        return itemsMap;
    }
}
