class Solution {
    public int maxScore(String s) {
        int n=s.length();
        int ans=Integer.MIN_VALUE;
        for( int i=0;i<=n-2;i++){
            //0 to i count zero
            int count_zero=0;
            for(int j=0;j<=i;j++){
                if(s.charAt(j)=='0'){
                        count_zero++;
                }
          
            }
                  //i+1 to n-1 count one
                int one_count=0;
                for(int j=i+1;j<n;j++){
                    if(s.charAt(j)=='1'){
                        one_count++;
                    }
                }
            ans=Math.max(ans, count_zero+one_count);
        }
        return ans;
    }
}