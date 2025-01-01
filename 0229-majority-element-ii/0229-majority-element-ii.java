import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length;
        int count1 = 0, count2 = 0, maj1 = 0, maj2 = 0;

        // Step 1: Find potential majority elements
        for (int num : nums) {
            if (num == maj1) {
                count1++;
            } else if (num == maj2) {
                count2++;
            } else if (count1 == 0) {
                maj1 = num;
                count1 = 1;
            } else if (count2 == 0) {
                maj2 = num;
                count2 = 1;
            } else {
                count1--;
                count2--;
            }
        }

        // Step 2: Verify if the candidates appear more than n/3 times
        int freq1 = 0, freq2 = 0;
        for (int num : nums) {
            if (num == maj1) freq1++;
            else if (num == maj2) freq2++;
        }

        List<Integer> result = new ArrayList<>();
        if (freq1 > n / 3) result.add(maj1);
        if (freq2 > n / 3) result.add(maj2);

        return result;
    }
}
