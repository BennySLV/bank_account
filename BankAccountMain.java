package Section4;

/**
 * Complete Java Masterclass: Section 4: OOP (1)
 *
 * Constructors - Part 1: Challenge
 *
 * This program will be the Main class for the
 * corresponding Bank Account class.
 *
 * All bank accounts will therefore be
 * created and run from this class.
 *
 * @author Ben Silveston
 */
public class BankAccountMain {
    /**
     * Main method
     *
     * @param args The command-line arguments
     */
    public static void main(String[] args) {
        BankAccount bankAccount = new BankAccount(250.00);
        bankAccount.enableTransaction();
    }
} 