class Solution {
    private boolean isSubstring(String sub, String main){
       for(int i=0;i<main.length();i++){
        boolean subFit=true;
        for(int j=0;j<sub.length();j++){
            if(i+j>=main.length() || main.charAt(i+j)!=sub.charAt(j)){
                subFit=false;
                break;
            }
        }
        if(subFit){
            return true;
        }
       }
       return false;
    }
    public List<String> stringMatching(String[] words) {
        List<String> match = new ArrayList<>();
        for(int i=0;i<words.length;i++){
            for(int j=0;j<words.length;j++){
                if(i!=j){
                    if(isSubstring(words[i],words[j])){
                        match.add(words[i]);
                        break;
                    }
                }
            }
        }
        return match;
    }
}