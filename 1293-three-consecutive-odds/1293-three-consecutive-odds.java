class Solution {
    public boolean threeConsecutiveOdds(int[] arr) {
        return isOdd(arr);
    }
    private boolean isOdd(int[] nums){
        int n=nums.length;
        for(int i=0;i<nums.length-2;i++){
            if(nums[i]%2==1 && nums[i+1]%2==1 && nums[i+2]%2==1){
                return true;
            }
        }
        return false;
    }
}