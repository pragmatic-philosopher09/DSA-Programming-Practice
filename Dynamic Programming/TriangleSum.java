class TriangleSum {
    public int minimumTotal(List<List<Integer>> triangle) {
        
        int n = triangle.size();
        int dp[][] = new int[n][];
        int i,j;
        
        for(i=0;i<n;i++)
        {
            dp[i] = new int[triangle.get(i).size()];
        }
        
        for(i=0;i<n;i++)
        {
            dp[n-1][i] = triangle.get(n-1).get(i); //Base Cases Declaration
        }
        
        for(i=n-2;i>=0;i--)
        {
            for(j=i; j>=0;j--)
            {
                dp[i][j] = triangle.get(i).get(j) + Math.min(dp[i+1][j], dp[i+1][j+1]);
            }
        }
        
        return dp[0][0];
    }
}
