class PalNode
{
    PalNode next;
    String data;

    PalNode(String data)
    {
        this.data=data;
    }

    static boolean palindromeCheck(PalNode head)
    {
        if (head == null)
        return true;

        PalNode cur = head;
        PalNode mid = middle(head);
        PalNode tail = reverse(mid.next);

        while(tail!=null)
        {
            if(cur.data!=tail.data)
            return false;

            cur=cur.next;
            tail=tail.next;

        }
        return true;
    }
    static PalNode middle (PalNode head)
    {
       PalNode fast=head;
       PalNode slow=head;

       while(fast.next!=null && fast!=null)
       {
           fast=fast.next.next;
           slow=slow.next;
       }
       return slow;
    }
    static PalNode reverse(PalNode head)
    {
        PalNode prev = null;
        PalNode cur = head;

        while(cur!=null)
        {
           PalNode temp = cur.next;
           cur.next = prev;
           prev = cur;
           cur = temp;

        }
        return prev;
    }

    public static void main(String args[])
    {
        PalNode n1 = new PalNode("T");
        PalNode n2 = new PalNode("O");
        PalNode n3 = new PalNode("T");

        PalNode head = n1;
        head.next = n2;
        n2.next = n3;
        n3.next = null;

        boolean flag = palindromeCheck(head);
        if(flag==true)
        System.out.println("Palindrome");
        else
        System.out.println("Not Palindrome");


    }
}