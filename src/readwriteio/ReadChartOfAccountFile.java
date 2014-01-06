/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package readwriteio;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.io.FileNotFoundException;
import javax.swing.JOptionPane;
import mainclass.Main;

public class ReadChartOfAccountFile {

    static ArrayList<String> assets = new ArrayList();
    static ArrayList<String> liabilities = new ArrayList();
    static ArrayList<String> ownersEquity = new ArrayList();
    static ArrayList<String> revenues = new ArrayList();
    static ArrayList<String> expenses = new ArrayList();

    static String revenueAccountArray[];
    static String expensesAccountArray[];
    static String assetsAccountArray[];
    static String liabilityAccountArray[];
        public static void readChartOfAccount() throws Exception
        {
            FileReader fr=null;
            BufferedReader br=null;
            
            try
            {
                fr = new FileReader("ChartOfAccount.dat");
                br = new BufferedReader(fr);
            }catch(FileNotFoundException e)
            {
                if(JOptionPane.showConfirmDialog(mainclass.Main.frame.getChartOfAccounts(),
                        "You are running the software for the first time.\n No ledger accounts"
                        + " are made. Do you want software to make basic\n ledger accounts for"
                        + " you?\n\n E.g: Cash Account, Service Revenue Account")==0)
                   WriteChartOfAccountFile.writeChartOfAccountIfNotFound();
                else
                    WriteChartOfAccountFile.writeChartOfAccountIfNotFoundEmpty();
                fr = new FileReader("ChartOfAccount.dat");
                br = new BufferedReader(fr);
            }
            
            String s;

            s = br.readLine();
            s = br.readLine();

            while(!s.equalsIgnoreCase("LIABILITY") )
            {
                 assets.add(s);
                 s=br.readLine();
            }

             s=br.readLine();

             while(!s.equalsIgnoreCase("OWNERSEQUITY"))
             {
                 liabilities.add(s);
                 s=br.readLine();
             }

             s=br.readLine();

             while(!s.equalsIgnoreCase("REVENUES"))
             {
                 ownersEquity.add(s);
                 s=br.readLine();
             }

             s=br.readLine();

             while(!s.equalsIgnoreCase("EXPENSES"))
             {
                 revenues.add(s);
                 s=br.readLine();
             }

             s=br.readLine();

             while(s!=null)
             {
                 expenses.add(s);
                 s=br.readLine();
             }

             br.close();

             assetsAccountArray = new String[assets.size()];
             liabilityAccountArray = new String[liabilities.size()];
             String ownersEquityAccountArray[] = new String[ownersEquity.size()];
             revenueAccountArray = new String[revenues.size()];
             expensesAccountArray = new String[expenses.size()];

             StringTokenizer r; 
             
             for(int i=0; i<assets.size(); i++)
             {
                 r = new StringTokenizer(assets.get(i).trim(),"//");
                 if(r.hasMoreTokens())
                    assetsAccountArray[i] = r.nextToken();
             }

             for(int i=0; i<liabilities.size(); i++)
             {
                 r = new StringTokenizer(liabilities.get(i).trim(), "//");
                 if(r.hasMoreTokens())
                    liabilityAccountArray[i] = r.nextToken();
             }

             for(int i=0; i<ownersEquity.size(); i++)
             {
                 r = new StringTokenizer(ownersEquity.get(i).trim(), "//");
                 if(r.hasMoreTokens())
                    ownersEquityAccountArray[i] = r.nextToken();
             }

             for(int i=0; i<revenues.size(); i++)
             {
                 r = new StringTokenizer(revenues.get(i).trim(), "//");
                 if(r.hasMoreTokens())
                    revenueAccountArray[i] = r.nextToken();
             }

             for(int i=0; i<expenses.size(); i++)
             {
                 r = new StringTokenizer(expenses.get(i).trim(), "//");
                 if(r.hasMoreTokens())
                    expensesAccountArray[i] = r.nextToken();
             }

             Main.frame.getChartOfAccounts().updateAssetsList(assetsAccountArray);
             Main.frame.getChartOfAccounts().updateExpensesList(expensesAccountArray);
             Main.frame.getChartOfAccounts().updateLiabilityList(liabilityAccountArray);
             Main.frame.getChartOfAccounts().updateOwnersEquityList(ownersEquityAccountArray);
             Main.frame.getChartOfAccounts().updateRevenueList(revenueAccountArray);


             Main.frame.getTransactions().updateChoice(assetsAccountArray, expensesAccountArray, liabilityAccountArray, ownersEquityAccountArray, revenueAccountArray);
       }

