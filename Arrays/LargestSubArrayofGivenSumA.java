import java.io.*;
import java.util.*;


class LargestSubArrayofGivenSumA {
    
    // Driver code
	public static void main (String[] args) throws IOException{
		// Taking input using buffered reader
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testcases = Integer.parseInt(br.readLine());
		
		// looping through all testcases
		while(testcases-- > 0){
		    String line = br.readLine();
		    String[] element = line.trim().split("\\s+");
		    int sizeOfArray = Integer.parseInt(element[0]);
		    int K = Integer.parseInt(element[1]);
		    
		    int arr [] = new int[sizeOfArray];
		    
		    line = br.readLine();
		    String[] elements = line.trim().split("\\s+");
		    for(int i = 0;i<sizeOfArray;i++){
		        arr[i] = Integer.parseInt(elements[i]);
		    }
		    
		    Solution obj = new Solution();
		    int res = obj.lenOfLongSubarr(arr, sizeOfArray, K);
		    
		    System.out.println(res);
		}
	}
}


            

// } Driver Code Ends


//User function Template for Java

class Solution{
    
   
    // Function for finding maximum and value pair
    public static int lenOfLongSubarr (int A[], int N, int K) {
        //Complete the function
        
        HashMap<Integer,Integer> m =  new HashMap<>();
        int maxLen=0,curSum=0,i;
        
        for(i=0;i<N;i++)
        {
            curSum+=A[i];
            
            if(!m.containsKey(curSum))
            {
                m.put(curSum,i);
            }
            if(curSum==K)
            {
                maxLen=i+1;
            }
            
            if(m.containsKey(curSum-K))
            {
                if(maxLen < (i-m.get(curSum-K)))
                {
                    maxLen = i-m.get(curSum-K);
                }
            }
            
        }
        return maxLen;
    }
    
    
}
