package com.cejv416.cejv416a_assignment01_unittest.business;

import com.cejv416.cejv416a_assignment01_unittest.data.FinanceBean;

/**
 *
 * @author omni_
 */
public class Calculator {
    /**
     * Calculate the monthly loan payment
     *
     * @param fb FinanceBean with the user input and where the answer will go
     */
    public void doLoanPayment(FinanceBean fb) {
        var ir = fb.getInterestRate()/12.0;
        double result = fb.getLoanAmount() * (ir / (1 - Math.pow(1 + ir, -fb.getTerm())));
        System.out.println("result = " + result);
        fb.setResult(doRounding(result));
    }

    /**
     * Calculate how much money to save each month to reach a goal
     *
     * @param fb FinanceBean with the user input and where the answer will go
     */
    public void doFutureValue(FinanceBean fb) {
        var ir = fb.getInterestRate()/12.0;
        double result = fb.getSavingsAmount() * ((1 - Math.pow(1 + ir, fb.getTerm()))/ir);
        System.out.println("result = " + result);
        fb.setResult(doRounding(result));
    }

    /**
     * Calculate how much you need to save to reach specific goal each month
     *
     * @param fb FinanceBean with the user input and where the answer will go
     */
    public void doSavingsGoal(FinanceBean fb) {
        var ir = fb.getInterestRate()/12.0;
        double result = fb.getFutureValue() * (ir/(1 - Math.pow(1 + ir, fb.getTerm())));
        System.out.println("result = " + result);
        fb.setResult(doRounding(result));
    }
    
    private double doRounding(double result) {
        result = Math.round(result * 100);
        result /= 100;
        return Math.abs(result);
    }
    
}
