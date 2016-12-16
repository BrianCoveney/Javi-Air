package model;

import helpers.Consts;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

/**
 * Created by brian on 15/12/16.
 */
public class PassengerTest {

    Passenger passenger1;
    Passenger passenger2;
    Passenger passenger3;

    @Before
    public void setUp() throws Exception {
        passenger1 = new Passenger("00000010-X");
        passenger2 = new Passenger("12345678-a");
        passenger3 = new Passenger();

    }

    @Test
    public void validateDNINumber() throws Exception {

        boolean result1 = passenger1.validateDNINumber();
        assertTrue(result1);

        boolean result2 = passenger2.validateDNINumber();
        assertFalse(result2);
    }


    @Test
    public void spanishRebateValue() throws Exception {

        assertEquals(Consts.NO_SPANISH_REBATE, passenger1.spanishRebateValue());

    }

}