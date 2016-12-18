package model;

import helpers.Consts;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.time.Month;
import java.time.Year;

import static junit.framework.TestCase.*;

/**
 * Created by brian on 15/12/16.
 */
public class PassengerTest {

    protected Passenger passenger1, passenger2, passenger3, passenger4, passenger5;
    protected String validDNI = "00000010-X";
    protected String inValidDNI = "12345678-a";
    protected LocalDate validDate = LocalDate.now();
    protected String validFirstName = "Brian";
    protected String inValidFirstName = "111";
    protected String inValidFirstName2 = "brian"; // first letter must be a capital letter
    protected String validLastName = "Coveney";
    protected String inValidLastName = "11Coveney";
    protected LocalDate over18, infant, child, over5;


    @Before
    public void setUp() throws Exception {

        over18 = Year.now().minusYears(18).atMonth(Month.SEPTEMBER).atDay(12);
        over5 = LocalDate.now().minusYears(6);
        infant = LocalDate.now().minusMonths(9);
        child = LocalDate.now().minusYears(4);

        passenger1 = new Passenger(validDNI);
        passenger1.setDateOfBirth(child);

        passenger2 = new Passenger(inValidDNI);
        passenger2.setDateOfBirth(infant);

        passenger3 = new Passenger();
        passenger3.setFirstName(inValidFirstName2);
        passenger3.setDateOfBirth(over18);

        passenger4 = new Passenger(validFirstName, validLastName,
                validDNI, over5, true, true); // selected

        passenger5 = new Passenger(inValidFirstName, inValidLastName,
                inValidDNI, validDate, false, false); // not selected

    }

    @Test
    public void isPassengerAChild() throws Exception {
        assertEquals(true, passenger1.isPassengerAChild());
    }

    @Test
    public void isPassengerInfant() throws Exception {
        assertEquals(true, passenger2.isPassengerInfant());
    }

    @Test
    public void isPassengerOver18() throws Exception {
        assertEquals(true, passenger3.isPassengerOver18());
    }

    @Test
    public void isPassengerOver5() throws Exception {
        assertEquals(true, passenger4.isPassengerOver5());
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
        assertEquals(Consts.SPANISH_REBATE, passenger4.spanishRebateValue());
        assertNotSame(Consts.SPANISH_REBATE, passenger5.spanishRebateValue()); // not selected
    }

    @Test
    public void setBaggagePriceSingle() throws Exception {
        assertEquals(Consts.BAGGAGE_PRICE, passenger4.setBaggagePriceSingle());
    }


    @Test
    public void setBaggagePriceReturn() throws Exception {
        assertEquals(Consts.BAGGAGE_PRICE * 2, passenger4.setBaggagePriceReturn());
    }

    @Test
    public void validateFirstName() throws Exception {
        assertEquals(true, passenger4.validateFirstName(validFirstName));
        assertEquals(false, passenger5.validateFirstName(inValidFirstName));
        assertEquals(false, passenger3.validateFirstName(inValidFirstName2));

    }

    @Test
    public void validateLastName() throws Exception {
        assertEquals(true, passenger4.validateLastName(validFirstName));
        assertEquals(false, passenger5.validateLastName(inValidFirstName));
    }
}



























