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