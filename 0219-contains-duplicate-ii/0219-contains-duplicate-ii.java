class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int n=nums.length;
        Set<Integer> window = new HashSet<>();
        for(int i=0;i<n;i++){
           if(window.contains(nums[i])){
            return true;
           }
           window.add(nums[i]);
           if(window.size()>k){
            window.remove(nums[i-k]);
           }
        }
        return false;
    }
}