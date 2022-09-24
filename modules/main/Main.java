package main;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import main.Bank;
import main.Transaction;
import main.account_model.Account;

public class Main 
{

    static String ACCOUNT_FILE = "main/data/accounts.txt";
    
    static String TRANSACTION_FILE = "main/data/transactions.txt";

    static Bank bank = new Bank();


    public static void main(String[] args)
    {

        try
        {
            ArrayList<Account> accounts = retunAccounts();
            loadTobank(accounts);

            ArrayList<Transaction> transactions = returnTransactions();
            runTransaction(transactions);
            bank.deductTaxes();
         } catch (FileNotFoundException e) 
         {
            System.out.println(e.getMessage());
         }
    }
    
    public static Account createObject(String[] values) 
    {
            try
            {
                return (Account)Class.forName("main/account_model/" + values[0])
                .getConstructor(String.class, String.class, double.class)
                .newInstance(values[1], values[2], Double.parseDouble(values[3]));
            } catch (Exception e)
            {
                System.out.println(e.getMessage());
                return null;
            }
    }

   public static Transaction createTransactionObject(String[] values) 
   {
            Transaction transaction = new Transaction(values[2], Double.parseDouble(values[3]), Transaction.type.valueOf(values[1]), Long.parseLong(values[0]));
            return transaction;
   }


    public static ArrayList<Account> retunAccounts() throws FileNotFoundException
    {
            FileInputStream file = new FileInputStream(ACCOUNT_FILE);
            Scanner scan = new Scanner(file);
            ArrayList<Account> accounts = new ArrayList<Account> ();
            while (scan.hasNextLine()) 
            {
                accounts.add(createObject(scan.nextLine().split(",")));
            }
            scan.close();
            return accounts;
    }

    public static ArrayList<Transaction> returnTransactions() throws FileNotFoundException
    {
            FileInputStream file = new FileInputStream(TRANSACTION_FILE);
            Scanner scan = new Scanner(file);
            ArrayList<Transaction> transactions = new ArrayList<Transaction> ();
            while (scan.hasNextLine()) 
            {
                transactions.add(createTransactionObject(scan.nextLine().split(",")));
            }
            scan.close();
            return transactions;
    }

    public static void loadTobank(ArrayList<Account> accounts) 
    {
            for (Account account: accounts) 
            {
                bank.addAccount(account);
            }
    }

    public static void runTransaction(ArrayList<Transaction> transactions) 
    {
            for (Transaction transaction: transactions)
            {
                bank.determineTransaction(transaction);
            }
    }

}
