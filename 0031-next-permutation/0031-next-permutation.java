class Solution {
    public void nextPermutation(int[] nums) {
     int n=nums.length;
    int pivot=-1;
    for(int i=n-2;i>=0;i--){
        if(nums[i]<nums[i+1]){
            pivot=i;
            break;
        }
    }
    if(pivot!=-1){
        int swapIndex=-1;
    for(int i=n-1;i>pivot;i--){
        if(nums[i]>nums[pivot]){
            swapIndex=i;
            break;
        }
    }
    swap(nums, pivot, swapIndex);
    }
    reverse(nums,pivot+1);
    }
    // To find the swap candidate 
    private void swap(int[] nums, int left, int right){
        int temp=nums[left];
        nums[left]=nums[right];
        nums[right]=temp;
    }
    private void reverse(int[] nums, int start){
        int end=nums.length-1;
        while(start<end){
            swap(nums,start,end);
            start++;
            end--;
        }
        
    }
}