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


    private Flight flight;
    private LocalDate now = LocalDate.now();
    private LocalDate afterNow = LocalDate.now().plusYears(1);
    private LocalDate beforeNow = LocalDate.now().minusYears(1);



    @Before
    public void setUp() throws Exception {
        this.flight = new AdultFlight();
    }

    @Test
    public void getFlightPrice() throws Exception {
        boolean result1 = flight.isDateInvalid(now, afterNow);
        assertTrue(result1);
    }

    @Test
    public void checkInvalidDates() throws Exception {
        assertEquals(true, flight.isDateInvalid(now, afterNow));

        // cannot book return flight, before depart flight time
        assertEquals(false, flight.isDateInvalid(now, beforeNow));

    }

    @Test
    public void isWeekend() throws Exception {
        assertEquals(true, flight.isWeekend(Consts.SAT));
        assertEquals(false, flight.isWeekend(Consts.TUE));
    }

}