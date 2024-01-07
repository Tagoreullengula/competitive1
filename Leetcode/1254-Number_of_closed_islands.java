class Solution {
    private int r, c;
    private int [][] otherGrid;
    private int row [] = {-1,0,1,0};
    private int col [] = {0,1,0,-1};
    private int isClosed;
    private void flodFill (int i, int j) {
        if (otherGrid[i][j] != 0) return;
        otherGrid[i][j] = -1;
        for(int k = 0, ni,nj; k <4; k++){
            ni = i+row[k];
            nj = j+col[k];
            if(0<=ni && ni<r && 0<=nj && nj<c){
                flodFill(ni,nj);
            } else {
                isClosed=0;
            }
        }
    }
    public int closedIsland(int[][] grid) {
        otherGrid = grid;
        r = otherGrid.length;
        c = otherGrid[0].length;
        int closedIslands=0;
        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
                if(otherGrid[i][j] == 0){
                    isClosed=1;
                    flodFill(i,j);
                    closedIslands += isClosed;
                }
            }
        }
        return closedIslands;
    }
}