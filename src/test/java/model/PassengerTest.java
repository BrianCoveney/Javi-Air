package model;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

/**
 * Created by brian on 15/12/16.
 */
public class PassengerTest {
    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void validateDNINumber() throws Exception {

        Passenger passenger1 = new Passenger("00000010-X");
        boolean result1 = passenger1.validateDNINumber();

        assertTrue(result1);



        Passenger passenger2 = new Passenger("12345678-a");
        boolean result2 = passenger2.validateDNINumber();

        assertFalse(result2);

    }

}