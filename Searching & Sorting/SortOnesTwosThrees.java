import java.io.*;
import java.util.*;


 // } Driver Code Ends
//User function template for Java

class Solve
{
    static void swap(int arr[], int x, int y)
    {
      int temp=arr[x];
      arr[x]=arr[y];
      arr[y]=temp;
    }
    
    public static void sort012(int a[], int n)
    {
        // code here 
         int low = 0;
       int mid = 0;
       int high = n-1;
       
       while(mid <= high)
       {
           if(a[mid] == 0){
               swap(a,mid++,low++);
           }
           else if(a[mid] == 1){
               mid++;
           }
           else if(a[mid] == 2){
               swap(a,mid,high);
               high--;
           }
    }
}
}

// { Driver Code Starts.

class SortOnesTwosThrees {
    
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
        while(t-->0){
            int n = Integer.parseInt(br.readLine().trim());
            int arr[] = new int[n];
            String inputLine[] = br.readLine().trim().split(" ");
            for(int i=0; i<n; i++){
                arr[i] = Integer.parseInt(inputLine[i]);
            }
            Solve ob=new Solve();
            ob.sort012(arr, n);
            StringBuffer str = new StringBuffer();
            for(int i=0; i<n; i++){
                str.append(arr[i]+" ");
            }
            System.out.println(str);
        }
    }
}

  // } Driver Code Ends
