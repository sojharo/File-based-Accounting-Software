package mainclass;

import guiinterface.Transactions;
import guiinterface.StatementDisplay;
import guiinterface.ChartOfAccounts;
import guiinterface.HelpClass;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTabbedPane;
import readwriteio.CompanyName;
import readwriteio.ReadChartOfAccountFile;
import readwriteio.ReadLedgerFile;


public class Main extends JFrame{
    
    private JTabbedPane tabs = new JTabbedPane();


    public Main(String title) throws IOException, Exception
    {
        super(title);

	chrt = new ChartOfAccounts();
        tran = new Transactions();
        stD = new StatementDisplay();


	tabs.addTab("Chart of Accounts",chrt );
        tabs.addTab("New Transaction",tran );
        tabs.addTab("Display Statements", stD);
        add(tabs);
		
    }

    ChartOfAccounts chrt;
    Transactions tran;
    StatementDisplay stD;
    public static Main frame;


    public ChartOfAccounts getChartOfAccounts()
    {
        return chrt;
    }


    public Transactions getTransactions()
    {
        return tran;
    }


    public static void main(String []args) throws IOException, Exception
    {
        JMenu jm= new JMenu("Help");
			
	JMenuItem items = new JMenuItem("Help Contents");

        jm.add(items);

	JMenuBar mb = new JMenuBar();
			
        mb.add(jm);

        items.addActionListener(
                new ActionListener()
                {
                    public void actionPerformed(ActionEvent e)
                    {
                        JFrame help=new JFrame("Help");
                        help.setVisible(true);
                        help.setSize(515, 400);
                        help.setResizable(false);
                        help.add(new HelpClass());
                    }
                });
        
        if(!CompanyName.readName().equals(""))
        {
            frame=new Main("Accounting Software: " + CompanyName.readName());
            frame.setJMenuBar(mb);
            frame.setVisible(true);
            frame.setSize(850, 650);
            frame.setResizable(false);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            ReadChartOfAccountFile.readChartOfAccount();
            ReadLedgerFile.arrangeLedgers();
            
        }
    }
}

