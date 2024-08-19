class Solution {
    int[] dp = new int[1001];
    public int minSteps(int n) {
        for (int i = 0; i <= n; i++) {
            dp[i] = -1;
        }
        return minStepsHelper(n);
    }
    
    private int minStepsHelper(int n) {
        if (n == 1) return 0;
        if (dp[n] != -1) return dp[n];
        int minSteps = n;  
        for (int i = 2; i <= n; i++) {
            if (n % i == 0) {
                minSteps = Math.min(minSteps, minStepsHelper(n / i) + i);
            }
        }
        return dp[n] = minSteps;
    }
}
