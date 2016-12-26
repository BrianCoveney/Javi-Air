package model;

import helpers.Consts;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by brian on 26/12/16.
 */
public class FlightTimesTest {

    private FlightTimes flightTimes;
    private String flightTime1;
    private String flightTime2;
    private String flightDept;
    private String flightRtn;


    @Before
    public void setUp() throws Exception {

        flightTimes = new FlightTimes(Consts.ORK_CDG_1, Consts.ORK_CDG_2);
        flightTime1 = Consts.ORK_CDG_1;
        flightTime2 = Consts.ORK_CDG_2;
        flightDept = Consts.CORK;
        flightRtn = Consts.PARIS;
    }

    @Test
    public void getFlightTimes() throws Exception {
        assertNotNull(flightTimes);
        assertEquals(true, flightTimes instanceof FlightTimes);
    }


}