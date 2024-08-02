class Solution {
    public int minSwaps(int[] nums) {
        int totalOnes = 0;
        int n = nums.length;
        
        for (int num : nums) {
            if (num == 1) {
                totalOnes++;
            }
        }

        if (totalOnes == 0 || totalOnes == n) {
            return 0;
        }

        int[] extendedNums = new int[2 * n];
        System.arraycopy(nums, 0, extendedNums, 0, n);
        System.arraycopy(nums, 0, extendedNums, n, n);

        int maxOnesInWindow = 0;
        int currentOnesInWindow = 0;

        for (int i = 0; i < totalOnes; i++) {
            if (extendedNums[i] == 1) {
                currentOnesInWindow++;
            }
        }

        maxOnesInWindow = currentOnesInWindow;

        for (int i = totalOnes; i < 2 * n; i++) {
            if (extendedNums[i] == 1) {
                currentOnesInWindow++;
            }
            if (extendedNums[i - totalOnes] == 1) {
                currentOnesInWindow--;
            }
            maxOnesInWindow = Math.max(maxOnesInWindow, currentOnesInWindow);
        }

        return totalOnes - maxOnesInWindow;
    }
}