       public static void updateLedgerArrayList(String title, String category, String type) throws IOException, Exception
       {
           StringTokenizer getRef;
           String separator="//";
           
           int refNumber=0;
           
            if(category.equals("ASSETS"))
            {
                refNumber=100;
                for(int i=0; i<assets.size(); i++)
                {
                    getRef=new StringTokenizer(assets.get(i),"//");
                    if(getRef.hasMoreTokens())
                        getRef.nextToken();
                    if(getRef.hasMoreTokens())
                        refNumber=Integer.parseInt(getRef.nextToken());
                }
                assets.add(title+separator+(refNumber+1)+separator+type);
                System.out.println(assets.get(assets.size()-1));
            }
            else if(category.equals("LIABILITY"))
            {
                refNumber=200;
                for(int i=0; i<liabilities.size(); i++)
                {
                    getRef=new StringTokenizer(liabilities.get(i),"//");
                    if(getRef.hasMoreTokens())
                        getRef.nextToken();
                    if(getRef.hasMoreTokens())
                        refNumber=Integer.parseInt(getRef.nextToken());
                }
                liabilities.add(title+separator+(refNumber+1)+separator+type);
                System.out.println(liabilities.get(liabilities.size()-1));
            }
            else if(category.equals("OWNERSEQUITY"))
            {
                refNumber=300;
                for(int i=0; i<ownersEquity.size(); i++)
                {
                    getRef=new StringTokenizer(ownersEquity.get(i),"//");
                    if(getRef.hasMoreTokens())
                        getRef.nextToken();
                    if(getRef.hasMoreTokens())
                        refNumber=Integer.parseInt(getRef.nextToken());
                }
                ownersEquity.add(title+separator+(refNumber+1)+separator+type);
                System.out.println(ownersEquity.get(ownersEquity.size()-1));
            }
            else if(category.equals("REVENUES"))
            {
                refNumber=400;
                for(int i=0; i<revenues.size(); i++)
                {
                    getRef=new StringTokenizer(revenues.get(i),"//");
                    if(getRef.hasMoreTokens())
                        getRef.nextToken();
                    if(getRef.hasMoreTokens())
                        refNumber=Integer.parseInt(getRef.nextToken());
                }
                revenues.add(title+separator+(refNumber+1)+separator+type);
                System.out.println(revenues.get(revenues.size()-1));
            }
            else if(category.equals("EXPENSES"))
            {
                refNumber=500;
                for(int i=0; i<expenses.size(); i++)
                {
                    getRef=new StringTokenizer(expenses.get(i),"//");
                    if(getRef.hasMoreTokens())
                        getRef.nextToken();
                    if(getRef.hasMoreTokens())
                        refNumber=Integer.parseInt(getRef.nextToken());
                }
                expenses.add(title+separator+(refNumber+1)+separator+type);
                System.out.println(expenses.get(expenses.size()-1));
            }
            
            ReadLedgerFile.findOrMakeLedger(title, title+separator+(refNumber+1)+separator+type);

           WriteChartOfAccountFile.updateChartOfAccountsFile(assets, liabilities, ownersEquity, revenues, expenses);
           assets.clear();
           liabilities.clear();
           expenses.clear();
           ownersEquity.clear();
           revenues.clear();
           readChartOfAccount();
       }
       
       public static String[] returnRevenueAccountsNamesArray()
       {
           return revenueAccountArray;
       }
       
       public static String[] returnExpensesAccountsNamesArray()
       {
           return expensesAccountArray;
       }
       
       public static String[] returnAssetsAccountsNamesArray()
       {
           return assetsAccountArray;
       }
       
       public static String[] returnLiabilitiesAccountsNamesArray()
       {
           return liabilityAccountArray;
       }
       
       public static int[] returnRevenueAccountsValues() throws FileNotFoundException, IOException
       {
           int b[]= new int[revenueAccountArray.length];
           for(int i=0; i<revenueAccountArray.length; i++)
           {    
               System.out.println(revenueAccountArray[i]);
               
               FileReader fr=new FileReader(revenueAccountArray[i]+".dat");
               BufferedReader br=new BufferedReader(fr);

               br.readLine();
               String temp=br.readLine();
               
               int balance=0;
               while(temp!=null)
               {
                   StringTokenizer st=new StringTokenizer(temp, "//");
                   if(st.hasMoreTokens())
                       st.nextToken();
                   if(st.hasMoreTokens())
                       balance=balance+Integer.parseInt(st.nextToken());
                   temp=br.readLine();
               }
               
               b[i]=balance;
           }
           
           return b;
       }
       
