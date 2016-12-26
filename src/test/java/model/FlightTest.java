package model;

import helpers.Consts;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotSame;

/**
 * Created by brian on 15/12/16.
 */
public class FlightTest {

    private Flight flight, flight2;
    private LocalDate now = LocalDate.now();
    private LocalDate afterNow = LocalDate.now().plusYears(1);
    private LocalDate beforeNow = LocalDate.now().minusYears(1);


    @Before
    public void setUp() throws Exception {
        flight = new AdultFlight();
        flight2 = new AdultFlight();
    }


    @Test
    public void flightPrice() throws Exception {
        assertEquals(Consts.ONE_HND, flight.flightSelection(Consts.CORK, Consts.MADRID));
        assertNotSame(Consts.ONE_HND, flight2.flightSelection(Consts.CORK, Consts.MADRID)); // should be 120.0
    }

    @Test
    public void isDateValid() throws Exception {
        assertEquals(true, flight.isDateValid(now, afterNow));
        assertEquals(false, flight.isDateValid(now, beforeNow));
    }



    @Test
    public void isWeekend() throws Exception {
        assertEquals(true, flight.isWeekend(Consts.SAT));
        assertEquals(false, flight.isWeekend(Consts.TUE));
    }

}