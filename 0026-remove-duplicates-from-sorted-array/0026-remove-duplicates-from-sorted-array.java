class Solution {
    public int removeDuplicates(int[] nums) {
        int slow=0;
        int fast=1;
        while(fast<nums.length){
            if(nums[slow]==nums[fast]){
                fast+=1;
            }
            else{
                nums[slow+1]=nums[fast];
                fast+=1;
                slow+=1;
            }
        }
        return slow+1;
    }
}