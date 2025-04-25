class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxLen=0;
        int left=0;
        Set<Character> set = new HashSet<>();
        for(int i=0;i<s.length();i++){
            while(left<i && set.contains(s.charAt(i))){
                set.remove(s.charAt(left));
                left++;
                
            }
            set.add(s.charAt(i));
            maxLen=Math.max(maxLen,i-left+1);    
        }
        
        return maxLen;
    }
}