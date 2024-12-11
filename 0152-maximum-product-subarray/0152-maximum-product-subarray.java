class Solution {
    public int maxProduct(int[] nums) {
        int n=nums.length; // Intializing the length of an array
        int maximumProduct=Integer.MIN_VALUE;
        int prefix=1, suffix=1;
        
        for(int i=0;i<n;i++){
            if(prefix==0) prefix=1;
        if(suffix==0) suffix=1;
            prefix *=nums[i];
            suffix *=nums[n-i-1];
            maximumProduct=Math.max(maximumProduct, Math.max(prefix,suffix));
        }
        return maximumProduct;
    }
}