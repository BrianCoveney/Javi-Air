package model;

import helpers.Consts;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotSame;


/**
 * Created by brian on 18/12/16.
 */
public class ChildFlightTest {

    protected ChildFlight childFlight;
    protected double validSingle = Consts.SIXTY;
    protected double inValidSingle = Consts.TWO_HND;
    protected double validReturn = Consts.ONE_HND_TWENTY;
    protected double inValidReturn = Consts.ZERO;

    @Before
    public void setUp() throws Exception {
        childFlight = new ChildFlight();
    }

    @Test
    public void setPriceSingle() throws Exception {
        assertEquals(validSingle, childFlight.setPriceSingle());
        assertNotSame(inValidSingle, childFlight.setPriceSingle());
    }

    @Test
    public void setPriceReturn() throws Exception {
        assertEquals(validReturn, childFlight.setPriceReturn());
        assertNotSame(inValidReturn, childFlight.setPriceReturn());

    }

}