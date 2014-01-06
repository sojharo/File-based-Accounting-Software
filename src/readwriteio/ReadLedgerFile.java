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
import datastructure.LinkedListForTransaction;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;
/**
 *
 * @author MR
 */
public class ReadLedgerFile
{
        public static void arrangeLedgers() throws Exception
        {
            
            FileReader ca = new FileReader("ChartOfAccount.dat");
            BufferedReader sa = new BufferedReader(ca);
            
            sa.readLine();
            
            String s=sa.readLine();
            
            StringTokenizer tk=null;
            
            String accountTitle="";
            
            while(!s.equalsIgnoreCase("LIABILITY") )
            {
                 tk = new StringTokenizer(s, "//");
                 
                 if(tk.hasMoreTokens())
                     accountTitle=tk.nextToken();
                 
                 findOrMakeLedger(accountTitle, s);
                 
                 s=sa.readLine();
            }
            
            s=sa.readLine();

             while(!s.equalsIgnoreCase("OWNERSEQUITY"))
             {
                tk = new StringTokenizer(s, "//");
                 
                 if(tk.hasMoreTokens())
                     accountTitle=tk.nextToken();
                 
                 findOrMakeLedger(accountTitle, s);
                 
                 s=sa.readLine();
             }

             s=sa.readLine();

             while(!s.equalsIgnoreCase("REVENUES"))
             {
                 tk = new StringTokenizer(s, "//");
                 
                 if(tk.hasMoreTokens())
                     accountTitle=tk.nextToken();
                 
                 findOrMakeLedger(accountTitle, s);
                 
                 s=sa.readLine();
             }

             s=sa.readLine();

             while(!s.equalsIgnoreCase("EXPENSES"))
             {
                 tk = new StringTokenizer(s, "//");
                 
                 if(tk.hasMoreTokens())
                     accountTitle=tk.nextToken();
                 
                 findOrMakeLedger(accountTitle, s);
                 
                 s=sa.readLine();
             }

             s=sa.readLine();

             while(s!=null)
             {
                 tk = new StringTokenizer(s, "//");
                 
                 if(tk.hasMoreTokens())
                     accountTitle=tk.nextToken();
                 
                 findOrMakeLedger(accountTitle, s);
                 
                 s=sa.readLine();
             }
            sa.close();
        }
        
        public static void findOrMakeLedger(String accountTitle, String statement) throws FileNotFoundException, IOException
        {
            FileReader fr;
            BufferedReader br=null;
            try{
                fr = new FileReader(accountTitle+".dat");
                br = new BufferedReader(fr);
            }catch(FileNotFoundException e)
            {
                WriteLedgerFile.writeLedgerIfNotFound(accountTitle, statement);
                
                fr = new FileReader(accountTitle+".dat");
                br = new BufferedReader(fr);
            }
            
            br.close();
        }

        public static String ledgerForDate() throws FileNotFoundException, IOException
        {
            String date="";

            FileReader fr=null;
            BufferedReader br=null;
            try
            {
                StringTokenizer n=new StringTokenizer(ReadChartOfAccountFile.assets.get(0),"//");
                if(n.hasMoreTokens())
                {
                    String k=n.nextToken();
                    System.out.println(k);
                    fr=new FileReader(k+".dat");
                }
                br=new BufferedReader(fr);
            }catch(FileNotFoundException e)
            {}

            br.readLine();

            String d=br.readLine();
            StringTokenizer b;

            while(d!=null)
            {
                b=new StringTokenizer(d, "//");
                if(b.hasMoreTokens())
                    date=b.nextToken();
                d=br.readLine();
            }

            return date;
        }

        public static String returnCapitalDate() throws IOException, NullPointerException
        {
            String date="";

            FileReader fr=null;
            BufferedReader br=null;
            try
            {               
                fr=new FileReader("Capital.dat");
                br=new BufferedReader(fr);
            }catch(FileNotFoundException e)
            {}

            br.readLine();

            String d=br.readLine();
            StringTokenizer b=null;
            try{
                b=new StringTokenizer(d, "//");
            

            if(b.hasMoreTokens())
                date=b.nextToken();
            }catch(NullPointerException e)
            {}

            return date;
        }
}
