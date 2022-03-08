import java.util.*;
import java.io.*;

class TripletSum
{
    public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
		while(t-->0){
		    String inputLine[] = br.readLine().trim().split(" ");
		    int n = Integer.parseInt(inputLine[0]);
		    int X = Integer.parseInt(inputLine[1]);
		    int A[] = new int[n];
		    inputLine = br.readLine().trim().split(" ");
		    for(int i=0; i<n; i++){
		        A[i] = Integer.parseInt(inputLine[i]);
		    }
		    boolean ans = Solut.find3Numbers(A, n, X);
		    System.out.println(ans?1:0);
		}
	}
}// } Driver Code Ends


//User function Template for Java

class Solut
{
    //Function to find if there exists a triplet in the 
    //array A[] which sums up to X.
    public static boolean find3Numbers(int A[], int n, int X) { 
    
       // Your code Here
       int low, high=n-1;
       Arrays.sort(A);
       for(int i=0;i<n;i++)
       {
           low = i+1;
           high=n-1;
           int rsum = (X - A[i]);
           
           while(low<high)
           {
           if(A[low]+A[high]==rsum)
           return true;
           
           else if (A[low]+A[high]>rsum)
           high--;
           
           else
           low++;
       }
       }
       
       return false;
    
    }
}

