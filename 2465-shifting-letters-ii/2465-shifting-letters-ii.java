class Solution {
    public String shiftingLetters(String s, int[][] shifts) {
        int n=s.length();
        int[] diff = new int[n];
        for(int[] shift: shifts){
            if(shift[2]==1){
                diff[shift[0]]++;
                if(shift[1]+1<n){
                    diff[shift[1]+1]--;
                }
            }
            else {
                diff[shift[0]]--;
                if(shift[1]+1<n){
                    diff[shift[1]+1]++;
                }
            }
        }
        StringBuilder ans = new StringBuilder(s);
        int numOfShifts=0;
        for(int i=0;i<n;i++){
            numOfShifts=(numOfShifts+diff[i])%26;
            if(numOfShifts<0) numOfShifts+=26;
            char shiftChar = (char) ('a' + ((s.charAt(i)-'a' + numOfShifts)%26));
            ans.setCharAt(i, shiftChar);
        }
        return ans.toString();
    }
}