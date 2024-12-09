class Solution {
    public int fib(int n) {
       int dp[] = new int[n+1];
       if(n==0) return 0;
       if(n==1) return 1;
       dp[0]=0;
       dp[1]=1;
       if(dp[n]==0)
        return dp[n]= fib(n-1)+fib(n-2);
        return dp[n-1]; 
    }
}