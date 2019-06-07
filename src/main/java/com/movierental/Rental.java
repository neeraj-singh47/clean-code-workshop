package com.movierental;

public class Rental {

  private int daysRented;
  private Movie movie;

  public Rental(Movie movie, int daysRented){
    this.movie = movie;
    this.daysRented = daysRented;
  }

  public int getDaysRented() {
    return daysRented;
  }

  public Movie getMovie() {
    return movie;
  }

  public double amountFor() {
    //determine amounts for each line
    double amount = 0;
    switch (this.movie.getPriceCode()) {
      case Movie.REGULAR:
        amount += 2;
        if (this.daysRented > 2)
          amount += (this.daysRented - 2) * 1.5;
        break;
      case Movie.NEW_RELEASE:
        amount += this.daysRented * 3;
        break;
      case Movie.CHILDRENS:
        amount += 1.5;
        if (this.daysRented > 3)
          amount += (this.daysRented - 3) * 1.5;
        break;
    }
    return amount;
  }

  public int pointsFor() {
    int frequentRenterPoints = 1;
    if (isBonusApplicable()) frequentRenterPoints++;
    return frequentRenterPoints;
  }

  public boolean isBonusApplicable() {
    return (this.movie.getPriceCode() == Movie.NEW_RELEASE) && this.getDaysRented() > 1;
  }
}