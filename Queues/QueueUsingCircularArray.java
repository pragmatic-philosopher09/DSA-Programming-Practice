import java.util.*;

public class QueueUsingCircularArray {

    int front;
    int rear;
    int cap;
    int q[];
    public QueueUsingCircularArray(int n)
    {
        cap=n;
        q = new int[cap];
        front=rear=-1;
    }

    void enqueue(int d) 
    {
       if(front==-1)
       {
       front++;
     
       }
       rear=(rear+1)%cap;
       if((rear+1)%cap==front)
       {
           System.out.println("Queue Full! Cannot Enter!");
           return;
       }
       
       q[rear]=d;
    }

    int dequeue() throws Exception
    {
        if(front==-1)
        {
            throw new Exception();
        }
        int res;
        res = q[front];

        if(front==rear)
        {
            front=rear=-1;
        }
        else{
            front=(front+1)%cap;

        }
        return res;

        
}
void display()
{
     if(front<=rear)
     {
         for(int i = front; i<=rear;i++)
         {
             System.out.print(q[i]+ " ");
         }
     }

     else{
         for(int i=front;i<cap;i++)
         {
             System.out.print(q[i] + " ");
         }

         for(int i=0;i<=rear;i++)
         {
             System.out.print(q[i]+ " ");
         }
     }
     System.out.println();
}

    public static void main(String[] args) throws Exception {
       
        int ch;
        Scanner in = new Scanner(System.in);
        int num;
        System.out.println("Enter No. Of Elements For Array ==> ");
        num=in.nextInt();

        QueueUsingCircularArray obj = new QueueUsingCircularArray(num);
        do
        {
        System.out.println("1. Enqueue 2. Dequeue 3. Display 4. Exit");
        System.out.println("Enter Your Choice No.");

        ch = in.nextInt();

        switch(ch)
        {
            case 1: System.out.println("Enter Data Into Queue ==>");
                    int n = in.nextInt();
                    obj.enqueue(n);
                    break;
            case 2: int del = obj.dequeue();
                    System.out.println("Data Removed ==> "+del );
                    break;
            case 3: obj.display();
            break;

            case 4: break;
            default: System.out.println("Invalid Choice!!");

        }
    } while(ch!=4);
        
    }
    
}
