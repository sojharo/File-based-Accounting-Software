/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package encryption;

import java.io.IOException;
import java.util.ArrayList;
import readwriteio.CompanyName;
import readwriteio.ReadChartOfAccountFile;
import readwriteio.ReadLedgerFile;
        
public class BalanceSheet {

    static ArrayList<String> lines;
     
    public static String getBalanceSheet() throws IOException {

        lines = new ArrayList<String>();

        String read="";
        
        final int ALIGNWIDTH=70;

        String statementName="Balance Sheet";

        String companyName=CompanyName.readName();

        String capitalLabel = companyName + ", Capital";

        int capitalValue = ReadChartOfAccountFile.returnNewCapitalValue();

        String []assetsAccountsLabel=ReadChartOfAccountFile.returnAssetsAccountsNamesArray();

        int []assetsAccountsValues=ReadChartOfAccountFile.returnAssetsAccountsValues();

        String []depreicablesAccountsTitles={};

        int []depreciablesAccountsValues={};

        String []depreciationAccountsTitles={};

        int []depreciationAccountsValues={};

        String []liabilitiesAccountsLabel=ReadChartOfAccountFile.returnLiabilitiesAccountsNamesArray();

        int []liabilitiesAccountsValues=ReadChartOfAccountFile.returnLiabilitiesAccountsValues();

        String printMaterial="";

        for(int i=0; i<(ALIGNWIDTH/2)-(companyName.length()/2); i++)
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
            condition=(ALIGNWIDTH/2)-(companyName.length()/2)+((companyName.length() - statementName.length())/2);
        else if(companyName.length() < statementName.length())
            condition=(ALIGNWIDTH/2)-(companyName.length()/2)-((statementName.length()- companyName.length())/2);
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
        
        String dateString =ReadLedgerFile.ledgerForDate();

        for(int i=0; i<(ALIGNWIDTH/2)-(companyName.length()/2)+((companyName.length()-dateString.length())/2); i++)
        {
            printMaterial+=" ";
            read+=" ";
        }

        printMaterial+=dateString +"\n\n";
        read+=dateString;
        
        lines.add(read);
        read="";
        lines.add(" ");

        String assetsHeading = "Assets";

        for(int i=0; i<(ALIGNWIDTH/2)-(statementName.length()/2)+((statementName.length() - assetsHeading.length())/2); i++)
        {
            printMaterial+=" ";
            read+=" ";
        }

        printMaterial += assetsHeading +"\n";
        read+=assetsHeading;
        
        lines.add(read);
        read="";

        int sumOfAssetsAccounts=0;
        for(int i=0; i<assetsAccountsLabel.length; i++)
        {
            printMaterial += assetsAccountsLabel[i];
            read+=assetsAccountsLabel[i];

            int temp=ALIGNWIDTH-(assetsAccountsLabel[i].length());
            for(int j=0; j<ALIGNWIDTH-(assetsAccountsLabel[i].length()); j++)
            {
                if(temp>10)
                {
                    printMaterial+=" ";
                    read+=" ";
                }
                temp=temp-1;
            }

            printMaterial+=Integer.toString(assetsAccountsValues[i]) + "\n";
            read+=Integer.toString(assetsAccountsValues[i]);
            lines.add(read);
            read="";

            sumOfAssetsAccounts +=assetsAccountsValues[i];   // summing all the revenues
        }

        int sumOfEquipmentsAccountsLessDepreciation=0;
        for(int i=0; i<depreicablesAccountsTitles.length; i++)
        {
            printMaterial += depreicablesAccountsTitles[i];
            read+=depreicablesAccountsTitles[i];

            int temp=ALIGNWIDTH-(depreicablesAccountsTitles[i].length());
            for(int j=0; j<ALIGNWIDTH-(depreicablesAccountsTitles[i].length()); j++)
            {
                if(temp>20)
                {
                    printMaterial+=" ";
                    read+=" ";
                }
                temp=temp-1;
            }

            printMaterial+=Integer.toString(depreciablesAccountsValues[i]) + "\n";
            read+=Integer.toString(depreciablesAccountsValues[i]);
            
            lines.add(read);
            read="";

            printMaterial += depreciationAccountsTitles[i];
            read+=depreciationAccountsTitles[i];

            int tempForLabel2=ALIGNWIDTH-(depreciationAccountsTitles[i].length());
            for(int j=0; j<ALIGNWIDTH-(depreciationAccountsTitles[i].length()) && tempForLabel2>15; j++)
            {
                if(tempForLabel2>20)
                {
                    printMaterial+=" ";
                    read+=" ";
                }
                tempForLabel2=tempForLabel2-1;
            }

            printMaterial+=Integer.toString(depreciationAccountsValues[i]);
            read+=Integer.toString(depreciationAccountsValues[i]);

            for(int j=0; j<ALIGNWIDTH-(depreciationAccountsTitles[i].length()); j++)
            {
                if(tempForLabel2>7)
                {
                    printMaterial+=" ";
                    read+=" ";
                }
                tempForLabel2=tempForLabel2-1;
            }

            int equipmentLessDepreciation=depreciablesAccountsValues[i]-depreciationAccountsValues[i];

            printMaterial += equipmentLessDepreciation + "\n";
            read+=equipmentLessDepreciation;
            
            lines.add(read);
            read="";

            sumOfEquipmentsAccountsLessDepreciation += equipmentLessDepreciation;

        }

        for(int i=0; i<10; i++)
        {
            printMaterial += " ";
            read+=" ";
        }

        String labelTotalAssets="Total Assets";

        printMaterial += labelTotalAssets;
        read += labelTotalAssets;

        int temp=ALIGNWIDTH-(10+labelTotalAssets.length());
        for(int j=0; j<ALIGNWIDTH-(10+labelTotalAssets.length()); j++)
        {
            if(temp>10)
            {
               printMaterial+=" ";
               read+=" ";
            }
            temp=temp-1;
        }

        sumOfAssetsAccounts += sumOfEquipmentsAccountsLessDepreciation;

        printMaterial += Integer.toString(sumOfAssetsAccounts) + "\n\n";
        read+=Integer.toString(sumOfAssetsAccounts);
        
        lines.add(read);
        read="";
        lines.add(" ");

        for(int j=0; j<ALIGNWIDTH/2/2; j++)
        {
            printMaterial += " ";
            read+=" ";
        }

        printMaterial += "Liabilities and Owner's Equity\n\n";
        read+="Liabilities and Owner's Equity";
        
        lines.add(read);
        read="";
        lines.add(" ");
        lines.add("Liabilities");

        printMaterial += "Liabilities\n";

        int sumOfLiabilitiesAccounts=0;
        for(int i=0; i<liabilitiesAccountsLabel.length; i++)
        {
            for(int j=0; j<5; j++)
            {
                printMaterial += " ";
                read+=" ";
            }

            printMaterial += liabilitiesAccountsLabel[i];
            read+=liabilitiesAccountsLabel[i];

            int tempForLabel=ALIGNWIDTH-(5+liabilitiesAccountsLabel[i].length());
            for(int j=0; j<ALIGNWIDTH-(5+liabilitiesAccountsLabel[i].length()); j++)
            {
                if(tempForLabel>10)
                {
                    printMaterial+=" ";
                    read+=" ";
                }
                tempForLabel=tempForLabel-1;
            }

            printMaterial += Integer.toString(liabilitiesAccountsValues[i]) + "\n";
            read+=Integer.toString(liabilitiesAccountsValues[i]);
            
            lines.add(read);
            read="";

            sumOfLiabilitiesAccounts += liabilitiesAccountsValues[i];

        }

        for(int i=0; i<10; i++)
        {
            printMaterial += " ";
            read+=" ";
        }

        String labelTotalLiabilities = "Total Liabilities";
        printMaterial += labelTotalLiabilities;
        read+=labelTotalLiabilities;

        int tempForLabel=ALIGNWIDTH-(10+labelTotalLiabilities.length());
        for(int j=0; j<ALIGNWIDTH-(10+labelTotalLiabilities.length()); j++)
        {
            if(tempForLabel>10)
            {
                printMaterial+=" ";
                read+=" ";
            }
            tempForLabel=tempForLabel-1;
        }

        printMaterial += sumOfLiabilitiesAccounts + "\n";
        read+= sumOfLiabilitiesAccounts;
        
        lines.add(read);
        read="";
        lines.add("Owner's Equity");

        printMaterial += "Owner's Equity\n";

        for(int i=0; i<5; i++)
        {
            printMaterial += " ";
            read+=" ";
        }

        printMaterial += capitalLabel;
        read+=capitalLabel;

        int tempForLabel2=ALIGNWIDTH-(5+capitalLabel.length());
        for(int j=0; j<ALIGNWIDTH-(5+capitalLabel.length()); j++)
        {
            if(tempForLabel2>10)
            {
                printMaterial+=" ";
                read+=" ";
            }
            tempForLabel2=tempForLabel2-1;
        }

        printMaterial += Integer.toString(capitalValue) + "\n";
        read+=Integer.toString(capitalValue);
        
        lines.add(read);
        read="";

        for(int i=0; i<5; i++)
        {
            printMaterial += " ";
            read+=" ";
        }

        String labelTotalLiabilitiesOwnersEquity="Total Liabilities and Owner's Equity";

        printMaterial += labelTotalLiabilitiesOwnersEquity;
        read+=labelTotalLiabilitiesOwnersEquity;

        int tempForLabel3=ALIGNWIDTH-(5+labelTotalLiabilitiesOwnersEquity.length());
        for(int j=0; j<ALIGNWIDTH-(5+labelTotalLiabilitiesOwnersEquity.length()); j++)
        {
            if(tempForLabel3>10)
            {
                printMaterial += " ";
                read+=" ";
            }
            tempForLabel3=tempForLabel3-1;
        }

        int valueTotalLiabilitiesOwnersEquity= capitalValue + sumOfLiabilitiesAccounts;
        printMaterial += valueTotalLiabilitiesOwnersEquity;
        read+=valueTotalLiabilitiesOwnersEquity;
        
        lines.add(read);
    
        return printMaterial;
    }
    
    public static ArrayList<String> returnArrayListOfBalance()
    {
        return lines;
    }
}
