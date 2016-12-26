package model;

import helpers.Consts;
import org.junit.Before;
import org.junit.Test;
import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotSame;


/**
 * Created by brian on 18/12/16.
 */
public class InfantFlightTest {

    protected InfantFlight infantFlight;
    protected double validSingle = Consts.ZERO;
    protected double inValidSingle = Consts.ONE_HND;


    @Before
    public void setUp() throws Exception {
        infantFlight = new InfantFlight();
    }

    @Test
    public void setPriceSingle() throws Exception {
        assertEquals(validSingle, infantFlight.setPriceSingle());
        assertNotSame(inValidSingle, infantFlight.setPriceSingle());
    }

    @Test
    public void setPriceReturn() throws Exception {
        assertEquals(validSingle, infantFlight.setPriceReturn());
        assertNotSame(inValidSingle, infantFlight.setPriceReturn());
    }

}