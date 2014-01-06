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

public class OwnersEquityStatement {
    
    static ArrayList<String> lines;

    public static String getOwnersEquityStatement() throws IOException {

        String temp="";
        
        lines=new ArrayList<String>();        
        
        final int ALIGNWIDTH=70;

        String statementName="Owner's Equity Statement";

        String companyName=CompanyName.readName();

        String initialDate=ReadLedgerFile.returnCapitalDate();

        String initialCapitalLabel="Initial Capital";

        int initialCapitalValue=0;

        String investmentLabel="Add: Investment";

        int investmentValue = ReadChartOfAccountFile.returnCapitalValues();

        boolean haveNetIncome=true;

        String netLabel;
        int netIncomeOrLoss=ReadChartOfAccountFile.returnNetIncomeOrLoss();
        
        if(netIncomeOrLoss<0)
            haveNetIncome=false;

        if(haveNetIncome)
            netLabel="Net Income";
        else
            netLabel="Net Loss";

        String drawingLabel="Less: Drawings";

        int drawingValue=ReadChartOfAccountFile.returnDrawingValues();

        String currentCapitalLabel="Current Capital";

        int currentCapitalValue=0;

        String printMaterial="";

        for(int i=0; i<(ALIGNWIDTH/2)-(companyName.length()/2); i++)
        {
            printMaterial+=" ";
            temp+=" ";
        }

        printMaterial+=companyName + "\n";
        temp+=companyName;
        
        lines.add(temp);

        int condition=0;

        if (companyName.length() > statementName.length())
            condition=(ALIGNWIDTH/2)-(companyName.length()/2)+((companyName.length() - statementName.length())/2);
        else if(companyName.length() < statementName.length())
            condition=(ALIGNWIDTH/2)-(companyName.length()/2)-((statementName.length()- companyName.length())/2);
        else
            condition=(ALIGNWIDTH/2)-(statementName.length()/2);

        temp="";
        
        for(int i=0; i<condition; i++)
        {
            printMaterial+=" ";
            temp+=" ";
        }

        printMaterial+=statementName + "\n";
        temp+=statementName;
        
        lines.add(temp);
        
        String dateString = ReadLedgerFile.ledgerForDate();

        temp="";
        
        for(int i=0; i<((ALIGNWIDTH/2)-(companyName.length()/2))+((companyName.length() - dateString.length())/2); i++)
        {
            printMaterial+=" ";
            temp+=" ";
        }

        printMaterial+=dateString;
        temp+=dateString;
        
        lines.add(temp);

        temp="";
        
        String statementOfInitialCapital = companyName+", "+ initialCapitalLabel +", "+
                initialDate;

        lines.add(" ");
        lines.add(" ");
        
        temp=statementOfInitialCapital;
        
        printMaterial+="\n\n"+ statementOfInitialCapital;

        int temp1=ALIGNWIDTH-(statementOfInitialCapital.length());
        for(int j=0; j<ALIGNWIDTH-(statementOfInitialCapital.length()); j++)
        {
            if(temp1>5)
            {
                printMaterial+=" ";
                temp+=" ";
            }
            temp1=temp1-1;
        }

        printMaterial += initialCapitalValue +"\n";
        temp+=initialCapitalValue;
        
        lines.add(temp);
        
        temp="";

        printMaterial += investmentLabel;
        temp+=investmentLabel;

        int tempForLabel=ALIGNWIDTH-(investmentLabel.length());
        for(int j=0; j<ALIGNWIDTH-(investmentLabel.length()); j++)
        {
            if(tempForLabel>15)
            {
                printMaterial+=" ";
                temp+=" ";
            }
            tempForLabel=tempForLabel-1;
        }

        printMaterial += Integer.toString(investmentValue) +"\n";
        temp+=Integer.toString(investmentValue);
        
        lines.add(temp);
        
        temp="";

        for(int i=0; i<5; i++)
        {
            printMaterial+=" ";
            temp+=" ";
        }

        printMaterial += netLabel;
        temp+=netLabel;

        int tempForLabel2=ALIGNWIDTH-(5+netLabel.length());
        for(int j=0; j<ALIGNWIDTH-(5+netLabel.length()) && tempForLabel2>15; j++)
        {
            if(tempForLabel2>15)
            {
                printMaterial+=" ";
                temp+=" ";
            }
            tempForLabel2=tempForLabel2-1;
        }
        
        String netIncomeOrLossToString = Integer.toString(netIncomeOrLoss);
        
        printMaterial += netIncomeOrLossToString;
        temp += netIncomeOrLossToString;
        
        tempForLabel2=tempForLabel2-netIncomeOrLossToString.length();        
        for(int j=0; j<ALIGNWIDTH-(netLabel.length()); j++)
        {
            if(tempForLabel2>5)
            {
                printMaterial+=" ";
                temp+=" ";
            }
            tempForLabel2=tempForLabel2-1;
        }

        int investmentPlusNetValue=investmentValue+netIncomeOrLoss;

        printMaterial += Integer.toString(investmentPlusNetValue) + "\n";
        temp+=Integer.toString(investmentPlusNetValue);
        
        lines.add(temp);
        
        temp="";

        printMaterial += drawingLabel;

        temp+=drawingLabel;

        int tempForLabel3=ALIGNWIDTH-(drawingLabel.length());
        for(int j=0; j<ALIGNWIDTH-(drawingLabel.length()); j++)
        {
            if(tempForLabel3>5)
            {
                printMaterial+=" ";
                temp+=" ";
            }
            tempForLabel3=tempForLabel3-1;
        }

        printMaterial += Integer.toString(drawingValue) + "\n";
        temp+= Integer.toString(drawingValue);

        lines.add(temp);

        temp="";

        String statementOfCurrentCapital = companyName+", "+ currentCapitalLabel +", "+
                dateString;

        printMaterial += statementOfCurrentCapital;
        temp+=statementOfCurrentCapital;

        int tempForLabel4=ALIGNWIDTH-(statementOfCurrentCapital.length());
        for(int j=0; j<ALIGNWIDTH-(statementOfCurrentCapital.length()); j++)
        {
            if(tempForLabel4>5)
            {
                printMaterial+=" ";
                temp+=" ";
            }
            tempForLabel4=tempForLabel4-1;
        }

        currentCapitalValue = drawingValue + investmentPlusNetValue;

        printMaterial += Integer.toString(currentCapitalValue);
        temp+=Integer.toString(currentCapitalValue);

        lines.add(temp);
        //System.out.println(printMaterial);
        return printMaterial;

    }

    public static ArrayList<String> returnArrayListOfEquity()
    {
        return lines;
    }
}
