// { Driver Code Starts
    import java.util.*;
    import java.io.*;
    class Codes
    {
        public static void main(String[] args) throws IOException
        {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int T = Integer.parseInt(br.readLine().trim());
            while(T-->0)
            {
                String A = br.readLine().trim();
                Solution ob = new Solution();
                String ans = ob.FirstNonRepeating(A);
                System.out.println(ans);
            }
        }
    }
    // } Driver Code Ends
    
    
    class Solution
    {
        public String FirstNonRepeating(String A)
        {
            // code here
            Queue<Character> q = new ArrayDeque<>();
            StringBuilder temp= new StringBuilder();
            int arr[] = new int[26];
            
            for(int i=0;i<A.length();i++)
            {
                
                
                if(arr[A.charAt(i)-'a']==0)
                {
                    q.offer(A.charAt(i));
                }
                arr[A.charAt(i)-'a']++;
                while(!q.isEmpty() && arr[q.peek()-'a']!=1)
                {
                    q.poll();
                }
                    temp.append(q.isEmpty() ? "#" : q.peek());
                
                
            
            }
            return temp.toString();
        }
    }
