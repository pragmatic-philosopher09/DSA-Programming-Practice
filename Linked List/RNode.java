public class RNode {

    RNode next;
    RNode random;
    int data;

    RNode (int data)
    {
        this.data = data;
    }

    static void traverse (RNode head)
    {
        RNode ptr = head;

        while (ptr!=null)
        {
            System.out.print(ptr.data+"-->");
            ptr=ptr.next;
        }
        System.out.println();
    }

    static RNode duplicateLinkedList(RNode head)
    {
        RNode temp;
        RNode cur = head;

        //Inserting Duplicate Nodes In Between Normal LL

        while(cur!=null)
        {
            temp = cur.next;
            cur.next = new RNode(cur.data);
            cur.next.next = temp;
            cur=temp;
        }

        cur = head;

        //Inserting Random Pointers Into Duplicate LL

        while(cur!=null)
        {
            if (cur.next!=null)
            {
            cur.next.random = (cur.random!=null) ? (cur.random.next) : null;
            }
            cur = cur.next.next;
        }

        //Delinking The Duplicate LL
        RNode orig = head;
        RNode copy = head.next;
        temp = copy;

        while(orig!=null)
        {
            orig.next = orig.next.next;
            if (copy.next!=null)
            copy.next = copy.next.next;
            
            orig=orig.next;
            copy=copy.next;     
        }

        return temp;

    }

    public static void main(String[] args) {
        RNode n1 = new RNode(1);
        RNode n2 = new RNode(2);
        RNode n3 = new RNode(3);
        RNode n4 = new RNode(4);
        RNode n5 = new RNode(5);

        //Creating Normal Pointers

        RNode head=n1;
        head.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = null;
        
        //Fixing Random Pointers

        head.random=n3;
        n2.random = n1;
        n3.random = n3;
        n4.random = n2;
        n5.random = n4;

        System.out.println("Original Linked List ==> ");
        traverse(head);
        RNode dupll = duplicateLinkedList(head);
        System.out.println("Duplicate Linked List ==> ");
        traverse(dupll);


    }
    
}
