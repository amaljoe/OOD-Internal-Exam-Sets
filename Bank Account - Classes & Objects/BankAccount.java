// Q)Suppose that you are provided with a pre-written class BankAccount as
// shown below. You may refer to them or use them in solving this problem
// if necessary.
// Write an instance method named transactionFee that will be placed inside
// the BankAccount class to become a part of each BankAccount object&#39;s
// behavior. The transactionFee method accepts a fee amount (a real
// number) as a parameter, and applies that fee to the user&#39;s past
// transactions. The fee is applied once for the first transaction, twice for the
// second transaction, three times for the third, and so on. These fees are
// subtracted out from the user&#39;s overall balance. If the user&#39;s balance is
// large enough to afford all of the fees with greater than $0.00 remaining,
// the method returns true. If the balance cannot afford all of the fees or has
// no money left, the balance is left as 0.0 and the method returns false.

import java.io.*;
import java.util.*;

public class BankAccount {
    String id;
    double balance;
    int transactions;
    double transactionFees;

    //constructor
    BankAccount(String id, double transactionFees) {
        this.transactionFees = transactionFees;
        this.id = id;
        balance = 0;
        transactions = 0;
    }

    public double getBalance() {
        return balance;
    }

    public String getID() {
        return id;
    }

    public String getTransactions() {
        return "No. of transactions = " + transactions;
    }

    public void deposit(double amount) {
        transactions++;
        balance += amount;
        // deduct transation fee and if balance is not sufficient, show an error message
        if (transactionFee(transactionFees)) {
            System.out.println("Transaction successful! New balance is: " + getBalance());
        } else {
            System.out.println("Transaction failed: Not enough balance.");
        }
    }

    public void withdraw(double amount) {
        transactions++;
        balance -= amount;
        // deduct transation fee and if balance is not sufficient, show an error message
        if (transactionFee(transactionFees)) {
            System.out.println("Transaction successful! New balance is: " + getBalance());
        } else {
            System.out.println("Transaction failed: Not enough balance.");
        }
    }

    public boolean transactionFee(double fee) {
        // calculate transaction fees
        double currentFee = transactions * fee;
        // deduct fees from total balance
        balance -= currentFee;
        if (balance > 0) {
            return true;
        } else {
            balance = 0;
            return false;
        }
    }

    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your first name:");
        String fName = sc.next();
        BankAccount bAccount = new BankAccount(fName, 5);
        boolean flag = true;
        // menu driven
        while (flag) {
            System.out.println("1) print balance 2) print ID 3) print no. of transactions");
            System.out.println("4) deposit amount 5) withdraw amount 6) exit");
            System.out.println("Enter your options:");
            int option = sc.nextInt();
            switch (option) {
                case 1:
                    System.out.println("Your balance: " + bAccount.getBalance());
                    break;
                case 2:
                    System.out.println("Your ID: " + bAccount.getID());
                    break;
                case 3:
                    System.out.println(bAccount.getTransactions());
                    break;
                case 4:
                    System.out.println("Enter the amount:");
                    double amt = sc.nextDouble();
                    bAccount.deposit(amt);
                    break;
                case 5:
                    System.out.println("Enter the amount:");
                    double amt2 = sc.nextDouble();
                    bAccount.withdraw(amt2);
                    break;
                case 6:
                    flag = false;
                    break;
                default:
                    System.out.println("Invalid option.");
            }
            System.out.println();
        }
    }
}