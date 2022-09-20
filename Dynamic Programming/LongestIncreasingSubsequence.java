class LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        
        int n = nums.length;
        int dp[][] = new int[n+1][n+1];
        int len;
        for(int ind = n-1; ind>=0;ind--)
        {
            for(int prev_ind = ind-1; prev_ind >=-1; prev_ind--)
            {
                int nottake = 0 + dp[ind+1][prev_ind+1];
                int take = Integer.MIN_VALUE;
                
                if(prev_ind==-1 || nums[ind]>nums[prev_ind])
                {
                    take = 1 + dp[ind+1][ind+1];
                }
                
                len = Math.max(take,nottake);
                dp[ind][prev_ind+1] = len;
            }
        }
        
        return dp[0][0];
        
    }
}
