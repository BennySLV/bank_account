package Section4;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * Complete Java Masterclass - Section 4: OOP (1)
 *
 * Constructors - Part 1: Challenge
 *
 * This class will create a bank account object
 * whereby the user will be able to both
 * deposit and withdraw funds.
 *
 * Assuming that there is enough money
 * in the bank account for withdrawals in particular.
 *
 * Update: A SCANNER has been added in the version
 * to enable user-input and therefore allow the user
 * to enter account details as well as conduct transactions.
 * Therefore aiming to better resemble the program to
 * that of an ATM machine.
 *
 * Update: Constructor chaining enabled for all three constructors
 * in this class.
 *
 * @author Ben Silveston, Tim Buchalka
 */
public class BankAccount {
    private String accountNumber;
    private double balance;
    private double givenAmount;
    private String accountName;
    private String email;
    private String phoneNumber;

    // Enable currency formatting to two decimal places:
    private final DecimalFormat DECIMAL_FORMAT = new DecimalFormat("#0.00");

    // Scanner to be used for user-input in the program:
    private static final Scanner SCANNER = new Scanner(System.in);

    /**
     * Basic constructor
     *
     * The account balance is only defined
     * and given a default value of £100.00.
     *
     * All customer details are defined on request at
     * run-time.
     */
    public BankAccount() {
        this(100.00);
    }

    /**
     * Constructor
     *
     * Provides default details for a new current
     * account if these are not entered manually
     *
     * Also allows the balance to be defined a new value
     * other than the default value of £100.00.
     *
     * @param balance The current account's balance
     */
    public BankAccount(double balance) {
        this("John Smith",
                "54651652",
                "01654-456572",
                "johnsmith@gmail.com");
        this.balance = balance;
    }

