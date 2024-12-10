class Solution {
    public int maxProduct(int[] nums) {
        int n=nums.length; // Length of an array
        int ans=Integer.MIN_VALUE; // result is stored
        int pre=1,suff=1;
        //For loop to traverse an array
        for(int i=0;i<n;i++){
            //If condition to check 0 is present in prefix product
            if(pre==0) pre=1;
            //If condition to check 0 is present in suffix product
            if(suff==0) suff=1;
            pre *= nums[i];
            suff *= nums[n-i-1];
            ans= Math.max(ans, Math.max(pre,suff));
        }
        return ans;
    }
}