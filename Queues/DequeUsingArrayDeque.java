import java.util.ArrayDeque;

public class DequeUsingArrayDeque {
    public static void main(String[] args) {
        ArrayDeque<Integer> dq = new ArrayDeque<>();

        dq.addFirst(24); //Alternative To This Is offerFirst
        dq.addFirst(48);
        dq.addFirst(72);

        dq.addLast(120); //Alternative To This Is offerLast
        dq.addLast(144);
        dq.addLast(168);

        System.out.println("Deque Now ==> "+dq);

        System.out.println("Removed Element ==> "+dq.pollFirst()); //Alternative To This Is removeFirst
        System.out.println("Removed Element ==> "+dq.pollLast()); //Atlernative To This Is removeLast

        System.out.println("Deque Now ==> "+dq);
        
        System.out.println("Front Element Now ==> "+dq.peekFirst()); //Alternative To This Is getFirst
        System.out.println("Back Element Now ==> "+dq.peekLast()); //Alternative To This Is getLast
        
        


    }
    
}
