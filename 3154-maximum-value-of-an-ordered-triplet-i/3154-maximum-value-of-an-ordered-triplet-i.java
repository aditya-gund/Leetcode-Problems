class Solution {
    public long maximumTripletValue(int[] nums) {
        int n = nums.length;
        long maxVal = 0;
        
        int[] prefixMax = new int[n];
        int[] suffixMax = new int[n];
        
        // Compute prefix max values
        prefixMax[0] = nums[0];
        for (int i = 1; i < n; i++) {
            prefixMax[i] = Math.max(prefixMax[i - 1], nums[i]);
        }
        
        // Compute suffix max values
        suffixMax[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            suffixMax[i] = Math.max(suffixMax[i + 1], nums[i]);
        }
        
        // Iterate over the middle element and find the best i and k for it
        for (int j = 1; j < n - 1; j++) {
            if (prefixMax[j - 1] > nums[j] && suffixMax[j + 1] > 0) {
                long value = (long)(prefixMax[j - 1] - nums[j]) * suffixMax[j + 1];
                maxVal = Math.max(maxVal, value);
            }
        }
        
        return maxVal;
    }
}
