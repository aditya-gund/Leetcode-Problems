class Solution {
    int mod = 1000000007;
    public int numTilings(int n) {
    if (n <= 2) return n;
    int[] dp = new int [n+1];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = (2 * dp[i - 1] % mod + dp[i - 3] % mod) % mod;
        }
        return dp[n];
    }
}