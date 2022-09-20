class EditDistance {
    public int minDistance(String word1, String word2) {
        
        int n = word1.length();
        int m = word2.length();
        
        int dp[][]= new int[n+1][m+1];
        //Base Cases Formulation
        
        for(int i = 0; i<=n; i++)
        {
            for(int j =0; j<=m; j++)
            {
                if(i==0)
                {
                    dp[i][j] = j;
                }
                
                if(j==0)
                {
                    dp[i][j] = i;
                }
            }
        }
        
        //Recursive Cases Formulation
        
        for(int i=1;i<=n;i++)
        {
            for(int j=1;j<=m;j++)
            {
                //If two strings match
                
                if(word1.charAt(i-1) == word2.charAt(j-1))
                    dp[i][j] = 0 + dp[i-1][j-1];
                
                else
                {
                    int replace = 1+dp[i-1][j-1];
                    int insert = 1+dp[i][j-1];
                    int delete = 1+dp[i-1][j];
                    
                    dp[i][j] = Math.min(replace, Math.min(insert,delete));
                }
            }
        }
        
        return dp[n][m];
    }
}
