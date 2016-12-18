package model;

import org.junit.Before;
import org.junit.Test;
import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotSame;


/**
 * Created by brian on 18/12/16.
 */
public class InfantFlightTest {

    protected InfantFlight infantFlight;
    protected double validSingle = 0.0;
    protected double inValidSingle = 5.0;


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