import java.util.*;

class Solution {
    public int lengthOfLIS(int[] nums) {
        ArrayList<Integer> sub = new ArrayList<>();
        for (int num : nums) {
            int idx = Collections.binarySearch(sub, num);
            if (idx < 0) idx = -(idx + 1); // Convert to insertion index
            if (idx < sub.size()) 
                sub.set(idx, num); // Replace the element
            else 
                sub.add(num); // Append new element
        }
        return sub.size(); // Length of LIS
    }
}
