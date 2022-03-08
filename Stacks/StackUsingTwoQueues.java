import java.util.*;
public class StackUsingTwoQueues {
    Queue<Integer> q1;
    Queue<Integer> q2;

    public StackUsingTwoQueues()
    {
        q1 = new ArrayDeque<>();
        q2 = new ArrayDeque<>();
    }

    void spush(int e)
    {
        
        q2.offer(e);
        
        while(!q1.isEmpty())
        {
            q2.offer(q1.poll());
        }
        

        while(!q2.isEmpty())
        {
            q1.offer(q2.poll());
        }


    }

    int spop()
    {
        int res = q1.poll();
        return res;
    }

    int frontElementPeek()
    {
        int res = q1.peek();
        return res;
    }

    public static void main(String[] args) {

        try (Scanner in = new Scanner(System.in)) {
            StackUsingTwoQueues sn = new StackUsingTwoQueues();
            int ch;
            
            do
                    {
                    System.out.println("1. Push 2. Pop 3. Display 4. Front Element 5. Exit");
                    System.out.println("Enter Your Choice No.");
            
                    ch = in.nextInt();
            
                    switch(ch)
                    {
                        case 1: System.out.println("Enter Data Into Stack ==>");
                                int n = in.nextInt();
                                sn.spush(n);
                                break;
                        case 2: int del = sn.spop();
                                System.out.println("Data Removed ==> "+del );
                                break;
                        case 3: System.out.println(sn.q1);
                        break;
            
                        case 4: int f = sn.frontElementPeek();
                                System.out.println(f);
                                break;
                        case 5: break;
                        default: System.out.println("Invalid Choice!!");
            
                    }
                } while(ch!=5);
        }
        
    }
}
