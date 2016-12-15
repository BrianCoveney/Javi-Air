package model;

import helpers.Consts;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

/**
 * Created by brian on 15/12/16.
 */
public class FlightTest {

    private LocalDate now = LocalDate.now();
    private LocalDate afterNow = LocalDate.now().plusYears(1);
    private LocalDate beforeNow = LocalDate.now().minusYears(1);
    private Flight flight;
    private double validDouble = 100.0;
    private double inValidDouble = Consts.TWO_HND;

    @Before
    public void setUp() throws Exception {
        this.flight = new Flight();
    }

    @Test
    public void getFlightPrice() throws Exception {
        boolean result1 = flight.checkInvalidDates(now, afterNow);
        assertTrue(result1);
    }

    @Test
    public void checkInvalidDates() throws Exception {

        assertEquals(true, flight.checkInvalidDates(now, afterNow));

        // cannot book return flight, before depart flight time
        assertEquals(false, flight.checkInvalidDates(now, beforeNow));


    }

}