class Solution {
    // Helper function to reverse a portion of the array
    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    public void nextPermutation(int[] nums) {
        int length = nums.length;

        // Step 1: Find the breakpoint
        int index = -1;
        for (int i = length - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                index = i;
                break;
            }
        }

        // Step 2: If no breakpoint, reverse the whole array
        if (index == -1) {
            reverse(nums, 0, length - 1);
            return;
        }

        // Step 3: Find the next larger element to swap with nums[index]
        for (int i = length - 1; i > index; i--) {
            if (nums[i] > nums[index]) {
                int temp = nums[i];
                nums[i] = nums[index];
                nums[index] = temp;
                break;
            }
        }

        // Step 4: Reverse the portion after the breakpoint
        reverse(nums, index + 1, length - 1);
    }
}
