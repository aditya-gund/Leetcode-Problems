class Solution {
    public int[] findErrorNums(int[] nums) {
        int repeating=0;
        int missing=0;
        int n=nums.length;
        for(int i=1;i<=n;i++){
            int count=0;
            for(int j=0;j<n;j++){
                if(nums[j]==i){
                    count++;
                }
            }
            if(count==2) repeating=i;
            else if(count==0) missing=i;
        }
        int[] result={repeating,missing};
        return result;
    }
}