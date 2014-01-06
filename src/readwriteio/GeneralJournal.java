
package readwriteio;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class GeneralJournal {

    static ArrayList<String> hold=new ArrayList<String>();
    
    public static void updateJournal(String date, String accountsWithValues1,
            String accountsWithValues2, String accountsWithValues3,
            String accountsWithValues4, String narration) throws FileNotFoundException, IOException
    {
         FileReader fr=null;
         BufferedReader br=null;
            
         try
         {
            fr = new FileReader("GeneralJournal.dat");
            br = new BufferedReader(fr);
         }catch(FileNotFoundException e)
         {
             FileWriter resultFile=new FileWriter("GeneralJournal.dat");
             PrintWriter forResultFile=new PrintWriter(resultFile);
             
             forResultFile.close();

             fr = new FileReader("GeneralJournal.dat");
             br = new BufferedReader(fr);
         }
         
         String s=br.readLine();
         
         while(s!=null)
         {
             hold.add(s);
         }
         
         br.close();
         
         FileWriter resultFile=new FileWriter("GeneralJournal.dat");
         PrintWriter forResultFile=new PrintWriter(resultFile);
         
         for(int i=0; i<hold.size(); i++)
         {
             forResultFile.println(hold.get(i));
         }
         
         forResultFile.println(date);
         forResultFile.println(accountsWithValues1);
         forResultFile.println(accountsWithValues2);
         if(!accountsWithValues3.equals(""))
             forResultFile.println(accountsWithValues3);
         if(!accountsWithValues4.equals(""))
             forResultFile.println(accountsWithValues4);
         forResultFile.println(narration);
         
         forResultFile.close();
         
         hold.clear();
    }
    
    
}
