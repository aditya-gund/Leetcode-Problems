class Solution {
    public void nextPermutation(int[] nums) {
        findNextPermutation(nums, nums.length - 1);
    }
    // Recursive function to findout the nextPermutation
    private boolean findNextPermutation(int[] nums, int index){
        // base case
        if(index==0){
            reverse(nums,0);
            return true;
        }
        //find the next permuation calling the recursive funtion
        if(nums[index-1]<nums[index]){
            int swapIndex = findNextLarger(nums, index-1);
            swap(nums, index-1, swapIndex);
            reverse(nums,index);
            return true;
        }
        return findNextPermutation(nums,index-1);
    }
    private int findNextLarger(int[] nums, int index){
        int value = nums[index];
        int nextLargerIndex=index+1;
         for (int i = index + 1; i < nums.length; i++) {
            if (nums[i] > value) {
                nextLargerIndex = i;
            }
        }

        return nextLargerIndex;
    }
     private void reverse(int[] nums, int start) {
        int end = nums.length - 1;
        while (start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }
     // Swap two elements in the array
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}