package model;

import helpers.Consts;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.time.Month;
import java.time.Year;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotSame;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.core.IsEqual.equalTo;

/**
 * Created by brian on 15/12/16.
 */
public class PassengerTest {



    protected Passenger passenger, passenger2, passenger3, passenger4, passenger5, passenger6;
    protected String validDNI = Consts.SPANISH_VALID_DNI;
    protected String inValidDNI = Consts.SPANISH_INVALID_DNI;
    protected String validFirstName = "Brian";
    protected String inValidFirstName = "111";
    protected String validLastName = "Coveney";
    protected String inValidLastName = "11Coveney";
    protected String dob;
    protected LocalDate over18, infant, child, over5, genericDate;
    protected double spanishRebate;
    double x;



    @Before
    public void setUp() throws Exception {

        over18 = LocalDate.now().minusYears(20);
        over5 = LocalDate.now().minusYears(6);
        infant = LocalDate.now().minusMonths(9);
        child = LocalDate.now().minusYears(4);
        genericDate = Year.now().minusYears(18).atMonth(Month.SEPTEMBER).atDay(12);

        passenger = new Passenger();
        passenger.setNumberDNI(validDNI);
        passenger.setDateOfBirth(child);
        passenger.setSpanishSelected(true);

        passenger2 = new Passenger();
        passenger2.setNumberDNI(inValidDNI);
        passenger2.setDateOfBirth(infant);
        passenger2.setNumberDNI(Consts.SPANISH_INVALID_DNI);

        passenger3 = new Passenger();
        passenger3.setDateOfBirth(over18);

        passenger4 = new Passenger(validFirstName, validLastName,
                validDNI, over5, true, true); // selected

        passenger5 = new Passenger(inValidFirstName, inValidLastName,
                inValidDNI, genericDate, false, false); // not selected


    }


    @Test
    public void setSpaRebate() throws Exception {
        assertThat(Consts.SPANISH_REBATE_DOUBLED, is(passenger.setSpaRebate(Consts.MADRID, Consts.MALAGA)));
        assertThat(Consts.SPANISH_REBATE, not(passenger.setSpaRebate(Consts.MADRID, Consts.MALAGA)));
        assertThat(Consts.SPANISH_REBATE, is(passenger.setSpaRebate(Consts.MALAGA, Consts.MADRID)));
        assertThat(Consts.ZERO, is(passenger.setSpaRebate(Consts.CORK, Consts.PARIS)));
    }


    @Test
    public void isPassengerAChild() throws Exception {
        assertEquals(true, passenger.isPassengerAChild());
        assertEquals(false, passenger3.isPassengerAChild());
    }

    @Test
    public void isPassengerInfant() throws Exception {
        assertEquals(true, passenger2.isPassengerInfant());
        assertEquals(false, passenger3.isPassengerInfant());

    }

    @Test
    public void isPassengerOver18() throws Exception {
        assertEquals(true, passenger3.isPassengerOver18());
        assertEquals(false, passenger.isPassengerOver18());

    }

    @Test
    public void isPassengerOver5() throws Exception {
        assertEquals(true, passenger4.isPassengerOver5());
        assertEquals(false, passenger2.isPassengerOver5());

    }

    @Test
    public void validateDNINumber() throws Exception {
        assertThat(passenger.validateDNINumber(), is(true));
        assertThat(passenger2.validateDNINumber(), is(not(equalTo(true))));

    }

    @Test
    public void spanishRebateValue() throws Exception {
        assertEquals(Consts.SPANISH_REBATE, passenger4.spanishRebateValue());
        assertNotSame(Consts.SPANISH_REBATE, passenger5.spanishRebateValue()); // not selected
        assertThat(passenger4.spanishRebateValue(), equalTo(Consts.SPANISH_REBATE));
    }

    @Test
    public void setBaggagePriceSingle() throws Exception {
        assertEquals(Consts.BAGGAGE_PRICE, passenger4.setBaggagePriceSingle());
        assertThat(passenger4.setBaggagePriceSingle(), equalTo(Consts.BAGGAGE_PRICE));
    }


    @Test
    public void setBaggagePriceReturn() throws Exception {
        assertEquals(Consts.BAGGAGE_PRICE_RETURN, passenger4.setBaggagePriceReturn());
        assertThat(passenger4.setBaggagePriceReturn(), equalTo(Consts.BAGGAGE_PRICE_RETURN));
    }

    @Test
    public void validateFirstName() throws Exception {
        assertEquals(true, passenger4.validateFirstName(validFirstName));
        assertEquals(false, passenger5.validateFirstName(inValidFirstName));;
        assertThat(passenger4.validateFirstName(validFirstName), is(true));

    }

    @Test
    public void validateLastName() throws Exception {
        assertEquals(true, passenger4.validateLastName(validFirstName));
        assertEquals(false, passenger5.validateLastName(inValidFirstName));
        assertThat(passenger4.validateLastName(validLastName), equalTo(true));

    }
}
