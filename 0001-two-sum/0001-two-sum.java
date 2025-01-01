class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n=nums.length;
        int[] ans = new int[2];
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<n;i++){
            int diff=target-nums[i];
            if(!map.containsKey(diff)){
                map.put(nums[i],i);
            }else{
                ans[0]=i;
                ans[1]=map.get(diff);
            }
        }
        return ans;
    }
}