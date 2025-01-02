class Solution {
    public int[] findErrorNums(int[] nums) {
        long  n=nums.length;
        long  Sn=(n*(n+1))/2;
        long  S2n=(n*(n+1)*(2*n+1))/6;
        long S=0,S2=0;
        for(int i=0;i<n;i++){
            S+=nums[i];
            S2+=(long)nums[i]*(long)nums[i];
        }
        long val1=S-Sn;
        long val2=S2-S2n;
        val2=val2/val1;
        long  x= (val1+val2)/2;
        long  y=x-val1;
        int[] result = {(int)x, (int)y};
        return result;
    }
}