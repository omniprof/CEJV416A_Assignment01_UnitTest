package com.cejv416.cejv416a_assignment01_unittest.ui;

import com.cejv416.cejv416a_assignment01_unittest.business.Calculator;
import com.cejv416.cejv416a_assignment01_unittest.data.FinanceBean;
import java.util.Scanner;

/**
 * After selecting the calculation to use, all user input is collected in this
 * class and stored in a FinanceBean. This bean is passed to the appropriate
 * method in Calculator where the result is stored. The result from the
 * FinanceBean is displayed.
 *
 * @author Ken Fogel
 */
public class UserInterface {

    private FinanceBean fb;
    private final Scanner sc;

    /**
     * Constructor to initialize the Scanner object
     */
    public UserInterface() {
        sc = new Scanner(System.in);
    }

    /**
     * Show the menu
     */
    private void displayMenuText() {
        System.out.println("Please enter the letter for one of the following:");

        System.out.println("A. Loan Payment");
        System.out.println("B. Future Value");
        System.out.println("C. Savings Goal");
        System.out.println("D. Exit");
    }

    /**
     * Retrieve user menu choice, validating that it falls in the range,
     * inclusive of A,B,C,D
     *
     * @return user choice as a char
     */
    public char menu() {

        char choice;

        do {
            displayMenuText();
            // Validate with a regular expression for a range of characters, 
            // upper and lower case
            if (sc.hasNext("[a-dA-D]")) { // Accept only a single letter String
                // Retrieve the string from the keyboard buffer, convert it to 
                // upper case, and retrieve the first letter as a char
                choice = sc.next().toUpperCase().charAt(0);
            } else {
                // Did not match the regular expression. Inform user and set 
                // choice to the character z
                System.out.println("Invalid choice");
                choice = 'z'; // Indicates invalid input
            }
            // Clear out the keyboard buffer
            sc.nextLine();
        } while (choice == 'z'); // Keep asking until choice is not wrequal to z

        return choice;
    }

    /**
     * Display a prompt and accept a double that falls in the allowable range.
     * This approach is preferable to duplicating this code for each
     * calculation.
     *
     * @param upperRange The maximum value allowed
     * @param prompt The prompt for user input
     * @return the value in range
     */
    private double inputDouble(String prompt, double upperRange) {
        double value = 0.0; // User input
        boolean inCorrect; // If value is not a double or out of range
        do {
            inCorrect = false;
            System.out.println(prompt + upperRange + ": ");
            if (sc.hasNextDouble()) { // Check that there is a double in the keyboard buffer
                value = sc.nextDouble(); // 
                // Check if the number is in range
                if (value < 0.0 || value >= upperRange) {
                    System.out.printf("%.2f is out of range.", value);
                    inCorrect = true;
                }
            } else { // There was not a double in the keyboard buffer
                inCorrect = true;
                System.out.println("You have not entered a number");
            }
            sc.nextLine(); // Clean out the buffer
        } while (inCorrect);

        return value;
    }

    private void doInterestAndRate() {
        fb.setInterestRate(inputDouble("Enter interest rate as a decimal (5% -> 0.05), maximum: ", 1.0));
        fb.setTerm(inputDouble("Enter the term in months: ", 120.0));
        
    }
    /**
     * Request values for loan payment calculation, storing the data in a FinanceBean object
     */
    private void doLoanPaymentInput() {
        fb.setLoanAmount(inputDouble("Enter loan amount, maximum: ", 1_000_000.00));
        doInterestAndRate();
        }

    /**
     * Request values for future value calculation, storing the data in a FinanceBean object
     */
    private void doFutureValueInput() {
        fb.setSavingsAmount(inputDouble("Enter monthly savings amount, maximum ", 1_000.00));
        doInterestAndRate();
    }

    /**
     * Request values for savings goal calculation, storing the data in a FinanceBean object
     */
    private void doSavingsGoalInput() {
        fb.setFutureValue(inputDouble("Enter savings goal amount, maximum: ", 1_000_000.00));
        doInterestAndRate();
    }

    /**
     * This is method that manages the application by taking the menu choice and
     * then calling upon the appropriate methods to carry out the work.
     */
    public void perform() {

        var calculator = new Calculator();

        char choice;
        do {
            choice = menu();
            switch (choice) {
                case 'A' -> {
                    fb = new FinanceBean();
                    doLoanPaymentInput();
                    calculator.doLoanPayment(fb);
                    System.out.printf("Monthly payment will be %.2f.\n\n", fb.getResult());
                }
                case 'B' -> {
                    fb = new FinanceBean();
                    doFutureValueInput();
                    System.out.println(fb.toString());
                    calculator.doFutureValue(fb);
                    System.out.printf("Savings goal %.2f.\n\n", fb.getResult());
                }
                case 'C' -> {
                    fb = new FinanceBean();
                    doSavingsGoalInput();
                    System.out.println(fb.toString());
                    calculator.doSavingsGoal(fb);
                    System.out.printf("Save %.2f each month.\n\n", fb.getResult());
                }
                case 'D' ->
                    System.out.println("Thank you for using the CEJV416A calculator. Goodbye.\n");
                default -> {
                    System.out.println(">>>>>> Something has gone wrong. Call the IT department. <<<<<<");
                    System.exit(0);
                }
            }

        } while (choice != 'D');
    }
}
