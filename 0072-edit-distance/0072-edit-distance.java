class Solution {
    public int minDistance(String word1, String word2) {
        int lenStr1=word1.length();
        int lenStr2=word2.length();
        int[][] dp = new int[lenStr1+1][lenStr2+1];
        for(int i=0;i<=lenStr1;i++){
            dp[i][0]=i;
        }
        //insert char
        for(int i=0;i<=lenStr2;i++){
            dp[0][i]=i;
        }
        for(int i=1;i<=lenStr1;i++){
            for(int j=1;j<=lenStr2;j++){
                if(word1.charAt(i-1)==word2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1]; // no need to perform the operation
                }
                else{
                    int add=dp[i][j-1];
                    int replace=dp[i-1][j-1];
                    int delete=dp[i-1][j];
                    dp[i][j]=1+Math.min(add,Math.min(delete,replace));
                    System.out.print(dp[i][j]+ " ");
                }
            }
        }
        return dp[lenStr1][lenStr2];
    }
}