import java.util.*;

class LNode
{
    int data;
    LNode next;
    LNode(int d) {
        data = d; 
        next = null;
    }
}

class TNode
{
    int data;
    TNode left, right;
    TNode(int x)
    {
        data=x;
        left=right=null;
    }
    
}


class SortedLinkedListToBST
{
    
  /* Function to print linked list */
   public static void preOrder(TNode root)
    {
        
        if(root==null)
            return;
            
        System.out.print(root.data+" ");
        preOrder(root.left);
        preOrder(root.right);
    }
	
	 
 
     /* Driver program to test above functions */
    public static void main(String args[])
    {
       
         
        /* Constructed Linked List is 1->2->3->4->5->6->
           7->8->8->9->null */
         Scanner sc = new Scanner(System.in);
		 int t=sc.nextInt();
		 
		 while(t>0)
         {
			int n = sc.nextInt();
			LNode head = new LNode(sc.nextInt());
            LNode tail = head;
            for(int i=0; i<n-1; i++)
            {
                tail.next = new LNode(sc.nextInt());
                tail = tail.next;
            }
		
			Solution obj = new Solution();
			TNode root = obj.sortedListToBST(head);
			preOrder(root);
			
			System.out.println();
			
			t--;
			
         }
    }
}
// } Driver Code Ends


//User function Template for Java

/*Linked List Node
class LNode
{
    int data;
    LNode next;
    LNode(int d) {
        data = d; 
        next = null;
    }
}

//Tree Node
class TNode
{
    int data;
    TNode left, right;
    TNode(int x)
    {
        data=x;
        left=right=null;
    }
    
}*/

class Solution
{
    public static TNode BSTFunction(ArrayList<Integer> ar, int start, int end)
    {
        if (start > end)
        return null;
        
        int mid = (start+end+1)/2;
        
        TNode node = new TNode(ar.get(mid));
        
        node.left = BSTFunction(ar, start, mid-1);
        node.right = BSTFunction(ar, mid+1, end);
        
        return node;
    }
    public TNode sortedListToBST(LNode head)
    {
        //code here
        
        ArrayList<Integer> ar = new ArrayList<>();
        int count = 0;
        
        while(head != null)
        {
            ar.add(head.data);
            head = head.next;
            count++;
        }
        
        int start = 0;
        int end = count-1;
        
        return BSTFunction(ar, start, end);
        
    }
}
