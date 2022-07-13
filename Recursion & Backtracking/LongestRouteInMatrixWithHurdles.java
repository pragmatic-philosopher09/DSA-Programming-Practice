import java.io.*;
import java.util.*;


class IntArray
{
    public static int[] input(BufferedReader br, int n) throws IOException
    {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = Integer.parseInt(s[i]);
        
        return a;
    }
    
    public static void print(int[] a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
    
    public static void print(ArrayList<Integer> a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
}


class IntMatrix
{
    public static int[][] input(BufferedReader br, int n, int m) throws IOException
    {
        int[][] mat = new int[n][];
        
        for(int i = 0; i < n; i++)
        {
            String[] s = br.readLine().trim().split(" ");
            mat[i] = new int[s.length];
            for(int j = 0; j < s.length; j++)
                mat[i][j] = Integer.parseInt(s[j]);
        }
        
        return mat;
    }
    
    public static void print(int[][] m)
    {
        for(var a : m)
        {
            for(int e : a)
                System.out.print(e + " ");
            System.out.println();
        }
    }
    
    public static void print(ArrayList<ArrayList<Integer>> m)
    {
        for(var a : m)
        {
            for(int e : a)
                System.out.print(e + " ");
            System.out.println();
        }
    }
}

class LongestRouteInMatrixWithHurdles {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int[] a = IntArray.input(br, 2);
            
            
            int[] b = IntArray.input(br, 4);
            
            
            int[][] mat = IntMatrix.input(br, a[0], a[1]);
            
            Solution obj = new Solution();
            int res = obj.longestPath(mat,a[0],a[1],b[0],b[1],b[2],b[3]);
            
            System.out.println(res);
            
        }
    }
}
// } Driver Code Ends

class Solution {
   int ans=-1;
   public int longestPath(int[][] mat,int n,int m,int xs,int ys,int xd,int yd) {
       // code here
       req(xs,ys,xd,yd,n,m,0,mat);
       return ans;
   }
   int req(int i,int j,int k,int l,int n,int m,int len,int[][]mat){
       if(i<0 || j<0 || i==n || j==m || mat[i][j]==0){ return 0; }
       if(i==k && j==l ){ ans=Math.max(ans,len); return 0; }
       mat[i][j]=0;
       req(i+1,j,k,l,n,m,len+1,mat);
       req(i,j+1,k,l,n,m,len+1,mat);
       req(i-1,j,k,l,n,m,len+1,mat);
       req(i,j-1,k,l,n,m,len+1,mat);
       mat[i][j]=1;
       return 0;
   }
}
        
