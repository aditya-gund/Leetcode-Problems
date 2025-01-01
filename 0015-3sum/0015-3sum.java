import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    private List<List<Integer>> result = new ArrayList<>();
    
    private void twoSum(int[] nums, int target, int i, int j) {
        while (i < j) {
            if (nums[i] + nums[j] > target) {
                j--;
            } else if (nums[i] + nums[j] < target) {
                i++;
            } else {
                // Found a valid triplet
                result.add(Arrays.asList(-target, nums[i], nums[j]));

                // Skip duplicates for the `i` pointer
                while (i < j && nums[i] == nums[i + 1]) i++;
                // Skip duplicates for the `j` pointer
                while (i < j && nums[j] == nums[j - 1]) j--;

                // Move pointers inward
                i++;
                j--;
            }
        }
    }
    
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        result.clear(); // Clear the result for fresh computation

        if (n < 3) {
            return result; // Not enough elements for a triplet
        }

        Arrays.sort(nums); // Sort the array to enable two-pointer logic

        for (int k = 0; k < n; k++) {
            // Skip duplicates for the first element of the triplet
            if (k > 0 && nums[k] == nums[k - 1]) {
                continue;
            }

            int target = -nums[k];
            twoSum(nums, target, k + 1, n - 1);
        }

        return result;
    }
}
