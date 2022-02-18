import java.util.Scanner;

class Node
{
    int data;
    Node next;

    public Node(int data)
    {
        this.data=data;
        this.next=null;
    }
}

class QueueImplementationUsingLinkedList 
{
   
    static Node front, rear;
    
    static void enqueue(int data)
    {
       Node newNode = new Node(data);
        if (front==null)
       {
           front=rear=newNode;
           
       }
       else{
           rear.next = newNode;
           rear = newNode;
       }
    }

    static int dequeue() throws Exception
    {
        if(front==null)
        {
           throw new Exception();
        }

        else
        {
            int res = front.data;
            front=front.next;

            return res;

        }
    }
    static void display(Node front)
    {
        Node ptr=front;

        while(ptr!=null)
        {
            System.out.print(ptr.data+"-->");
            ptr=ptr.next;
        }
        System.out.println();
    }
    public static void main(String[] args) throws Exception {
        int ch;
        Scanner in = new Scanner(System.in);
        do
        {
        System.out.println("1. Enqueue 2. Dequeue 3. Display 4. Exit");
        System.out.println("Enter Your Choice No.");

        ch = in.nextInt();

        switch(ch)
        {
            case 1: System.out.println("Enter Data Into Queue ==>");
                    int n = in.nextInt();
                    enqueue(n);
                    break;
            case 2: int del = dequeue();
                    System.out.println("Data Removed ==> "+del );
                    break;
            case 3: display(front);
            break;

            case 4: break;
            default: System.out.println("Invalid Choice!!");

        }
    } while(ch!=4);
}
}