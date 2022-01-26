class Node 
{
    int data;
    Node next;
    Node (int data)
    {
        this.data = data;
    }
    static void traverse(Node head)
    {
        Node ptr=head;
        while (ptr!=null)
        {
            System.out.print(ptr.data + "-->");
            ptr=ptr.next;
        }
    }
    static void delete(Node head, int index)
    {
        Node prev=head;
        if(index==0)
        {
            head=head.next;
            return;
        }
        else{
            for(int i=0;i<index-1;i++)
            {
                prev=prev.next;
            }
            prev.next = prev.next.next;
        }
    }
    static void insert(int data, Node head, int index)
    {
        Node toAdd = new Node(data);
        Node prev = head;
        if (index==0)
        {
            toAdd.next = head;
            head = toAdd;
            return;
        }
        else
        {
            for(int i=0;i<index-1;i++)
            {
                prev=prev.next;
            }
            toAdd.next=prev.next;
            prev.next=toAdd;
        }
    }
    static Node reverseLinkedListIteratively(Node head)
    {
          Node cur = head;
          Node prev = null;
          while (cur != null)
          {
             Node temp = cur.next;
             cur.next=prev;
             prev = cur;
             cur = temp;
          }
          return prev;
    }
    static Node reverseLinkedListRecursively(Node head)
    {
        if(head.next == null || head ==null)
        {
            return head;
        }
        Node newHead = reverseLinkedListRecursively(head.next);
        Node headNext = head.next;
        headNext.next = head;
        head.next = null;
        return newHead;

    }
    public static void main(String [] args)
    {
        Node n1 = new Node(10);
        Node n2 = new Node(20);
        Node n3 = new Node(30);
        Node n4 = new Node(40);
        Node head = n1;
        head.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next= null;
        
        traverse(head);
        insert(12,head,2);
        System.out.println();
        traverse(head);
        delete(head,1);
        System.out.println();
        traverse(head);
        System.out.println();
        insert(64, head, 3);
        insert(72, head, 1);
        insert(69, head, 0);

        System.out.println("Linked List Now ==>");
        traverse(head);
        System.out.println("\nLinked List After Reversal (Iterative Approach)==>");
      
        Node rll = reverseLinkedListIteratively(head);
        traverse(rll);
        System.out.println("\nLinked List After Reversal (Recursive Approach)==>");
        Node rll2 = reverseLinkedListRecursively(rll);
        traverse(rll2);
    }
    
}

