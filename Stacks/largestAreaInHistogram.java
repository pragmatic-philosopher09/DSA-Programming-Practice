import java.util.*;
class largestAreaInHistogram
{
    //Function to find largest rectangular area possible in a given histogram.
    
    static long[] previousSmaller(long arr[])
    {
        Stack<Integer> s = new Stack<>();
        long ps[] = new long[arr.length];
        for(int i=0;i<arr.length;i++)
        {
            while(!s.isEmpty() && arr[s.peek()]>=arr[i])
            {
                s.pop();
            }
            
            if(s.isEmpty())
            {
                ps[i] = -1;
            }
            
            else
            {
                ps[i] = s.peek();
            }
            
            s.push(i);
        }
        return ps;
    }
    
    static long[] nextSmaller(long arr[])
    {
        Stack<Integer> s = new Stack<>();
        long ns[] = new long[arr.length];
        int k=1;
        int n = arr.length;
        for(int i=n-1;i>=0;i--)
        {
            while(!s.isEmpty() && arr[s.peek()]>=arr[i])
            {
                s.pop();
            }
            
            if(s.isEmpty())
            {
                ns[n-k] = arr.length;
                k++;
            }
            
            else
            {
                ns[n-k] = s.peek();
                k++;
            }
            
            s.push(i);
        }
        return ns;
    }
    
    
    public static long getMaxArea(long hist[], long n) 
    {
        // your code here
        long ps[] = previousSmaller(hist);
        long ns[] = nextSmaller(hist);
        long maxArea=0;
        long area=0;
        for(int i=0;i<n;i++)
        {
            area = (ns[i]-ps[i]-1)*hist[i];
            maxArea = Math.max(maxArea,area);
        }
        
        return maxArea;
        
    }
    public static void main(String[] args) {
        long hist[] = {6,2,5,4,5,1,6};
        long max = getMaxArea(hist, hist.length);
        
        
        System.out.println(max);
    }
        
}