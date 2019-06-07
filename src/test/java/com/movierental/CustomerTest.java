package com.movierental;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import org.junit.Before;

public class CustomerTest {
    Customer test;
    Movie    movie1, movie2;
    Rental   rent1, rent2;
    String   message;
    int      totalAmount, totalPoints;
    List<Rental> rents = new ArrayList<>();

    @Before
    public void setUp(){
        test       = new Customer("Test");
        movie1     = new Movie("movie1", 100);
        movie2     = new Movie("movie2", 200);
        rent1      = new Rental(movie1, 20);
        rent2      = new Rental(movie2, 30);
        test.addRental(rent1);
        test.addRental(rent2);
    }
    
    // Characterisation test
    @Test
    public void statementShouldReturnAsText() {
        
        assertEquals("Rental Record for Test\n" +
            "\tmovie1\t0.0\n" +
            "\tmovie2\t0.0\n" +
            "Amount owed is 0.0\n" + "You earned 2 frequent renter points", test.statement());

    }

    // Test Total Amount
    // Characterisation test
    @Test
    public void statementShouldReturnAsHtml() {
        
        assertEquals("<h1>Rental Record for <b>Test</b></h1><br/>" +
            " movie1 <b>0.0</b><br/>" +
            " movie2 <b>0.0</b><br/>" +
            "Amount owed is 0.0<br/>" + "You earned <b>2</b> frequent renter points", test.htmlStatement());

    }
}