package com.techelevator.models;

import com.techelevator.application.AuditLog;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Funds {
    public BigDecimal total;

    public Funds() {
        this.total = new BigDecimal("0");
    }


    public BigDecimal addFunds(BigDecimal fedMoney){
        BigDecimal previousTotal = this.total;
        this.total = this.total.add(fedMoney);
        AuditLog.feedAudit(previousTotal, this.total);
        return this.total;
    }


    public BigDecimal subtractFunds(BigDecimal itemPrice){
        this.total = this.total.subtract(itemPrice);
        return this.total;
    }


    public BigDecimal getTotal() {

        return total.setScale(2, RoundingMode.HALF_UP);

    }


    public String giveChange() {

        String returnString = "";
        BigDecimal previousTotal = this.total;

        this.total = this.total.multiply(new BigDecimal("100"));

        int quarters = this.total.divide(new BigDecimal("25")).intValue();
        this.total = this.total.subtract(BigDecimal.valueOf(quarters*25));

        if (quarters > 0) {
            returnString += "Returning " + quarters + " quarters\n";
        }


        int dimes = this.total.divide(new BigDecimal("10")).intValue();
        if (dimes > 0) {
            returnString += "Returning " + dimes + " dimes\n";
        }
        this.total = this.total.subtract(BigDecimal.valueOf(dimes*10));

        int nickels = this.total.divide(new BigDecimal("5")).intValue();
        if (nickels > 0) {
            returnString += "Returning " + nickels + " nickels";
        }
        this.total = this.total.subtract(BigDecimal.valueOf(nickels*5));
        AuditLog.changeAudit(previousTotal, this.total);

        return returnString;
    }

}
