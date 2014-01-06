
package encryption;

//Income Statement print
import java.io.IOException;
import java.util.ArrayList;
import readwriteio.CompanyName;
import readwriteio.ReadChartOfAccountFile;
import readwriteio.ReadLedgerFile;

public class IncomeStatementEncrypt {

    static ArrayList<String> lines;

    public static String getIncomeStatement() throws IOException {

        lines = new ArrayList<String>();

        String read="";

        final int ALIGNWIDTH=70;

        String statementName="Income Statement";

        String companyName=CompanyName.readName();

        String []revenuesTitles=ReadChartOfAccountFile.returnRevenueAccountsNamesArray();

        int []revenuesValues=ReadChartOfAccountFile.returnRevenueAccountsValues();

        String []expensesTitles=ReadChartOfAccountFile.returnExpensesAccountsNamesArray();

        int []expensesValues=ReadChartOfAccountFile.returnExpensesAccountsValues();


        String printMaterial="";

        for(int i=0; i<ALIGNWIDTH/2; i++)
        {
            printMaterial+=" ";
            read+=" ";
        }

        printMaterial+=companyName + "\n";
        read+=companyName;

        lines.add(read);
        read="";

        int condition=0;

        if (companyName.length() > statementName.length())
            condition=(ALIGNWIDTH/2)+((companyName.length() - statementName.length())/2);
        else if(companyName.length() < statementName.length())
            condition=(ALIGNWIDTH/2)-((statementName.length()- companyName.length())/2);
        else
            condition=ALIGNWIDTH/2;

        for(int i=0; i<condition; i++)
        {
            printMaterial+=" ";
            read+=" ";
        }

        printMaterial+=statementName + "\n";
        read+=statementName;

        lines.add(read);
        read="";

        for(int i=0; i<condition; i++)
        {
            printMaterial+=" ";
            read+=" ";
        }

        String dateForStatement=ReadLedgerFile.ledgerForDate();

        printMaterial+=dateForStatement + "\n";
        read+=dateForStatement;

        lines.add(read);
        lines.add(" ");
        lines.add(" ");
        lines.add("Revenues:");
        lines.add(" ");
        lines.add(" ");

        printMaterial+="\n\nRevenues:\n\n";

        read="";
        int sumOfRevenues=0;
        for(int i=0; i<revenuesTitles.length; i++)
        {
            for(int j=0; j<5; j++)
            {
                printMaterial+=" ";
                read+=" ";
            }

            printMaterial+=revenuesTitles[i];
            read+=revenuesTitles[i];

            int temp=ALIGNWIDTH-(5+revenuesTitles[i].length());
            for(int j=0; j<ALIGNWIDTH-(5+revenuesTitles[i].length()); j++)
            {
                if(temp>10)
                {
                    printMaterial+=" ";
                    read+=" ";
                }
                temp=temp-1;
            }

            printMaterial+=Integer.toString(revenuesValues[i]) + "\n";
            read+=Integer.toString(revenuesValues[i]);

            lines.add(read);
            read="";

            sumOfRevenues+=revenuesValues[i];   // summing all the revenues
        }

        printMaterial+="\n";

        lines.add(" ");
        
        for(int i=0; i<10; i++)
        {
            printMaterial+=" ";
            read+=" ";
        }

        String labelTotalRevenues="Total Revenues";

        printMaterial+=labelTotalRevenues;
        read+=labelTotalRevenues;

        int tempForLabel=ALIGNWIDTH-(10+labelTotalRevenues.length());
        for(int j=0; j<ALIGNWIDTH-(10+labelTotalRevenues.length()); j++)
        {
            if(tempForLabel>10)
            {
                printMaterial+=" ";
                read+=" ";
            }
            tempForLabel=tempForLabel-1;
        }

        printMaterial+=sumOfRevenues;
        read+=sumOfRevenues;
        
        lines.add(read);
        lines.add(" ");
        lines.add(" ");
        lines.add("Expenses:");
        lines.add(" ");
        lines.add(" ");
        
        read="";

        printMaterial+="\n\nExpenses:\n\n";

        int sumOfExpenses=0;
        for(int i=0; i<expensesTitles.length; i++)
        {
            for(int j=0; j<5; j++)
            {
                printMaterial+=" ";
                read+=" ";
            }

            printMaterial+=expensesTitles[i];
            read+=expensesTitles[i];

            int temp=ALIGNWIDTH-(5+expensesTitles[i].length());
            for(int j=0; j<ALIGNWIDTH-(5+expensesTitles[i].length()); j++)
            {
                if(temp>18)
                {
                    printMaterial+=" ";
                    read+=" ";
                }
                temp=temp-1;
            }

            printMaterial+=Integer.toString(expensesValues[i]) + "\n";
            read+=Integer.toString(expensesValues[i]);
            
            lines.add(read);
            read="";
            
            sumOfExpenses+=expensesValues[i];   // summing all the expenses
        }

        lines.add(" ");
        printMaterial+="\n";

        for(int i=0; i<10; i++)
        {
            printMaterial+=" ";
            read+=" ";
        }

        String labelTotalExpenses="Total Expenses";

        printMaterial+=labelTotalExpenses;
        read+=labelTotalExpenses;

        int tempForLabel2=ALIGNWIDTH-(10+labelTotalExpenses.length());
        for(int j=0; j<ALIGNWIDTH-(10+labelTotalExpenses.length()); j++)
        {
            if(tempForLabel2>10)
            {
                printMaterial+=" ";
                read+=" ";
            }
            tempForLabel2=tempForLabel2-1;
        }

        printMaterial+=sumOfExpenses + "\n";
        read+=sumOfExpenses;
        
        lines.add(read);
        read="";

        for(int i=0; i<ALIGNWIDTH; i++)
        {
            printMaterial+="-";
            read+="-";
        }

        lines.add(read);
        read="";
        
        int sumOfRevenuesAndExpenses = sumOfRevenues - sumOfExpenses;

        String labelNetIncomeLoss;
        if(sumOfRevenuesAndExpenses < 0)
        {
            labelNetIncomeLoss = "Net Loss";
            printMaterial += "\n" + labelNetIncomeLoss;
            read+=labelNetIncomeLoss;
            //sumOfRevenuesAndExpenses *= -1;
        }
        else
        {
            labelNetIncomeLoss = "Net Income";
            printMaterial += "\n" + labelNetIncomeLoss;
            read+=labelNetIncomeLoss;
        }

        int tempForLabel3=ALIGNWIDTH-(labelNetIncomeLoss.length());
        for(int j=0; j<ALIGNWIDTH-(labelNetIncomeLoss.length()); j++)
        {
            if(tempForLabel3>10)
            {
                printMaterial+=" ";
                read+=" ";
            }
            tempForLabel3=tempForLabel3-1;
        }

        printMaterial += Integer.toString(sumOfRevenuesAndExpenses);
        read+=Integer.toString(sumOfRevenuesAndExpenses);
        
        lines.add(read);

       // System.out.println(printMaterial);
        return printMaterial;
    }
    
    public static ArrayList<String> returnArrayListOfIncome()
    {
        return lines;
    }
}
