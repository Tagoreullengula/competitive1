class Solution {
    int R[] = {-1,0,1,0};
    int C[] = {0,1,0,-1};
    public void floodfill(int r, int c, char[][] grid){
        grid[r][c] = '0';
        for(int i=0;i<4; i++){
            int nr = r+R[i];
            int nc = c+C[i];
            if(0<=nr && nr<grid.length && 0<=nc && nc<grid[0].length){
                if(grid[nr][nc] == '1'){
                    floodfill(nr, nc, grid);
                }
            }
        }
            
    }
    public int numIslands(char[][] grid) {
        int c=0;
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j] == '1'){
                    floodfill(i,j,grid);
                    c++;
                }
            }
        }
        return c;
    }
}
