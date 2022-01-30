import java.util.ArrayDeque;

public class StackUsingArrayDeque {

    public static void main(String[] args) {
        ArrayDeque<Integer> s = new ArrayDeque<>();

        s.push(12);
        s.push(69);
        s.push(34);

        System.out.println("Stack Now ==> "+s);

        System.out.println("Element Removed ==> " + s.pop());

        System.out.println("Front Element Now ==> "+s.peek());
    }
    
}
