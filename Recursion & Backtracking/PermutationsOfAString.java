import java.util.*;
import java.lang.*;
import java.io.*;
class PermutationsOfAString
{
	public static void main(String[] args) throws IOException
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0)
        {
            String S = br.readLine().trim();
            Solution obj = new Solution();
            List<String> ans = obj.find_permutation(S);
            for( int i = 0; i < ans.size(); i++)
            {
                System.out.print(ans.get(i)+" ");
            }
            System.out.println();
                        
        }
	}
}

// } Driver Code Ends


class Solution {
    public List<String> find_permutation(String S) {
        // Code here
        
        List<String> res = new ArrayList<>();
        
        
        generatePermutations(S,0,res);
        
        
        
        Set<String> set = new HashSet<>(res);
        
        
        
        
        
        List<String> ans = new ArrayList<>(set);
        
        
        Collections.sort(ans);
        
        return ans;
    }
    
        static void generatePermutations(String S, int index, List<String> res)
        {
            if(index>=S.length())
            {
                res.add(S);
                return;
            }
            
            for(int j=index; j<S.length();j++)
            {
                S = swap(S, index, j);
                
                generatePermutations(S, index+1, res);
                
                S = swap(S,index,j);
            }
        }
        
        static String swap(String S, int i, int j)
        {
            char charArray [] = S.toCharArray();
            char temp = charArray[i];
            charArray[i] = charArray[j];
            charArray[j] = temp;
            
            return String.valueOf(charArray);
        }
        
        
    }

