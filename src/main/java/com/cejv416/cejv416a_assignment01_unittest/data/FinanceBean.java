package com.cejv416.cejv416a_assignment01_unittest.data;

/**
 * Java Bean for assignment 1 finance calculator
 *
 * @author Ken Fogel
 */
public class FinanceBean {

    private double loanAmount;
    private double savingsAmount;
    private double futureValue;
    private double interestRate;
    private double term;
    private double result;

    /**
     * Default constructor so that this class can be instantiated without any
     * initial values. The setters will need to be used.
     */
    public FinanceBean() {
    }
    
    // FinanceBean bob = new FinanceBean();
    // FinanceBean bob = new FinanceBean(5000,0,0, 0.05, 60)

    /**
     * Non-default constructor that allows the class to be instantiated with
     * initial values rather than use the setter methods.
     *
     * @param loanAmount
     * @param savingsAmount
     * @param futureValue
     * @param interestRate
     * @param term
     */
    public FinanceBean(double loanAmount, double savingsAmount, double futureValue, double interestRate, double term) {
        this.loanAmount = loanAmount;
        this.savingsAmount = savingsAmount;
        this.futureValue = futureValue;
        this.interestRate = interestRate;
        this.term = term;
    }

    public double getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(double loanAmount) {
        this.loanAmount = loanAmount;
    }

    public double getSavingsAmount() {
        return savingsAmount;
    }

    public void setSavingsAmount(double savingsAmount) {
        this.savingsAmount = savingsAmount;
    }

    public double getFutureValue() {
        return futureValue;
    }

    public void setFutureValue(double futureValue) {
        this.futureValue = futureValue;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public double getTerm() {
        return term;
    }

    public void setTerm(double term) {
        this.term = term;
    }

    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("FinanceBean{");
        sb.append("loanAmount=").append(loanAmount);
        sb.append(", savingsAmount=").append(savingsAmount);
        sb.append(", futureValue=").append(futureValue);
        sb.append(", interestRate=").append(interestRate);
        sb.append(", term=").append(term);
        sb.append(", result=").append(result);
        sb.append('}');
        return sb.toString();
    }


}
