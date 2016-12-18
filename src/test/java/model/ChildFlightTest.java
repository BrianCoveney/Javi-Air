package model;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;


/**
 * Created by brian on 18/12/16.
 */
public class ChildFlightTest {

    protected ChildFlight childFlight;
    protected double validSingle = 60.0;
    protected double validReturn = 120.0;

    @Before
    public void setUp() throws Exception {
        childFlight = new ChildFlight();
    }

    @Test
    public void setPriceSingle() throws Exception {
        assertEquals(validSingle, childFlight.setPriceSingle());
    }

    @Test
    public void setPriceReturn() throws Exception {
        assertEquals(validReturn, childFlight.setPriceReturn());

    }

}