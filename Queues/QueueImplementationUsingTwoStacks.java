import java.util.*;


public class QueueImplementationUsingTwoStacks {

    
    Stack<Integer> s1;
    Stack<Integer> s2;

    public QueueImplementationUsingTwoStacks()
    {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }

    void enqueue(int e)
    {
      s1.push(e);
    }

int dequeue()
{
    while(!s1.isEmpty())
    {
        s2.push(s1.pop());
    }
    int res = s2.peek();
    s2.pop();

    while(!s2.isEmpty())
    {
        s1.push(s2.pop());
    }

    return res;
}

int frontElementPeek()
{
 
    while(!s1.isEmpty())
    {
        s2.push(s1.pop());
    }
    int res = s2.peek();
    
    
    while(!s2.isEmpty())
    {
        s1.push(s2.pop());
    }

    return res;

}
public static void main(String[] args) {

    Scanner in = new Scanner(System.in);
QueueImplementationUsingTwoStacks qn = new QueueImplementationUsingTwoStacks();
int ch;

do
        {
        System.out.println("1. Enqueue 2. Dequeue 3. Display 4. Front Element 5. Exit");
        System.out.println("Enter Your Choice No.");

        ch = in.nextInt();

        switch(ch)
        {
            case 1: System.out.println("Enter Data Into Queue ==>");
                    int n = in.nextInt();
                    qn.enqueue(n);
                    break;
            case 2: int del = qn.dequeue();
                    System.out.println("Data Removed ==> "+del );
                    break;
            case 3: System.out.println(qn.s1);
            break;

            case 4: int f = qn.frontElementPeek();
                    System.out.println(f);
                    break;
            case 5: break;
            default: System.out.println("Invalid Choice!!");

        }
    } while(ch!=5);
  

    


    
}
}
