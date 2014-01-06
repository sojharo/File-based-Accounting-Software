
package readwriteio;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.JOptionPane;

public class CompanyName {
    
    static String companyName;
    
    public static void writeName(String name) throws IOException
    {
        FileWriter companyName=new FileWriter("Company Name.dat");
        PrintWriter namer=new PrintWriter(companyName);
        
        namer.print(name);
        
        namer.close();
    }
    
    public static String readName() throws IOException
    {
         FileReader fr;
         BufferedReader br=null;
         try{
            fr = new FileReader("Company Name.dat");
            br = new BufferedReader(fr);
         }catch(FileNotFoundException e)
         {
             String name;
             try{
                name = JOptionPane.showInputDialog(null, "It seems that"
                        + " you are using this software for the first time.\n"
                        + "Kindly write the name of your business. This name will\nbe used"
                        + " as a company name in all financial statements");
             
                while(name.trim().equals(""))
                    name = JOptionPane.showInputDialog("Kindly give the proper name of the "
                             + "business.");
             }catch(NullPointerException d)
             {
                 name="";
                 return name;
             }
             writeName(name);
             
             fr = new FileReader("Company Name.dat");
             br = new BufferedReader(fr);
         }
         
         companyName=br.readLine();
         
         br.close();
         
         return companyName;
    }
}
