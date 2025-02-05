class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        if(s1.equals(s2)) return true;
        char[] s1Freq = new char[26];
        char[] s2Freq = new char[26];
        int diff=0;
        for(int i=0;i<s1.length();i++){
            char s1Char = s1.charAt(i);
            char s2Char = s2.charAt(i);
            if(s1Char!=s2Char){
                diff++;
                if(diff>2) return false;
            }
            s1Freq[s1Char-'a']++;
            s2Freq[s2Char-'a']++;
        }
        return Arrays.equals(s1Freq, s2Freq);
    }
}