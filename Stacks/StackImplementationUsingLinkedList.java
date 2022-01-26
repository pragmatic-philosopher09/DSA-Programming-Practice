public class StackImplementationUsingLinkedList
{
    
    static class Node
    {
        int data;
        Node next;
        Node head;
        int size;
        public Node(int data)
        {
            this.data=data;
            this.next=null;
            size=0;
        }
        void push(int data)
        {
            Node temp = new Node(data);
            temp.next=head;
            head=temp;
            temp=head;
            size++;
        }
        int pop() throws Exception
        {   
            
            
            if(head==null)
            throw new Exception("No Element Found!!");
            else{
            int res=head.data;
            size--;
            head=head.next;
            return res;
        }
    }
        int peek() throws Exception
        {
            if(head==null)
            throw new Exception("No Element Found!!");

            else
            return head.data;
        }

        boolean isEmpty()
        {
            return head==null;
        }

        int sizeStack()
        {
            return size;
        }
        
       
    }
    public static void main(String[] args) throws Exception {

         StackImplementationUsingLinkedList.Node n1 = new StackImplementationUsingLinkedList.Node(0);
         n1.push(1);
         n1.push(2);
         n1.push(3);
         System.out.println(n1.peek());
         System.out.println(n1.sizeStack()+1);
         System.out.println(n1.pop());
         System.out.println(n1.peek());
         System.out.println(n1.sizeStack()+1);
        
    }
    
}