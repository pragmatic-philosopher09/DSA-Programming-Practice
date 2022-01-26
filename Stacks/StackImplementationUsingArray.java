class StackImplementationUsingArray
{
    int stack[];
    int capacity;
    int top;
    public StackImplementationUsingArray(int capacity)
    {
        this.capacity = capacity;
        top=-1;
        stack = new int[capacity];
    }

    void push(int element) throws Exception
    {
       if(top==capacity)
       {
           throw new Exception("Overflow");
       }

       else{
           top++;
           stack[top] = element;
       }
    }
    int pop() throws Exception
    {
        if(top==-1)
       {
           throw new Exception("Underflow");

       }
       int res = stack[top];
       top--;

        return res;
    }

    int peek() throws Exception
    {
        if(top==-1)
       {
        throw new Exception("No Element!!");
       }

        return stack[top];
    }

    boolean isEmpty()
    {
       return top==-1;
    }

 public static void main(String[] args) throws Exception {
     StackImplementationUsingArray s = new StackImplementationUsingArray(3);
     s.push(1);
     s.push(2);
     s.push(3);
     int t = s.peek();
     System.out.println("Top Element Now ==> "+t);
     System.out.println(s.pop());
     System.out.println("Top Element Now ==> "+s.peek());
     System.out.println("Stack Is Empty ==> "+s.isEmpty());
     
 }
}