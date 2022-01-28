import java.util.*;
public class QueueLibrary {
    public static void main(String[] args) {
        Queue<Integer> q1 = new LinkedList<Integer>(); //As Queue Is An Interface 
        Queue<Integer> q2 = new ArrayDeque<>();       //So It Has To Use These Classes
        
        /* It is recommended that Queue interface should try to implement ArrayDeque class
        which doesn't make use of caching and hence more comprehensive and trouble-less, as
        opposed to the LinkedList class. */

        //Methods that don't throw an Exception on encountering one

        q1.offer(69);
        q2.offer(71);
        q1.offer(44);
        q2.offer(77);
        q1.offer(23);

        System.out.println("Queue #1 Now ==> "+q1);
        System.out.println("Queue #2 Now ==> "+q2);

        q1.peek();
        q2.peek();

        q1.poll();
        q2.poll();

        System.out.println("Queue #1 Now ==> "+q1);
        System.out.println("Queue #2 Now ==> "+q2);

        System.out.println("Queue #1 Is Empty ==> "+q1.isEmpty());
        System.out.println("Queue #2 Is Empty ==> "+q2.isEmpty());

        //Methods that throw an Exception on encountering one
        
        q1.add(19);
        q1.add(78);
        q2.add(11);
        q2.add(9);

        System.out.println("Queue #1 Now ==> "+q1);
        System.out.println("Queue #2 Now ==> "+q2);


        q1.remove();
        q2.remove();

        System.out.println("Queue #1 Now ==> "+q1);
        System.out.println("Queue #2 Now ==> "+q2);






    }
    
}
