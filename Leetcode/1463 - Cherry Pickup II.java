class Solution {
    public int cherryPickup(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int mxm [][]= new int [m][m];
        for (int i = 0; i<m; i++) {
            for (int j = i+1; j<m; j++) {
                mxm[i][j]= grid[n-1][i]+grid[n-1][j];
            }
        }
        
        for(int i = n-2; i>=0; i--){
            int newMxM [][]= new int [m][m];
            for (int j = 0; j<m; j++) {
                for (int k = j+1; k<m; k++) {
                    for(int j1=Math.max(0, j-1); j1<=Math.min(m-1, j+1); j1++) {
                        for(int k1=Math.max(j1+1, k-1); k1<=Math.min(m-1, k+1); k1++){
                            newMxM[j][k] = Math.max(newMxM[j][k], mxm[j1][k1]);
                        }
                    }
                    newMxM[j][k] += grid[i][j]+grid[i][k];
                    newMxM[k][j] = newMxM[j][k];
                }
            }
            mxm=newMxM;
        }
        return mxm[0][m-1];
    }
}
