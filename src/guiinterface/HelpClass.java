package guiinterface;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.event.*;

/**
 *
 * @author MR
 */
public class HelpClass extends JPanel implements ListSelectionListener{

    private JList wordList;
    private JTextArea definitionTextArea;

    private String []words={"How To Use", "Built-in Accounts", "Create New Account/s", "Make transactions", "Accounting Scope"};;
    private String []definitions={"\nIf you are using software for the first time, the software will ask company name. This company name will be dispalyed on the top. The software conisits of three tabs Chart of Accounts, New Transactions and Statement Display. The next thing viewed is 'Chart of accounts'. It displays list of accounts in four general categories i.e. Assets, Liabilities, Owner's Equity, Revenue and Expenses. The software allows to create any new account under and of the general account titles as mentioned above. Below every list is another button 'view', this buttons opens a window and shows the ledger of the selected account title.",
    "\nThe software has few built-in accounts, these built-in accounts will only be diaplayed if desired by user.\n\nThe built-in accounts include:\n1. Cash, Office Equipment, Supplies, Account Receivables under Assets account title.\n2. Account Payable, Notes Payable under liabilitites account title.\n3. Capital, Drawings under Owners Equity account title.\n4. Service Revenue under Revenue account title.\n5. Rent Expense, Advertising Expense, Supplies Expense, Salary Expense.\n\nApart from this the user can create new accounts at any time.",
    "\nEvery general account list has a create button, when pressing this button the software asks Name of account title and Type of new account i.e. 'Debit' or 'Credit' and this new account is added to the respected list. If user does not enter name of the account and presses OK button, the software will ask the user account name repeatedly unless a new account name is added or Cancel button is pressed. The ledger of this can be viewed at any time by selecting the account and press 'view'.",
    "\nUser can make transactions using atmost three corresponding accounts to the one main account. Software has the capability of checking if debit amount is not equal to credit amount. This will ensure that trial balance will always be equal. Software will disable the 'Record Transaction' button unless the credit amounts equal the debit amounts.",
    "\nThis software might not be used for merchandise accounting if you are interested in classified balance sheets and multiple income statement. Moreover, if you want to record the sales, don't assume that the four account options can be used for sales, accounts receivable/cash, cost of goods sold and inventory respectively. You have to record sales and accounts receivables first and then you will record cost of golds sold and  inventory as separate transaction.\n\nYou can make copies of this software and keep it in separate folders. In these folders complete new record will be created. You can even manage one company's record in one folder and other company's record in other folder. In a nutshell, one folder with copy of accounting software maybe used as a place of records for one separate company.\n\nIf you want to make record for several financial years then at  the end of the each year a new folder should be made. Here one folder will serve as a record of one year of the company. When you finish with one year's recording, you should make a separate folder in which you copy the software. Now when you will open that instance of the software it will again ask you for the name of the company. Give the name which you gave to the instance of the folder containing records of previous year. You will then make all accounts which your company was using. Now you will make the closing entries by closing all the temporary accounts and you will also make a new temporary account namely income summary which is also be closed later."};

    public HelpClass()
    {

        FlowLayout layout=new FlowLayout();
        layout.setAlignment(FlowLayout.LEFT);
        setLayout(layout);

        this.setBackground(new Color(200,200,240));

        wordList=new JList(words);
        wordList.setVisibleRowCount( 19 );
        wordList.setFixedCellWidth(150);
        wordList.setSelectedIndex(-1);
        wordList.setSelectionMode( ListSelectionModel.SINGLE_SELECTION );
        wordList.addListSelectionListener(this);
        add(new JScrollPane(wordList));

        definitionTextArea=new JTextArea();
        definitionTextArea.setColumns(30);
        definitionTextArea.setRows(22);
        definitionTextArea.setWrapStyleWord(true);
        definitionTextArea.setLineWrap(true);
        definitionTextArea.setText("\nSmall Business Financial Accounting Software will address the needs of small business. It creates accounts, records transactions and siaplays financial statements.");
        definitionTextArea.setEditable(false);

        add(new JScrollPane(definitionTextArea));
    }
    
    public void valueChanged(ListSelectionEvent e) {

        if(e.getValueIsAdjusting())
        {
            definitionTextArea.setText(definitions[wordList.getSelectedIndex()]);
        }
    }
}