class Solution {
    public int maxScore(String s) {
        int n=s.length();
        int result=Integer.MIN_VALUE;
        for(int i=0;i<=n-2;i++){
            int countZero=0;
            for(int j=0;j<=i;j++){
                if(s.charAt(j)=='0'){
                    countZero++;
                }
            }
            int countOne=0;
            for(int j=i+1;j<n;j++){
                if(s.charAt(j)=='1'){
                    countOne++;
            }
            }
            result=Math.max(result, countZero+countOne);
        }
        return result;
    }
}