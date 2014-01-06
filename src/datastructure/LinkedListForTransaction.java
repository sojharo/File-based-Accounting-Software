
package datastructure;

/**
 *
 * @author MR
 */
public class LinkedListForTransaction {

    protected Node2 list=null;
    protected Node2 tail=null;
    protected Node2 currentTransaction = null;
    String accountName;
    int ref;
    String accountType;


    public LinkedListForTransaction(String accountName, int ref, String accountType)
    {
        this.accountName=accountName;
        this.ref=ref;
        this.accountType=accountType;
    }

    public boolean isEmpty()
    {
        return (list==null);
    }


    public int size()
    {
        Node2 current=list;
        int numItems = 0;
        while(current != null)
        {
            numItems++;
            current = current.link;
        }
        return numItems;
    }
    
    //public void makeListEmpt


   /* public boolean contains(String item)
    {
        Node2 current = list;
        while(current != null && current.item.compareTo(item) != 0)
            current=current.link;
        return current != null;
    }*/

    public void add(String date , float value, String narration)
    {
        Node2 item = new Node2(date , value, narration);
        if(list == null)
        {
            list=item;
            tail=item;
        }
        else
        {
            tail.link=item;
            tail=tail.link;
        }
    }

   /* public void remove(String item)
    {
        Node2 current = list;
        Node2 prior = null;
        while(current != null && current.item.compareTo(item) != 0)
        {
            prior = current;
            current = current.link;
        }
        if(current != null)
        {
            if(current == tail)
                tail=prior;
            if(prior == null)
                list = list.link;
            else
                prior.link = current.link;
        }
    }*/


    public void resetList()
     {
          currentTransaction = list;
     }


    public boolean hasNext()
     {
         return (currentTransaction != null);
     }


    public String nextTransaction()
     {
         String item = currentTransaction.transaction;
         currentTransaction = currentTransaction.link;
         return item;
     }


}
