class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int n=intervals.length;
        // Step 1: Sort the activities
        Arrays.sort(intervals, (a,b)->Integer.compare(a[1],b[1]));
        // Step 2: Select activities
        int count=1; // Always select 1st
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