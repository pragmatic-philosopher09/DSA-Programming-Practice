import java.io.*;
import java.util.*;
import java.util.stream.*;

class WordBreakPart2{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int n = Integer.parseInt(in.readLine());
            String arr[] = in.readLine().trim().split("\\s+");
            List<String> dict = new ArrayList<String>();
            for(int i = 0;i < n;i++)
                dict.add(arr[i]);
            String s = in.readLine();
            
            Solution ob = new Solution();
            List<String> ans = new ArrayList<String>();
            ans = ob.wordBreak(n, dict, s);
            if(ans.size() == 0)
                System.out.println("Empty");
            else{
                List<String> sol = ans.stream().sorted().collect(Collectors.toList());
                for(int i = 0;i < sol.size();i++)
                    System.out.print("("+sol.get(i)+")");
                System.out.println();
            }
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution{
    
    Map<String, List<String>> dp = new HashMap<>();
    
    List<String> wordBreak(int n, List<String> dict, String s)
    {
        // code here
        
        if(dp.containsKey(s))
        return dp.get(s);
        
        List<String> result = new ArrayList<>();
        
        for(String word: dict)
        {
            if(s.startsWith(word))
            {
                if(s.length() == word.length())
                result.add(word);
                
                else
                {
                    List<String> temp = wordBreak(n, dict, s.substring(word.length()));
                    
                    for(String w: temp)
                    {
                        result.add(word + " "+w);
                    }
                }
            }
        }
        
        dp.put(s,result);
        return dp.get(s);
    }
}
