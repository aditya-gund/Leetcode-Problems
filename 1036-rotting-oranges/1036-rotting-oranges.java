class Solution {
    public int orangesRotting(int[][] grid) {
        int row=grid.length;
        int col=grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int countFreshOranges=0;
        int minTime=0;    
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j]==1){
                    countFreshOranges++;
                }
                else if(grid[i][j]==2){
                    queue.offer(new int[]{i,j});
                }
            }
        }
        int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};
        // Perform BFS for ornages
        while(!queue.isEmpty()){
            int size=queue.size();
            boolean flagRottedOrnages = false;
            for(int i=0;i<size;i++){
                int[]pos = queue.poll();
                int x=pos[0], y=pos[1];
                for(int[] dir: directions){
                    int newR=x+dir[0], newC=y+dir[1];
                    if(newR>=0 && newR<row && newC>=0 && newC<col && grid[newR][newC]==1){
                        grid[newR][newC]=2;
                        queue.offer(new int[]{newR,newC});
                        countFreshOranges--;
                        flagRottedOrnages=true;

                    }
                }
                  
            }
          if(flagRottedOrnages) minTime++;
            
        }
        return countFreshOranges==0 ? minTime:-1;


    }
}