class Solution {
    public int maxProfit(int[] nums) {
        int n=nums.length;
        int maxProfit=0;
        int buy=nums[0];
        for(int i=1;i<n;i++){
            if(buy>nums[i])
            {
                buy=nums[i];                
            }
            maxProfit=Math.max(maxProfit, nums[i]-buy);
        }
        return maxProfit;
    }
}