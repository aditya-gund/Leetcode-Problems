class Solution {
    public boolean validMountainArray(int[] nums) {
         int n=nums.length;
        int maxIndex=findPeakElement(nums);
        if(n<3) return false;
            if(maxIndex==0 || maxIndex==n-1){
                return false;
            }
        //Increasing part
        for(int i=0;i<maxIndex;i++){
            if(nums[i]>=nums[i+1]){
                return false;
            }
        }
        // Decreasing part
        for(int i=maxIndex;i<n-1;i++){
            if(nums[i]<=nums[i+1]){
                return false;
            }
        }
        return true;
    }
    // Finding the Largest element in an Array
    private int findPeakElement(int[] nums){
        int n=nums.length;
        // int max=0;
        int idxMax=0;
        for(int i=0;i<n;i++){
            if(nums[i]>nums[idxMax]){
                // max=nums[i];
                idxMax=i;
            }
        }
        return idxMax;
    } 
}