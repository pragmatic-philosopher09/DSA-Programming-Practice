import java.util.*;
public class StackCollectionFramework {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Stack<Integer> st = new Stack<>();

        for(int i = 0;i<10;i++)
        {
            st.push(in.nextInt());
        }
        System.out.println("Intial Elements In Stack ==> " + st);
        
        System.out.println(st.peek());
        System.out.println(st.pop());

        System.out.println("Leftover Elements In Stack ==> "+st);

    }
    
}
