import java.util.*;

class MergeSorting
{
    //method to print the elements of the array
	static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    

	public static void main(String args[])
	{
	    //taking input using Scanner class
		Scanner sc = new Scanner(System.in);
		
		//taking testcases
		int T = sc.nextInt();
		while(T>0)
		{
		    //taking elements count
			int n = sc.nextInt();
			
			//creating an object of class Merge_Sort
			Merge_Sort ms = new Merge_Sort();
			
			//creating an array of size n
			int arr[] = new int[n];
			
			//adding elements to the array
			for(int i=0;i<n;i++)
				arr[i] = sc.nextInt();

            
			Solution g = new Solution();
			
			//calling the method mergeSort
			g.mergeSort(arr,0,arr.length-1);

            //calling the method printArray
			ms.printArray(arr);
		T--;
		}
	}
}


// } Driver Code Ends


class Solution
{
    void merge(int a[], int l, int m, int r)
    {
         // Your code here
         int i=l,j=m+1,k=l;
         int b[] = new int[r+1];
         while(i<=m && j<=r)
         {
             if(a[i]<a[j])
             {
                 b[k++]=a[i++];
                 
             }
             
             else
             {
                 b[k++]=a[j++];
             }
         }
         
        
             while(i<=m)
             {
                 b[k++]=a[i++];
             }
         
         
        
             
             while(j<=r)
             {
                 b[k++]=a[j++];
             }
         
         
         
           
         
         
         for(k=l;k<=r;k++)
         {
             a[k]=b[k];
         }
    }
    void mergeSort(int arr[], int l, int r)
    {
        //code here
        if(l>=r)
        return;
        
        
        int mid=(l+r)/2;
        mergeSort(arr,l,mid);
        mergeSort(arr,mid+1,r);
        merge(arr,l,mid,r);
    
    }
}

