import java.util.HashMap;
import java.util.Map;

public class HashMapPractice {
    public static void main(String[] args) {
        Map<Integer,String> h = new HashMap<>();

        h.put(1,"One");
        h.put(2, "Two");
        h.put(3,"Three");
        h.put(4, "Four");

        System.out.println(h.get(1));

        System.out.println(h);

        for (Map.Entry<Integer, String> e: h.entrySet()) {
            //            System.out.println(e);

        System.out.println(h.containsKey(2));
        System.out.println(h.containsValue("Seven"));
    }
    
}
}
