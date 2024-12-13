class Solution {
    public int lengthOfLIS(int[] nums) {
        int n=nums.length;
        int[][] dp = new int[n][n + 1];
for (int i = 0; i < n; i++) {
    Arrays.fill(dp[i], -1); 
}

        return recursivelengthOfLIS(n,nums,0,-1,dp);
    }
    private int recursivelengthOfLIS(int n, int[] nums, int curr,int prev, int[][]dp){
        if(curr==n) return 0;
        if(dp[curr][prev+1]!=-1)
            return dp[curr][prev+1];
        int take=0;
        if(prev==-1 || nums[curr]>nums[prev]){
            take=1+recursivelengthOfLIS(n,nums,curr+1,curr,dp);
        }
        int notTake=0+recursivelengthOfLIS(n,nums,curr+1,prev,dp);
        return dp[curr][prev+1]=Math.max(take,notTake);
    }
}