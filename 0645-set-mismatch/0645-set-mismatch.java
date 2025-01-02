class Solution {
    public int[] findErrorNums(int[] nums) {
        int n=nums.length;
        int[] hash=new int[n+1];
        for(int i=0;i<n;i++){
            hash[nums[i]]++;
        }
        int repeat=-1,miss=-1;
        for(int i=1;i<=n;i++){
            if(hash[i]==2) repeat=i;
            else if(hash[i]==0) miss=i;
            if(repeat !=-1 && miss!=-1){
                break;
            }
        }
        return new int[] {repeat,miss};
    }
}