    /**
     * Constructor
     *
     * Allows customer details to be defined here
     * instead of the default values, as defined in the
     * previous constructor.
     *
     * @param accountName The customer's registered account name
     * @param accountNumber The customer's account number
     * @param phoneNumber The customer's phone number
     * @param email The customer's email address
     */
    public BankAccount(String accountName, String accountNumber, String phoneNumber, String email) {
        this.accountName = accountName;
        this.accountNumber = accountNumber;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    /**
     * Set the new account number
     * for the customer
     *
     * @param accountNumber The new account number
     */
    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    /**
     * Get the account number for
     * the customer
     *
     * @return String
     */
    public String getAccountNumber() {
        return this.accountNumber;
    }

    /**
     * Set the new balance
     * for the customer
     *
     * @param balance The new account balance
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }

    /**
     * Get the customer's balance
     *
     * @return The current account balance
     */
    public double getBalance() {
        return this.balance;
    }

    /**
     * Set the given amount to be
     * deposited or withdrawn
     *
     * @param givenAmount The given amount
     */
    public void setGivenAmount(double givenAmount) {
        this.givenAmount = givenAmount;
    }

    /**
     * Get the given amount to be
     * deposited or withdrawn
     *
     * @return The current given amount
     */
    public double getGivenAmount() {
        return givenAmount;
    }

    /**
     * Set the new account name
     * for the customer
     *
     * @param accountName The new account name
     */
    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    /**
     * Get the customer's account name
     *
     * @return The current account name
     */
    public String getAccountName() {
        return this.accountName;
    }

    /**
     * Set the new email address
     * for the customer
     *
     * @param email The new email address
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Get the email-address
     * of the customer
     *
     * @return The current email-address
     */
    public String getEmail() {
        return this.email;
    }

    /**
     * Set the phone number
     * for the customer
     *
     * @param phoneNumber The new phone number
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * Get the customer's
     * phone number
     *
     * @return The current phone number
     */
    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    /**
     * Deposit a given amount
     * of money
     *
     * @param amount The amount of money to deposit
     */
    public void depositFunds(double amount) {
        this.balance += amount;
        System.out.println("The account " + this.accountNumber +  " under the name of " + this.accountName +
                " has just deposited £" + DECIMAL_FORMAT.format(amount));
        System.out.println("The total account balance is now £" + DECIMAL_FORMAT.format(getBalance()));
    }

    /**
     * Withdraw a given amount
     * of money
     *
     * @param amount The amount of money to withdraw
     */
    public void withdrawFunds(double amount) {
        if(this.balance <= 0 || amount > this.balance) {
            System.out.println("Unable to withdraw money, due to insufficient funds. Transaction failed.");
        }
        else {
            this.balance -= amount;
            System.out.println("The account " + this.accountNumber +  " under the name of " + this.accountName +
                    " has just withdrawn £" + DECIMAL_FORMAT.format(amount));
            System.out.println("The total account balance is now £" + DECIMAL_FORMAT.format(getBalance()));
        }
    }

    /**
     * Enter the account details
     */
    public void enterAccountDetails() {
        System.out.println("Please enter the following details - " +
                "(account name, account number, phone number and email address): ");
        this.accountName = SCANNER.nextLine();
        this.setAccountName(this.accountName);
        this.accountNumber = SCANNER.nextLine();
        this.setAccountNumber(this.accountNumber);
        this.phoneNumber = SCANNER.nextLine();
        this.setPhoneNumber(this.phoneNumber);
        this.email = SCANNER.nextLine();
        this.setEmail(this.email);
    }

    /**
     * Print account details
     */
    private void printAccountDetails() {
        System.out.println("Account name: " + this.getAccountName() + "\n" +
                "Current account balance: £" + DECIMAL_FORMAT.format(this.getBalance()) + "\n" +
                "Phone number: (" + this.getPhoneNumber() + ")" + "\n" +
                "Email address: " + this.getEmail());
    }

    /**
     * Enable the transaction whether
     * that would a deposit or withdrawal
     */
    public void enableTransaction() {
        System.out.print("Do you wish to deposit or withdraw funds (Press 'd' / 'w')? ");
        String answer = SCANNER.next();

        while(SCANNER.hasNextLine()) {
            if(answer.equals("d") || answer.equals("D")) {
                System.out.print("Please enter the amount to deposit (£): ");
                double amountToDeposit = SCANNER.nextDouble();
                System.out.print("You are about to deposit £" + DECIMAL_FORMAT.format(amountToDeposit) +
                        ", do you want to proceed? (Please type 'y' or 'n'): ");
                String depositAnswer = SCANNER.next();
                if(depositAnswer.equals("y") || depositAnswer.equals("Y")) {
                    this.depositFunds(amountToDeposit);
                    break;
                }
                else if(depositAnswer.equals("n") || depositAnswer.equals("N")) {
                    disableTransaction();
                    break;
                }
                else {
                    System.out.print("Please enter an answer (Y / N): ");
                }
            }
            else if(answer.equals("w") || answer.equals("W")) {
                System.out.print("Please enter the amount to withdraw (£): ");
                double amountToWithdraw = SCANNER.nextDouble();
                System.out.print("You are about to withdraw £" + DECIMAL_FORMAT.format(amountToWithdraw) +
                        ", do you want to proceed? (Please type 'y' or 'n'): ");
                String withdrawAnswer = SCANNER.next();
                if(withdrawAnswer.equals("y") || withdrawAnswer.equals("Y")) {
                    this.withdrawFunds(amountToWithdraw);
                    break;
                }
                else if(answer.equals("n") || answer.equals("N")) {
                    disableTransaction();
                    break;
                }
                else {
                    System.out.print("Sorry, cannot recognise answer. Please enter an appropriate answer (Y / N): ");
                }
            }
            else {
                System.out.print("Sorry, cannot recognise answer. Please enter an appropriate answer (D / W): ");
            }
        }
        SCANNER.close();
        System.out.println("\nPlease find updated details below: ");
        printAccountDetails();
    }

    /**
     * Disable a transaction, based on the request of the user
     */
    private void disableTransaction() {
        System.out.println("Transaction has been disabled.");
    }
} 