import java.io.*;


class RepeatedMissing {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String[] str = br.readLine().split(" ");

            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(str[i]);
            }

            int[] ans = new Solve().findTwoElement(a, n);
            System.out.println(ans[0] + " " + ans[1]);
        }
    }
}// } Driver Code Ends


// User function Template for Java

class Solve {
    int[] findTwoElement(int arr[], int n) {
        // code here
       
         int[] res = new int[2];
        int xy = 0;
        for(int a : arr){
            xy ^=a;
        }
        
        for(int a = 1; a <= n ; a++){
            xy ^=a;
        }
        
        int rmsb = xy & (~xy+1);
        int x = 0, y = 0;
        
        for(int a : arr){
            if((a & rmsb) == 0)
                x ^=a;
            else
                y ^=a;
        }
        
        for(int a = 1; a <=n; a++){
            if((a & rmsb) == 0)
                x ^=a;
            else
                y ^=a;
        }
        
        for(int a : arr){
            if(a == x){
                res[0] = x;
                res[1] = y;
            }
            if(a == y){
                 res[1] = x;
                res[0] = y;
            }
        }
        return res;
    }
       
}
