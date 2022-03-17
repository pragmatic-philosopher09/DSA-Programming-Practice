import java.util.*;

class Node
{
    Node left, right;
    int data;

    public Node(int data)
    {
        this.data=data;
      
    }
}
public class CreatingTrees {
    static Node createTree()
    {
       Scanner in = new Scanner(System.in);
            Node root = null;

            System.out.println("ENTER DATA ==> ");
            
            int d = in.nextInt();
      

            if (d == -1)
            return null;

            root = new Node(d);
            
            System.out.println("ENTER LEFT FOR : "+d);
            root.left = createTree();

            System.out.println("ENTER RIGHT FOR : "+d);
            root.right = createTree();

            return root;
        }
    
    

    public static void main(String[] args) {
        createTree();
    }
}
