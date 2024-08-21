class Solution {
    public int removeDuplicates(int[] nums) {
        // HashSet<Integer> set = new HashSet<>();
        // int[] expectedNums = new int[nums.length];
        int index=1;
        for(int i=1;i<nums.length;i++){
            // set.add(nums[i]);
            if(nums[i]!=nums[i-1]){
                nums[index++]=nums[i];
                
            }
            // index++;
        }
        return index;
    }
}