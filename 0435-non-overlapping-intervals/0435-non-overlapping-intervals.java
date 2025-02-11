class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int n=intervals.length;
        int m=intervals[0].length;
        int[] start = new int[n];
        int[] end = new int[m];
        /*
            [ [1,2]
              [2,3]     
              [3,4]
              [1,3]      ]
        
        */
        // Step1: Sort Activities based on there end time
        Arrays.sort(intervals, (a,b)-> Integer.compare(a[1],b[1]));
        // Step 2 : Select activities
        int count=1; // Always select 1st activity
        int lastEndTime=intervals[0][1];
        for(int i=1;i<n;i++){
            if(intervals[i][0]>=lastEndTime){
                count++;
                lastEndTime=intervals[i][1];
            }
        }
        return n-count;
    }
}