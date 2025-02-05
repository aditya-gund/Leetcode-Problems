class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int len= flowerbed.length;
        int count=0;
        for(int i=0;i<len;i++){
         if(flowerbed[i]==0){
            boolean emptyLeftPlot = (i==0) || (flowerbed[i-1]==0);
            boolean emptyRightPlot = (i==len-1) || (flowerbed[i+1]==0);
            if(emptyLeftPlot && emptyRightPlot){
                flowerbed[i]=1;
                count++;
            }
         }
        }
        return count>=n;
    }
}