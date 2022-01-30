import java.util.*;
import java.lang.*;
import java.io.*;

class EvaluationofPostfix {
    
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
		    System.out.println(new Solution().evaluatePostFix(br.readLine().trim()));
		}
	}
}// } Driver Code Ends


class Solution
{
    //Function to evaluate a postfix expression.
    public static int evaluatePostFix(String S)
    {
        // Your code here
        char ch;
        
        int n1,n2;
        Stack<Integer> num = new Stack<>();
        for(int i=0;i<S.length();i++)
        {
            ch = S.charAt(i);
            
            if(Character.isDigit(ch))
            {
                num.push(ch-'0');
            }
            else if(ch =='+' || ch =='-' || ch =='*' || ch=='/')
            {
                
                    n1 = num.peek();
                    num.pop();
                    
                    n2 = num.peek();
                    num.pop();
                    
                    switch(ch)
                    {
                        case '+':num.push(n2+n1);
                        break;
                        
                        case '-':num.push(n2-n1);
                        break;
                        
                        case '*':num.push(n1*n2);
                        break;
                        
                        case '/':num.push(n2/n1);
                        break;
                    }

            }
        }
        
        return num.pop();
    }
}