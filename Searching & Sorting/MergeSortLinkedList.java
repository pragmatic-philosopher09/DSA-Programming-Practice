import java.util.*;
import java.lang.*;
import java.io.*;

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

class MergeSortLinkedList
{
    
    public static void main (String[] args) 
    {
        try (Scanner sc = new Scanner(System.in)) {
            int t = sc.nextInt();
            
            while(t-- > 0)
            {
                int n = sc.nextInt();
                Node head = new Node(sc.nextInt());
                Node tail = head;
                while(n-- > 1){
                    tail.next = new Node(sc.nextInt());
                    tail = tail.next;
                }
               
                  head = new SolP().mergeSort(head);
                 printList(head);
                System.out.println();
            }
        }
    }
    public static void printList(Node head)
    {
        if(head == null)
           return;
           
        Node temp = head;
        while(temp != null)
        {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }
}


// } Driver Code Ends


//User function Template for Java
/*
class Node
{
    int data;
    Node next;
    Node(int key)
    {
        this.data = key;
        next = null;
    }
} */

class SolP
{
    //Function to sort the given linked list using Merge Sort.
    
  
    
    static Node merge(Node ll1, Node ll2)
    {
        Node dummy = new Node(0);
        Node curr = dummy;
        
        while(ll1 != null && ll2 != null)
        {
            if(ll1.data<=ll2.data)
            {
                curr.next=ll1;
                ll1=ll1.next;
            }
            
            else
            {
                curr.next=ll2;
                ll2 = ll2.next;
            }
            curr=curr.next;
        }
        
        if(ll1==null)
        curr.next=ll2;
        
        else
        curr.next=ll1;
        
        return dummy.next;
    }
    Node mergeSort(Node head)
    {
        // add your code here
        
       
        
        if(head == null || head.next==null)
        {
            return head;
        }
        
        
        
         Node temp = null, slow = head, fast = head;
         
        while(fast!=null&&fast.next!=null){
            temp = slow;
            slow =slow.next;
            fast = fast.next.next;
        }
        
        
        temp.next=null;
       
        Node ll1 = mergeSort(head);
       Node ll2 = mergeSort(slow);
       return merge(ll1,ll2);
        
    }
}
