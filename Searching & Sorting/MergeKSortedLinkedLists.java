import java.util.*;

class Node
{
    int data;
    Node next;
    
    Node(int key)
    {
        data = key;
        next = null;
    }
}


public class MergeKSortedLinkedLists
{
    public static void printList(Node node)
    {
        while(node != null)
        {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }
    
    public static void main (String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int t = sc.nextInt();
            while(t-- > 0)
            {   
                int N = sc.nextInt();
                
                Node []a = new Node[N];
                
                for(int i = 0; i < N; i++)
                {
                    int n = sc.nextInt();
                    
                    Node head = new Node(sc.nextInt());
                    Node tail = head;
                    
                    for(int j=0; j<n-1; j++)
                    {
                        tail.next = new Node(sc.nextInt());
                        tail = tail.next;
                    }
                    
                    a[i] = head;
                }
                
                So g = new So();
                 
                Node res = g.mergeKList(a,N);
                if(res!=null)
                    printList(res);
                System.out.println();
            }
        }
    }
}// } Driver Code Ends


/*class Node
{
    int data;
    Node next;
    
    Node(int key)
    {
        data = key;
        next = null;
    }
}
*/

// a is an array of Nodes of the heads of linked lists
// and N is size of array a


class So
{
    //Function to merge K sorted linked list.
    
    static Node merge(Node ll1, Node ll2)
    {
        ArrayList<Integer> a = new ArrayList<>();
        if(ll1 == null && ll2 == null)
        {
            return null;
        }
        
        Node curr1 = ll1;
        Node curr2 = ll2;
        
        while(curr1 != null && curr2 != null)
        {
            if(curr1.data == curr2.data)
            {
                a.add(curr1.data);
                a.add(curr2.data);
                curr1=curr1.next;
                curr2=curr2.next;
            }
            
            else if(curr1.data<curr2.data)
            {
                a.add(curr1.data);
                curr1=curr1.next;
            }
            
            else
            {
                a.add(curr2.data);
                curr2=curr2.next;
            }
        }
        
        while(curr1!=null)
        {
            a.add(curr1.data);
            curr1=curr1.next;
        }
        
        while(curr2!=null)
        {
            a.add(curr2.data);
            curr2=curr2.next;
        }
        
        Node appendedList = new Node(a.get(0));
        Node curr= appendedList;
        for(int i =1;i<a.size();i++)
        {
            curr.next = new Node(a.get(i));
            curr=curr.next;
        }
        return appendedList;
        
    }
    Node mergeKList(Node[]arr,int K)
    {
        //Add your code here.
       
       for(int i=0;i<K-1;i++)
       {
           arr[i+1] = merge(arr[i],arr[i+1]);
       }
       
       return arr[K-1];
        
        
    }
}