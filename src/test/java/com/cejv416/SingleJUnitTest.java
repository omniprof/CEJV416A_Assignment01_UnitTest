package com.cejv416;

import com.cejv416.cejv416a_assignment01_unittest.business.Calculator;
import com.cejv416.cejv416a_assignment01_unittest.data.FinanceBean;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;

/**
 *
 * @author omni_
 */
public class SingleJUnitTest {
    
    
    private FinanceBean fb;
    private Calculator calculator;

    @BeforeEach
    public void setUp() {
        fb = new FinanceBean();
        calculator = new Calculator();
    }

//    @Disabled
    public void testLoan() {
        fb.setLoanAmount(5000.0);
        fb.setInterestRate(0.05);
        fb.setTerm(60);
        calculator.doLoanPayment(fb);
        assertEquals(94.36, fb.getResult());
    }
    
    public void testFutureValue() {
        fb.setSavingsAmount(100.0);
        fb.setInterestRate(0.05);
        fb.setTerm(60);
        calculator.doFutureValue(fb);
        assertEquals(6800.61, fb.getResult());
    
    }

    public void testSavingsGoal() {
        fb.setFutureValue(6800.61);
        fb.setInterestRate(0.05);
        fb.setTerm(60);
        calculator.doSavingsGoal(fb);
        assertEquals(100.0, fb.getResult());
    
    }
}
