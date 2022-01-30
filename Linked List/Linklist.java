import java.util.*;
public class Linklist {
    public static void main(String[] args) {
        LinkedList<Integer> ll = new LinkedList<>();
        ll.add(1);
        ll.add(2);
        ll.add(3);
        ll.add(4);
        
        System.out.println("LinkedList Now ==> "+ll);
        System.out.println("Elements of Linked List Demonstrated ==> ");
        for(int i=0;i<ll.size();i++)
        {
           System.out.println(ll.get(i));
        }
        ll.remove(1);

        System.out.println("LinkedList Now ==> "+ll);
        
    }
    
}
