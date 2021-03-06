import java.util.*;

public class SearchInRotatedSortedArray
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        
        int t = sc.nextInt();
        while (t-- > 0)
        {
            int n = sc.nextInt();
            int A[] = new int[n];
            
            for (int i = 0;i < n;i++)
            {
                A[i] = sc.nextInt();
            }
            int key = sc.nextInt();
            
            System.out.println(new Solution().search(A, 0, n - 1, key));
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution
{
    int search(int A[], int l, int h, int key)
    {
        // Complete this function
        int beg = l, end=h,mid;
        while(beg<=end)
        {
            mid=(beg+end)/2;
            
            if(A[mid]==key)
            return mid;
            
            if(A[beg]<=A[mid])
            {
               if(key>=A[beg] && key <= A[mid])
               {
                   end=mid-1;
               }
               
               else
               {
                   beg=beg+1;
               }
            }
            
            else
            {
                if(key>=A[mid] && key<=A[end])
                {
                    beg=mid+1;
                }
                
                else
                {
                    end=mid-1;
                }
            }
            
            
            
            
        }
        
        return -1;
    }
}