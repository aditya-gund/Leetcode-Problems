class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        List<String> ans = new ArrayList<>();
        int[] maxFreq = new int[26];
        for(String word: words2){
           int[] freq = countFreq(word);
           for(int i=0;i<26;i++){
            maxFreq[i]=Math.max(maxFreq[i], freq[i]);
           } 
        }
        for(String word: words1){
            int[] freq = countFreq(word);
            boolean isUnique=true;
            for(int i=0;i<26;i++){
                if(freq[i]< maxFreq[i]){
                    isUnique=false;
                    break;
                }
            }
            if(isUnique){
                ans.add(word);
            }
        }
        return ans;
    }
    private int[] countFreq(String word){
        int[] freq = new int[26];
        for(char c:word.toCharArray()){
            freq[c-'a']++;
        }
        return freq;
    }
}