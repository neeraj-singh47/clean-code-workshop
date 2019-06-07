package com.movierental;

import java.util.List;

public class HTMLStatement {
    public String create(List<Rental> rentals, String customerName ) {
        double totalAmount = 0;
        int frequentRenterPoints = 0;
        String header = "<h1>Rental Record for <b>" + customerName + "</b></h1><br/>";
        String result = header;
        for (Rental each : rentals) {
          double thisAmount = each.amountFor();
          frequentRenterPoints += each.pointsFor();
    
          //show figures for this rental
          result += " " + each.getMovie().getTitle() + " <b>" +
              String.valueOf(thisAmount) + "</b><br/>";
          totalAmount += thisAmount;
        }
    
        //add footer lines result
        result += "Amount owed is " + String.valueOf(totalAmount) + "<br/>";
        result += "You earned <b>" + String.valueOf(frequentRenterPoints)
            + "</b> frequent renter points";
        return result;
    }
}