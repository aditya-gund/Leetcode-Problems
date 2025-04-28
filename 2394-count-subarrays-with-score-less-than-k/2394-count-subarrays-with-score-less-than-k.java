class Solution {
    public long countSubarrays(int[] nums, long k) {
        int numberOfElements = nums.length;
        long result = 0;
        long subArraySum = 0;
        for(int i=0, j=0; j<numberOfElements; j++) {
            subArraySum += nums[j];
            while(i<=j && (subArraySum*(j-i+1))>=k) {
                subArraySum -= nums[i];
                i++;
            }
            result += (j-i+1);
        }
        return result;
    }
}