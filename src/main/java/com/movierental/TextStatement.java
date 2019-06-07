package com.movierental;

import java.util.List;

public class TextStatement {
    public String create(List<Rental> rentals, String customerName ) {
      double totalAmount = 0;
      int frequentRenterPoints = 0;
      String header = "Rental Record for " + customerName + "\n";
      String result = header;
      for (Rental each : rentals) {
        double thisAmount = each.amountFor();
        frequentRenterPoints += each.pointsFor();

        //show figures for this rental
        result += "\t" + each.getMovie().getTitle() + "\t" +
            String.valueOf(thisAmount) + "\n";
        totalAmount += thisAmount;
      }

      //add footer lines result
      result += "Amount owed is " + String.valueOf(totalAmount) + "\n";
      result += "You earned " + String.valueOf(frequentRenterPoints)
          + " frequent renter points";
      return result;
    }
}