import java.util.GregorianCalendar;
import java.util.Scanner;

public class Account {
    // create variables
    int balance;
    int previousTransaction;
    String customerName;
    String customerID;

    //class constructor
    Account(String cname, String cid) {
        customerName = cname;
        customerID = cid;
    }//end method

    //function for depositing money
    void deposit(int amount) {
        if (amount != 0) {
            balance = balance + amount;
            previousTransaction = amount;
        }//end the if loop
    }//end method deposit

    //Function showing  the previous transaction
    void withdraw(int amount) {
        if (amount != 0) {
            balance = balance - amount;
            previousTransaction = -amount;
        }//end if loop
    }//end method withdraw

    //function showing the previous transaction
    void getPreviousTransaction() {
        if (previousTransaction > 0) {
            System.out.println("deposited " + previousTransaction);

        } else if (previousTransaction < 0) {
            System.out.println("withdraw " + Math.abs(previousTransaction));
        } else {
            System.out.println("No transaction was occurred");
        }//end else if statement
    }//end setPreviousTransaction method

    //function calc interest of current funds after a numbers of years
    void calculateInterest(int years) {
        double interestRate = .0185;
        double newBalance = (balance * interestRate * years) + balance;
        System.out.println("The current interest rate is " + (100 * interestRate) + "%");
        System.out.println("After " + years + " years, you balance will be: " + newBalance);
    }//end calculateInterest method

    void showMenu() {
        char option = '\0';
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome, " + customerName + "!");
        System.out.println("your ID is: " + customerID);
        System.out.println();
        System.out.println("What would you like to do?");
        System.out.println();
        System.out.println("A. Check your balance");
        System.out.println("B. make a deposit");
        System.out.println("C. Make a withdrawal");
        System.out.println("D. View previous transaction");
        System.out.println("E. Calculate interest");
        System.out.println("F. Exist");

        do {
            System.out.println();
            System.out.println("Enter an option: ");
            char option1 = input.next().charAt(0);
            option = Character.toUpperCase(option1);
            System.out.println();



            switch (option) {
                //case 'A' allows the user to check their account balance
                case 'A':
                    System.out.println("==============================");
                    System.out.println("Balance = $" + balance);
                    System.out.println("==============================");
                    System.out.println();
                    break;

                //case 'B' allows the user to deposit money into their account using
                case 'B':
                    System.out.println("Enter an amount to deposit: ");
                    int amount = input.nextInt();
                    deposit(amount);
                    break;

                //case 'C' allows the user to withdraw money from their account
                case 'C':
                    System.out.println("Enter an amount to withdraw: ");
                    int amount2 = input.nextInt();
                    withdraw(amount2);
                    System.out.println();
                    break;

                //case 'D' allows the user to view their most recent transaction using their account
                case 'D':
                System.out.println("===============================");
                getPreviousTransaction();
                System.out.println("===============================");
                System.out.println();
                break;

                //case 'E' calculate the accrued interest on the account after numbering
                case 'E':
                    System.out.println("Enter how many years of accrued interest: ");
                    int years = input.nextInt();
                    calculateInterest(years);
                    break;

                //case 'F' exists the user from their account
                case 'F':
                System.out.println("===============================");
                break;
                //The defualt case lets the user knoe that they entered an invalid character
                default:
                    System.out.println("Error: invalid option. Please enter A, B, C, D, F");
                    break;
                }
            }while (option != 'F');
                System.out.println("Thank you for banking with the us!");

    }
}//end main
