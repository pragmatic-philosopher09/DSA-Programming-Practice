class CycNode{

    CycNode next;
    int data;

    CycNode(int data)
    {
        this.data = data;
    }

    static CycNode detectCycle(CycNode head)
    {
        CycNode fast = head;
        CycNode slow = head;

        while (fast.next!=null && fast!=null)
        {
            fast = fast.next.next;
            slow = slow.next;

            if(slow == fast)
            return slow;
        }
        return null;
    }

    static CycNode cyclePoint(CycNode head)
    {
        CycNode start = head;
        CycNode meet = detectCycle(start);
        while (meet != start)
        {
            start=start.next;
            meet=meet.next;
        }
        return start;
    }
    public static void main(String args[])
    {
       CycNode n1 = new CycNode(1);
       CycNode n2 = new CycNode(2);
       CycNode n3 = new CycNode(3);
       CycNode n4 = new CycNode(4);
       CycNode n5 = new CycNode(5);
       CycNode n6 = new CycNode(6);

       CycNode head = n1;
       head.next = n2;
       n2.next = n3;
       n3.next = n4;
       n4.next = n5;
       n5.next = n6;
       n6.next = n3;

       CycNode dc = detectCycle(head);

       if (dc == null)
       {
           System.out.println("No Cycle Detected");
       }

       else{
        CycNode cy = cyclePoint(head);   
        System.out.println("Cycle Detected At ==> "+cy.data);
       }
       

    }
    
}
