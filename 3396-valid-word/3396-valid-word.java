class Solution {
    public boolean isValid(String word) {
        int n=word.length();
        if(n<3) return false;
        int vowels=0,consonants=0, digit=0;
        for(char ch: word.toCharArray()){
            if(Character.isLetter(ch)){
                if("aeiouAEIOU".indexOf(ch)!=-1){
                    vowels++;
                }else{
                    consonants++;
                }
            }else if(!Character.isDigit(ch)){
                return false;
            }
        }
        return vowels>=1 && consonants>=1;
    }
}