/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package readwriteio;
import java.io.BufferedReader;
import java.util.*;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


public class WriteLedgerFile {
    
    static final String SEP="//";

     public static String writeLedgerAndReturnInfo(String accountTitle, String date, String value,
             String narration, String debitOrCredit) throws IOException, FileNotFoundException 
     {
         FileReader fr = new FileReader(accountTitle+".dat");
         BufferedReader br = new BufferedReader(fr);      
         
         ArrayList<String> tempStrings = new ArrayList<String>();
         
         String tempHolder=br.readLine();
         
         String info=tempHolder;
         
         String newValue = valueNegativeOrPositive(info, value, debitOrCredit);
         
         System.out.println(newValue);
                 
         while(tempHolder!=null)
         {
             tempStrings.add(tempHolder);
             tempHolder=br.readLine();
         }
         
         br.close();
         
         String newString = date + SEP + newValue + SEP + narration;
         
         FileWriter resultFile=new FileWriter(accountTitle+".dat");
         PrintWriter forResultFile=new PrintWriter(resultFile);
         
         for(int i=0; i<tempStrings.size(); i++)
             forResultFile.println(tempStrings.get(i));
         
         forResultFile.println(newString);

         forResultFile.close();
         
         return info;
     }
     
     public static void writeLedgerIfNotFound(String ledgerName, String statement) throws IOException
     {
          FileWriter resultFile=new FileWriter(ledgerName+".dat");
          PrintWriter forResultFile=new PrintWriter(resultFile);

          forResultFile.println(statement);
          forResultFile.close();
     }
     
     public static String valueNegativeOrPositive(String tempHolder, String valueG, String debitOrCredit)
     {
         String value="";
         
         StringTokenizer temp = new StringTokenizer(tempHolder, "//");
         
         String accountDebitOrCredit="";
         
         if(temp.hasMoreTokens())
             temp.nextToken();
         if(temp.hasMoreTokens())
             temp.nextToken();
         if(temp.hasMoreTokens())
             accountDebitOrCredit=temp.nextToken();
         
         if(accountDebitOrCredit.equalsIgnoreCase(debitOrCredit))
             value = valueG;
         else
             value = "-" + valueG;
         
         return value;
     }

}
