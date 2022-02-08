import java.io.*;
import java.util.*;


  public class LRUDesign {

    public static void main(String[] args) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {

            int capacity = Integer.parseInt(read.readLine());
            int queries = Integer.parseInt(read.readLine());
            LRUCache cache = new LRUCache(capacity);
            String str[] = read.readLine().trim().split(" ");
            int len = str.length;
            int itr = 0;

            for (int i = 0; (i < queries) && (itr < len); i++) {
                String queryType = str[itr++];
                if (queryType.equals("SET")) {
                    int key = Integer.parseInt(str[itr++]);
                    int value = Integer.parseInt(str[itr++]);
                    cache.set(key, value);
                }
                if (queryType.equals("GET")) {
                    int key = Integer.parseInt(str[itr++]);
                    System.out.print(cache.get(key) + " ");
                }
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


// design the class in the most optimal way

class LRUCache
{
    //Constructor for initializing the cache capacity with the given value.
    Node head = new Node(0,0);
    Node tail = new Node(0,0);
    
    Map<Integer, Node> m = new HashMap<>();
    int capacity;
    LRUCache(int cap)
    {
        //code here
        capacity = cap;
        head.next = tail;
        tail.prev= head;
    }

    //Function to return value corresponding to the key.
    public int get(int key)
    {
        // your code here
        if(m.containsKey(key))
        {
            Node n = m.get(key);
            remove(n);
            insert(n);
            return n.value;
        }
        else
        {
            return -1;
        }
    }

    //Function for storing key-value pair.
    public void set(int key, int value)
    {
        // your code here
        if(m.containsKey(key))
        remove(m.get(key));
        
        if(m.size()==capacity)
        remove(tail.prev);
        
        insert(new Node(key,value));
    }
    void remove(Node n)
    {
        m.remove(n.key);
        n.prev.next = n.next;
        n.next.prev = n.prev;
        
    }
    
    void insert(Node n)
    {
        m.put(n.key, n);
        Node headNext = head.next;
        
        head.next = n;
        n.prev = head;
        
        n.next = headNext;
        headNext.prev = n;
    }
    class Node
    {
        Node prev, next;
        int key, value;
        Node (int key, int value)
        {
            this.key=key;
            this.value=value;
        }
    }
}
