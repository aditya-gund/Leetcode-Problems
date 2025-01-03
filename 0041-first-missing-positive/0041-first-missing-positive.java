class Solution {
    public int firstMissingPositive(int[] nums) {
         Arrays.sort(nums);

        // Step 2: Check if 1 is present in the array
        if (Arrays.binarySearch(nums, 1) < 0) {
            return 1; // If 1 is not present, the missing positive is 1
        }

        // Step 3: Find the smallest missing positive element
        int missing = 1; // Start from the first positive number
        for (int num : nums) {
            if (num == missing) {
                missing++; // Increment to the next expected positive number
            }
        }
        return missing;
    }
}