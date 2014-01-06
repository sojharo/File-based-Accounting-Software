
package encryption;

//Income Statement print

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class LedgerEncrypt {

     public static String encryptLedger(String accountTitle) throws FileNotFoundException, IOException {

        final int ALIGNWIDTH=70;

        FileReader ca = new FileReader(accountTitle +".dat");
        BufferedReader sa = new BufferedReader(ca);

        StringTokenizer g=new StringTokenizer(sa.readLine(), "//");

        int accountReferenceNumber=0;

        if(g.hasMoreTokens())
            g.nextToken();
        if(g.hasMoreTokens())
            accountReferenceNumber=Integer.parseInt(g.nextToken());

        ArrayList<String> transactions=new ArrayList<String>();

        String takeLine=sa.readLine();

        while(takeLine!=null)
        {
            transactions.add(takeLine);
            takeLine=sa.readLine();
        }

        String printMaterial="";

        int forRefNo=0;
        for(int i=0; i<ALIGNWIDTH/2; i++)
        {
          printMaterial +=" ";
          forRefNo++;
        }

        printMaterial+= accountTitle;

        forRefNo+=accountTitle.length();

        int temp=(ALIGNWIDTH)-forRefNo;
        for(int i=0; i<(ALIGNWIDTH)-forRefNo; i++)
        {
            if(temp>5)
                printMaterial +=" ";
            temp--;
        }
        printMaterial+=accountReferenceNumber+"\n\n";
        StringTokenizer otherOne;

          for(int i=0; i<transactions.size(); i++)
          {
              int countChars=0;
              otherOne = new StringTokenizer(transactions.get(i), "//");

              String forDateWidth="";
              if(otherOne.hasMoreTokens())
              {
                forDateWidth=otherOne.nextToken();
                printMaterial+= forDateWidth;
                countChars+=forDateWidth.length();
              }
              for(int j=0; j<((ALIGNWIDTH-forDateWidth.length())-20); j++)
              {
                  printMaterial+=" ";
                  countChars+=1;
              }
              if(otherOne.hasMoreTokens())
              {
                String takeValue=otherOne.nextToken();
                printMaterial +=takeValue;
                countChars+=takeValue.length();
              }

              int temp1=ALIGNWIDTH-countChars;
              for(int j=0; j<ALIGNWIDTH-countChars; j++)
              {
                if(temp1>5)
                {
                    printMaterial+=" ";
                }
                temp1--;
              }

              if(otherOne.hasMoreTokens())
                  printMaterial+=otherOne.nextToken()+"\n";
          }


          System.out.print(printMaterial);

          return printMaterial;
    }
}
