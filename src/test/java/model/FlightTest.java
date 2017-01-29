package model;

import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by brian on 15/12/16.
 */
public class FlightTest {

    private Flight flight;
    private LocalDate now = LocalDate.now();
    private LocalDate afterNow = LocalDate.now().plusYears(1);
    private String saturday = String.valueOf(Day.SATURDAY);
    private String tuesday = String.valueOf(Day.TUESDAY);
    private final double FLIGHT_PRICE = 60.0;
    private final double FLIGHT_PRICE_PLUS_TWENTY_PERCENT = 72.0;


    @Before
    public void setUp() throws Exception {
        flight = new AdultFlight();
    }




    @Test
    public void isDateValid() throws Exception {
        assertEquals(true, flight.dateIsInvalid(afterNow, now));
    }


    @Test
    public void calculateExtraIfWeekend() throws Exception {
        assertEquals(FLIGHT_PRICE_PLUS_TWENTY_PERCENT, flight.calculateExtraForWeekend(saturday, FLIGHT_PRICE));
        assertEquals(FLIGHT_PRICE, flight.calculateExtraForWeekend(tuesday, FLIGHT_PRICE));
    }


}