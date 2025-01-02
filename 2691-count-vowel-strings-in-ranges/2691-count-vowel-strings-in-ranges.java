class Solution {
    public int[] vowelStrings(String[] words, int[][] queries) {
        Set<Character> vowels = new HashSet<>(Arrays.asList('a','e','i','o','u'));
        int n=words.length;
        
        int[] prefixSum = new int[n];
        for(int i=0;i<n;i++){
            String word=words[i];
            char first=word.charAt(0);
            char last=word.charAt(word.length()-1);
            int isValid;
            if(vowels.contains(first) && vowels.contains(last)){
                isValid=1;
            }else{
                isValid=0;
            }
            if(i==0){
                prefixSum[i]=isValid;
            }else{
                prefixSum[i]=prefixSum[i-1]+isValid;
            }
        } 
        int q=queries.length;
        int[] ans = new int[q];
        for(int i=0;i<q;i++){
            int li = queries[i][0];
            int ri = queries[i][1];
            if(li>0){
                ans[i]=prefixSum[ri]-prefixSum[li-1];
            }else{
                ans[i]=prefixSum[ri];
            }
        }    
        return ans;   
    }
}