package model;


import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

/**
 * Created by brian on 15/12/16.
 */
public class CreditCardTest {

    private String testValidNumber = "4929766254319102";
    private String testInvalidNumber = "3556737586899855";
    private CreditCard creditCard;

    @org.junit.Before
    public void setUp() throws Exception {

        creditCard = new CreditCard();
    }

    @org.junit.Test
    public void validateCreditCardNumber() throws Exception {

        boolean result1 = creditCard.validateCreditCardNumber(testValidNumber);
        assertTrue(result1);

        boolean result2 = creditCard.validateCreditCardNumber(testInvalidNumber);
        assertFalse(result2);

    }

}