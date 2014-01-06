//to be changed and type of ledger will be inserted


/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package readwriteio;
import java.util.*;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import readwriteio.ReadChartOfAccountFile;

public class WriteChartOfAccountFile {

    public static void writeChartOfAccountIfNotFound()throws IOException, FileNotFoundException {

       String assetsAccount[]= {"Cash", "Office Equipment", "Supplies", "Account Receivables"};
       String liabilityAccount[]= {"Account Payable", "Notes Payable"};
       String ownersEquityAccount[]= {"Capital","Drawings"};
       String revenueAccount[]= {"Service Revenue"};
       String expensesAccount[]= {"Rent Expense", "Advertising Expense", "Supplies Expense", "Salary Expense"};

       String separator = "//";

       String assetsAccountType[]= {"debit", "debit", "debit", "debit"};
       String liabilityAccountType[]= {"credit", "credit"};
       String ownersEquityAccountType[]= {"credit","debit"};
       String revenueAccountType[]= {"credit"};
       String expensesAccountType[]= {"debit", "debit", "debit", "debit"};

       int assetsAccountReferenceNumber[]={101,102,103,104};
       int liabilityAccountReferenceNumber[]={201,202};
       int ownersEquityAccountReferenceNumber[]={301,302};
       int revenueAccountReferenceNumber[]= {401};
       int expensesAccountReferenceNumber[]={501,502,503,504};

       FileWriter chartOfAccountFile=new FileWriter("ChartOfAccount.dat");
         PrintWriter printChartOfAccountFile=new PrintWriter(chartOfAccountFile);

        // printChartOfAccountFile.println( + "" + separator + "" + referenceNumber + "" + separator + "" + accountType);

         printChartOfAccountFile.println("ASSETS");
         for(int i= 0; i<assetsAccount.length ; i++)
         {
             printChartOfAccountFile.println(assetsAccount[i]+separator+assetsAccountReferenceNumber[i]+separator+assetsAccountType[i]);
         }


         printChartOfAccountFile.println("LIABILITY");
         for(int i= 0; i<liabilityAccount.length ; i++)
         {
             printChartOfAccountFile.println(liabilityAccount[i]+separator+liabilityAccountReferenceNumber[i]+separator+liabilityAccountType[i]);
         }


         printChartOfAccountFile.println("OWNERSEQUITY");
         for(int i= 0; i<ownersEquityAccount.length ; i++)
         {
             printChartOfAccountFile.println(ownersEquityAccount[i]+separator+ownersEquityAccountReferenceNumber[i]+separator+ownersEquityAccountType[i]);
         }


         printChartOfAccountFile.println("REVENUES");
         for(int i= 0; i<revenueAccount.length ; i++)
         {
             printChartOfAccountFile.println(revenueAccount[i]+""+separator+ revenueAccountReferenceNumber[i]+separator+revenueAccountType[i]);
         }


         printChartOfAccountFile.println("EXPENSES");
         for(int i= 0; i<expensesAccount.length ; i++)
         {
             printChartOfAccountFile.println(expensesAccount[i]+""+separator+ expensesAccountReferenceNumber[i]+separator+expensesAccountType[i]);
         }

         printChartOfAccountFile.close();

    }
    
    public static void writeChartOfAccountIfNotFoundEmpty()throws IOException, FileNotFoundException {

       FileWriter chartOfAccountFile=new FileWriter("ChartOfAccount.dat");
       PrintWriter printChartOfAccountFile=new PrintWriter(chartOfAccountFile);

         printChartOfAccountFile.println("ASSETS");
         printChartOfAccountFile.println("LIABILITY");
         printChartOfAccountFile.println("OWNERSEQUITY");
         printChartOfAccountFile.println("Capital//301//credit");
         printChartOfAccountFile.println("Drawings//302//debit");
         printChartOfAccountFile.println("REVENUES");
         printChartOfAccountFile.println("EXPENSES");

         printChartOfAccountFile.close();

    }

    public static void updateChartOfAccounts(String title, String category, String type) throws IOException, Exception
    {
        ReadChartOfAccountFile.updateLedgerArrayList(title, category, type);
    }

    public static void updateChartOfAccountsFile(ArrayList<String> assets, ArrayList<String> liabilities,
            ArrayList<String> ownersEquity, ArrayList<String> revenues, ArrayList<String> expenses) throws IOException
    {
        FileWriter chartOfAccountFile=new FileWriter("ChartOfAccount.dat");
        PrintWriter printChartOfAccountFile=new PrintWriter(chartOfAccountFile);

        printChartOfAccountFile.println("ASSETS");
        for(int i=0; i<assets.size(); i++)
            printChartOfAccountFile.println(assets.get(i));

        printChartOfAccountFile.println("LIABILITY");
        for(int i=0; i<liabilities.size(); i++)
            printChartOfAccountFile.println(liabilities.get(i));
        
        printChartOfAccountFile.println("OWNERSEQUITY");
        for(int i=0; i<ownersEquity.size(); i++)
            printChartOfAccountFile.println(ownersEquity.get(i));

        printChartOfAccountFile.println("REVENUES");
        for(int i=0; i<revenues.size(); i++)
            printChartOfAccountFile.println(revenues.get(i));

        printChartOfAccountFile.println("EXPENSES");
        for(int i=0; i<expenses.size(); i++)
            printChartOfAccountFile.println(expenses.get(i));

        printChartOfAccountFile.close();
    }
}
