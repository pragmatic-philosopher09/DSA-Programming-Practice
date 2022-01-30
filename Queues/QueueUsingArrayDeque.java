import java.util.ArrayDeque;

public class QueueUsingArrayDeque {
    public static void main(String[] args) {
        ArrayDeque<Integer> q = new ArrayDeque<>();

        q.offer(12);
        q.offer(69);
        q.offer(34);

        System.out.println("Queue Now ==> "+q);

        System.out.println("Element Removed ==> " + q.poll());

        System.out.println("Front Element Now ==> "+q.peek());


    }
    
}
