package model;

import helpers.Consts;
import org.junit.Before;
import org.junit.Test;
import static junit.framework.TestCase.assertEquals;


/**
 * Created by brian on 18/12/16.
 */
public class AdultFlightTest {

    protected AdultFlight adultFlight;
    protected double validSingle = Consts.ZERO;

    @Before
    public void setUp() throws Exception {
        adultFlight = new AdultFlight();
    }

    @Test
    public void setPriceSingle() throws Exception {
        assertEquals(validSingle, adultFlight.setPriceSingle());
    }

    @Test
    public void setPriceReturn() throws Exception {
        assertEquals(validSingle, adultFlight.setPriceReturn());

    }

}