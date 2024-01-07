class Solution {
    int grid[][];
    int pathCounter;
    int R[]={-1,0,1,0};
    int C[]={0,1,0,-1};
    
    public int getStatus(int x, int y){
        if(0<=x && x<grid.length && 0<=y && y< grid[0].length) {
            if (grid[x][y] == 1) {
                return 1;
            } else {
                if(grid[x][y] == 0 || grid[x][y] == 2){
                    return 0;
                }
            }
        } else {
            return 3;
        }
        return -1;
    }
    
    public void goNextSlot(int r, int c, int pi, int slotsCounter){
        if(grid[r][c]==2) {
            if(slotsCounter == 1) {
                pathCounter++;
            }
            return;
        }

        grid[r][c]=1;
        
        for (int i=0; i<4; i++) {
            int nr = r+R[i];
            int nc = c+C[i];
            if (getStatus(nr, nc) == 0) {
                goNextSlot(nr, nc, i, slotsCounter - 1);
            }
        }
        grid[r][c]=0;
    }
    
    public int uniquePathsIII(int[][] grid) {
        int initialR = 0, initialC = 0;
        pathCounter=0;
        int slotsCounter = 0;
        this.grid = grid;
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 1){
                    initialR = i;
                    initialC = j;
                }
                if(grid[i][j] >=0){
                    slotsCounter++;
                }
            }
        }
        goNextSlot(initialR, initialC, 0, slotsCounter);
        return pathCounter;
    }
}
