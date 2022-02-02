import java.io.*;
import java.util.*; 

class CelebrityProblem{
    public static void main(String args[]) throws IOException { 
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t>0)
        {
            int N = sc.nextInt();
            int M[][] = new int[N][N];
            for(int i=0; i<N; i++)
            {
                for(int j=0; j<N; j++)
                {
                    M[i][j] = sc.nextInt();
                }
            }
            System.out.println(new ProSol().celebrity(M,N));
            t--;
        }
    } 
} // } Driver Code Ends


//User function Template for Java


class ProSol
{ 
    //Function to find if there is a celebrity in the party or not.
    int celebrity(int M[][], int n)
    {
    	// code here 
    	Stack<Integer> s = new Stack<>();
    	int i,j,celpos;
    	for(i=0;i<n;i++)
    	{
    	    s.push(i);
    	}
    	
    	while(s.size()>=2)
    	{
    	    i=s.pop();
    	    j=s.pop();
    	    
    	    if(M[i][j]==0)
    	    {
    	        s.push(i);
    	    }
    	    else if(M[j][i]==0)
    	    {
    	        s.push(j);
    	    }
    	}
    	
    	celpos = s.pop();
    	
    	for(i=0;i<n;i++)
    	{
    	    if(i!=celpos)
    	    {
    	        if(M[i][celpos]==0 || M[celpos][i]==1)
    	        return -1;
    	    }
    	}
    	return celpos;
    }
}