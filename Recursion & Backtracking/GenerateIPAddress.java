import java.util.*;
class GenerateIPAddresses {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String s = sc.next();
            Solution sln = new Solution();
            ArrayList<String> str = sln.genIp(s);
            Collections.sort(str);
            if(str.size() == 0)
                System.out.println(-1);
            else{
                for (String u : str) {
                    System.out.println(u);
                }
            }
        }
    }
}// } Driver Code Ends


/*complete the Function*/

class Solution {
    public ArrayList<String> genIp(String s) {
        ArrayList<String> result = new ArrayList<>();
        if (s.length() > 12 || s.length() < 4) {
            result.add("-1");
            return result;
        }
        helper(s, "", 3, result);
        if (result.isEmpty()) {
            result.add("-1");
        }
        return result;
    }
    
    private void helper(String S, String R, int p, ArrayList<String> result) {
        if (p == 0) {
            if (validate(S)) {
                result.add(R + S);
            }
            return;
        }
        int n = S.length();
        if (n > 1) {
            helper(S.substring(1), R + S.substring(0, 1) + ".", p - 1, result);
        }
        if (n > 2 && validate(S.substring(0, 2))) {
            helper(S.substring(2), R + S.substring(0, 2) + ".", p - 1, result);
        }
        if (n > 3 && validate(S.substring(0, 3))) {
            helper(S.substring(3), R + S.substring(0, 3) + ".", p - 1, result);
        }
    }
    
    private boolean validate(String S) {
        int n = S.length();
        if (n == 1) {
            return true;
        }
        if (n == 2 && S.charAt(0) != '0') {
            return true;
        }
        if (n == 3 && S.charAt(0) != '0' && Integer.parseInt(S) <= 255) {
            return true;
        }
        return false;
    }
}
