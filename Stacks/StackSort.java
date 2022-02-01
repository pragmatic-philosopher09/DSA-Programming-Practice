import java.util.*;
public class StackSort{
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0){
			Stack<Integer> s=new Stack<>();
			int n=sc.nextInt();
			while(n-->0)
			s.push(sc.nextInt());
			Sol g=new Sol();
			Stack<Integer> a=g.sort(s);
			while(!a.empty()){
				System.out.print(a.peek()+" ");
				a.pop();
			}
			System.out.println();
		}
	}
}// } Driver Code Ends


/*Complete the function below*/
class Sol{
	public Stack<Integer> sort(Stack<Integer> s)
	{
		//add code here.
		if(s == null || s.isEmpty())
		return s;
		
		Stack<Integer> s1 = new Stack<>();
	    s1.push(s.pop());
	    
	    while(!s.isEmpty())
	    {
	        int temp = s.pop();
	        
	        while(!s1.isEmpty() && temp < s1.peek())
	        {
	            s.push(s1.pop());
	        }
	        
	        s1.push(temp);
	    }
	    return s1;
		
		
	}
}
