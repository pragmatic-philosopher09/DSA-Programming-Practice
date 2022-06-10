import java.io.*;
import java.util.*;

class HelpThiefGreedy {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S[] = read.readLine().split(" ");
            int T = Integer.parseInt(S[0]);
            int N = Integer.parseInt(S[1]);
            
            String S1[] = read.readLine().split(" ");
            String S2[] = read.readLine().split(" ");
            
            int[] A = new int[N];
            int[] B = new int[N];
            
            for(int i=0; i<N; i++)
            {
                A[i] = Integer.parseInt(S1[i]);
                B[i] = Integer.parseInt(S2[i]);
            }

            Solution ob = new Solution();
            System.out.println(ob.maxCoins(A,B,T,N));
        }
    }
}// } Driver Code Ends


class Solution {
    static class Pair{
        int first, second;
        Pair(int first, int second){
            this.first = first;
            this.second = second;
        }
    }
    static int min(int [] A){
        int min = A[0];
        for(int i = 1; i < A.length; i++)
            min = Math.min(min, A[i]);
        return min;
    }
    static int maxCoins(int[] A, int[] B, int T, int N) {
        if (T == 0 || T < min(A))
             return 0;
        ArrayList<Pair> profit = new ArrayList<>();
        for(int i= 0; i < N; i++)
            profit.add(new Pair(B[i],A[i]));
        //profit.sort(reverse = True)
        Collections.sort(profit, new Comparator<Pair>(){
            public int compare(Pair p1, Pair p2){
                if(p1.first == p2.first)
                    return p2.second - p1.second;
                return p2.first - p1.first;
            }
        });
        int t = T;
        int maxc = 0;
        for(int j = 0; j < N; j++){
            if (t ==0)
               break;
            if (t >= profit.get(j).second){
               maxc += profit.get(j).first*profit.get(j).second;
               t -= profit.get(j).second;
            }
            else{
               maxc = maxc + t*profit.get(j).first;
               t = 0;
            }
        }
        return maxc;
    }
}