       public static int[] returnExpensesAccountsValues() throws FileNotFoundException, IOException
       {
           int b[]= new int[expensesAccountArray.length];
           for(int i=0; i<expensesAccountArray.length; i++)
           {    
               System.out.println(expensesAccountArray[i]);
               
               FileReader fr=new FileReader(expensesAccountArray[i]+".dat");
               BufferedReader br=new BufferedReader(fr);

               br.readLine();
               String temp=br.readLine();
               
               int balance=0;
               while(temp!=null)
               {
                   StringTokenizer st=new StringTokenizer(temp, "//");
                   if(st.hasMoreTokens())
                       st.nextToken();
                   if(st.hasMoreTokens())
                       balance=balance+Integer.parseInt(st.nextToken());
                   temp=br.readLine();
               }
               
               b[i]=balance;
           }
           
           return b;
       }
       
       public static int[] returnAssetsAccountsValues() throws FileNotFoundException, IOException
       {
           int b[]= new int[assetsAccountArray.length];
           for(int i=0; i<assetsAccountArray.length; i++)
           {    
               System.out.println(assetsAccountArray[i]);
               
               FileReader fr=new FileReader(assetsAccountArray[i]+".dat");
               BufferedReader br=new BufferedReader(fr);

               br.readLine();
               String temp=br.readLine();
               
               int balance=0;
               while(temp!=null)
               {
                   StringTokenizer st=new StringTokenizer(temp, "//");
                   if(st.hasMoreTokens())
                       st.nextToken();
                   if(st.hasMoreTokens())
                       balance=balance+Integer.parseInt(st.nextToken());
                   temp=br.readLine();
               }
               
               b[i]=balance;
           }
           
           return b;
       }
       
        public static int[] returnLiabilitiesAccountsValues() throws FileNotFoundException, IOException
       {
           int b[]= new int[liabilityAccountArray.length];
           for(int i=0; i<liabilityAccountArray.length; i++)
           {    
               System.out.println(liabilityAccountArray[i]);
               
               FileReader fr=new FileReader(liabilityAccountArray[i]+".dat");
               BufferedReader br=new BufferedReader(fr);

               br.readLine();
               String temp=br.readLine();
               
               int balance=0;
               while(temp!=null)
               {
                   StringTokenizer st=new StringTokenizer(temp, "//");
                   if(st.hasMoreTokens())
                       st.nextToken();
                   if(st.hasMoreTokens())
                       balance=balance+Integer.parseInt(st.nextToken());
                   temp=br.readLine();
               }
               
               b[i]=balance;
           }
           
           return b;
       }
       
       public static int returnNetIncomeOrLoss() throws FileNotFoundException, IOException
       {
           int revenue[]=returnRevenueAccountsValues();
           int expense[]=returnExpensesAccountsValues();
           
           int sumRevenue=0;
           for(int i=0; i<revenue.length; i++)
               sumRevenue=sumRevenue+revenue[i];
           
           int sumExpense=0;
           for(int i=0; i<expense.length; i++)
               sumExpense=sumExpense+expense[i];
           
           return (sumRevenue-sumExpense);
       }
       
       public static int returnCapitalValues() throws FileNotFoundException, IOException
       {

               FileReader fr=new FileReader("Capital.dat");
               BufferedReader br=new BufferedReader(fr);

               br.readLine();
               String temp=br.readLine();
               
               int balance=0;
               while(temp!=null)
               {
                   StringTokenizer st=new StringTokenizer(temp, "//");
                   if(st.hasMoreTokens())
                       st.nextToken();
                   if(st.hasMoreTokens())
                       balance=balance+Integer.parseInt(st.nextToken());
                   temp=br.readLine();
               }
               
               return balance;
       }
       
       public static int returnDrawingValues() throws FileNotFoundException, IOException
       {

               FileReader fr=new FileReader("Drawings.dat");
               BufferedReader br=new BufferedReader(fr);

               br.readLine();
               String temp=br.readLine();
               
               int balance=0;
               while(temp!=null)
               {
                   StringTokenizer st=new StringTokenizer(temp, "//");
                   if(st.hasMoreTokens())
                       st.nextToken();
                   if(st.hasMoreTokens())
                       balance=balance+Integer.parseInt(st.nextToken());
                   temp=br.readLine();
               }
               
               return balance;
       }
       
       public static int returnNewCapitalValue() throws FileNotFoundException, IOException
       {
           int capital=returnCapitalValues();
           int drawings=returnDrawingValues();
           
           return ((capital-drawings)+returnNetIncomeOrLoss());
       }
}
