class Solution {
    public int removeDuplicates(int[] nums) {
         if (nums == null || nums.length == 0) {
            return 0;
        }
        // HashSet<Integer> set = new HashSet<>();
        int index=1;
        for(int i=1;i<nums.length;i++){
           if(nums[i]!=nums[i-1]){
            // set.add(nums[i]);
            nums[index++]=nums[i];
           }
            
           
        }
        return index;
    }
}