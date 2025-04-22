class Solution {
    private static final int MOD = 1_000_000_007;
    private static final int MAX_N = 10001;
    
    public int idealArrays(int n, int maxValue) {
        int[][] dp = new int[15][maxValue + 1];  // dp[length][value]
        
        // Base case: arrays of length 1
        for (int i = 1; i <= maxValue; i++) {
            dp[1][i] = 1;
        }
        
        // Fill DP for lengths 2 to 14 (since n <= 10^4 and we use combinations later)
        for (int len = 2; len < 15; len++) {
            for (int i = 1; i <= maxValue; i++) {
                for (int j = 2 * i; j <= maxValue; j += i) {
                    dp[len][j] = (dp[len][j] + dp[len - 1][i]) % MOD;
                }
            }
        }

        // Precompute factorials and inverse factorials for combinations
        long[] fact = new long[MAX_N];
        long[] invFact = new long[MAX_N];
        fact[0] = invFact[0] = 1;
        for (int i = 1; i < MAX_N; i++) {
            fact[i] = (fact[i - 1] * i) % MOD;
        }
        invFact[MAX_N - 1] = modInverse(fact[MAX_N - 1]);
        for (int i = MAX_N - 2; i > 0; i--) {
            invFact[i] = (invFact[i + 1] * (i + 1)) % MOD;
        }

        // Compute answer using combinations
        long ans = 0;
        for (int len = 1; len < 15; len++) {
            long ways = nCr(n - 1, len - 1, fact, invFact);
            for (int val = 1; val <= maxValue; val++) {
                ans = (ans + ways * dp[len][val]) % MOD;
            }
        }

        return (int) ans;
    }

    // nCr = fact[n] / (fact[r] * fact[n-r])
    private long nCr(int n, int r, long[] fact, long[] invFact) {
        if (r < 0 || r > n) return 0;
        return (((fact[n] * invFact[r]) % MOD) * invFact[n - r]) % MOD;
    }

    // Modular Inverse using Fermat’s Little Theorem
    private long modInverse(long x) {
        return pow(x, MOD - 2);
    }

    private long pow(long a, long b) {
        long res = 1;
        while (b > 0) {
            if ((b & 1) == 1) res = (res * a) % MOD;
            a = (a * a) % MOD;
            b >>= 1;
        }
        return res;
    }
}
