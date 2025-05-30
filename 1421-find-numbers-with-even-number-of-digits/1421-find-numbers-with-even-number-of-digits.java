class Solution {
    public int findNumbers(int[] nums) {
        int digit = 0, ans = 0;
        
        for(int num : nums){
            digit = 0;
            
            while(num>0){
                num /= 10;
                digit++;
            }
            
            if(digit % 2 == 0){
                ans++;
            }
        }
        
        return ans;
    }
}
