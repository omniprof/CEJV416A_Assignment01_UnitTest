package com.cejv416;

import com.cejv416.cejv416a_assignment01_unittest.business.Calculator;
import com.cejv416.cejv416a_assignment01_unittest.data.FinanceBean;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.aggregator.ArgumentsAccessor;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * Parameterized Unit Test for the Loan Payment calculation
 *
 * @author Ken Fogel
 */
public class ParameterJUnitTest {

    private FinanceBean fb;
    private Calculator calculator;

    /**
     * By using the @ParameterizedTest annotation we are declaring that the
     * tests must be run for each row in the @CsvSource
     */
    @ParameterizedTest
    @CsvSource({
        "5000, 0, 0, 0.05, 60, 94.36",
        "3000, 0, 0, 0.05, 24, 131.61",
        "20000, 0, 0, 0.05, 72, 322.10"
    })

    /**
     * Before each run of the test methods a new FinanceBean and a new
     * Calculator is instantiated.
     */
    @BeforeEach
    public void setUp() {
        fb = new FinanceBean();
        calculator = new Calculator();
    }

    /**
     * The ArgumentsAccessor is the list of values for each row. 
     *
     * @param args
     */
    public void knownValueLoanCalculationTest_parameterized(ArgumentsAccessor args) {
        fb = buildBean(args);
        calculator.doLoanPayment(fb);
        assertEquals(args.getDouble(5), fb.getResult());
    }

    /**
     * This method is called to create a FinanceBean based on the
     * ArgumentsAccessor
     *
     * @param args ArgumentsAccessor values
     * @return A new FinanceBean
     */
    private FinanceBean buildBean(ArgumentsAccessor args) {
        return new FinanceBean(args.getDouble(0),
                args.getDouble(1),
                args.getDouble(2),
                args.getDouble(3),
                args.getDouble(4)
        );
    }

}
