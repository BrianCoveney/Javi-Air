package model;


import helpers.Consts;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

/**
 * Created by brian on 15/12/16.
 */
public class CreditCardTest {

    protected String testValidNumber = Consts.CREDIT_VALID_VALID_NO;
    protected String testInvalidNumber = Consts.CREDIT_INVALID_VALID_NO;
    protected CreditCard creditCard;

    @org.junit.Before
    public void setUp() throws Exception {

        creditCard = new CreditCard();
    }

    @org.junit.Test
    public void validateCreditCardNumber() throws Exception {
        assertTrue(creditCard.validateCreditCardNumber(testValidNumber));
        assertFalse(creditCard.validateCreditCardNumber(testInvalidNumber));
    }

}