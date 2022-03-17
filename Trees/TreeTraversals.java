public class TreeTraversals extends CreatingTrees {

    static void inOrder(Node root)
    {
         if (root == null)
         {
             return;
         }

         inOrder(root.left);
         System.out.println(root.data);
         inOrder(root.right);
    }

    static void preOrder(Node root)
    {
        if (root == null)
        {
            return;
        }

        System.out.println(root.data);
        inOrder(root.left);
        inOrder(root.right);
    }

    static void postOrder(Node root)
    {
        if (root == null)
        {
            return;
        }

        postOrder(root.left);
        postOrder(root.right);
        System.out.println(root.data);
    }
    public static void main(String[] args) {
        Node t = createTree();
        inOrder(t);
        preOrder(t);
        postOrder(t);
    }

   
    
}
