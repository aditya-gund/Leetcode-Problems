class Solution {
    public int maxScore(String s) {
        int n=s.length();
        int result=Integer.MIN_VALUE;
       
        int totalOnes=0;
        for(int i=0;i<n;i++){
            if(s.charAt(i)=='1'){
                totalOnes++;
            }
        }
              int zero=0;
             int one=0;
        for(int i=0;i<=n-2;i++){
       
            if(s.charAt(i)=='1'){
                one++;
            }else{
                zero++;
            }
            int right_ones=totalOnes-one;
            result=Math.max(result, zero+right_ones);
        }
        return result;
    }
}