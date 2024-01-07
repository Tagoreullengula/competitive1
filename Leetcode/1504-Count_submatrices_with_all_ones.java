class Solution {
    public int numSubmat(int[][] mat) {
        int r = mat.length;
        int c = mat[0].length;
        int[][] matFrequency = new int[r][c];
        for(int i = 0; i<c; i++){
            for(int j = 0; j<r; j++){
                if(mat[j][i] == 1){
                    matFrequency[j][i] = j>0? matFrequency[j-1][i]+1:1;
                }
            }
        }
        int counter = 0;
        for(int x = 1; x<=c; x++) {
            for(int y = 1; y<=r; y++) {
                for(int i = y-1; i<r; i++) {
                    int freq = x;
                    for(int j = 0; j + freq<=c; j++) {
                        if (matFrequency[i][j] >= y) {
                            freq--;
                            if (freq == 0) {
                                counter++;
                                freq=1;
                            }
                        } else {
                            freq=x;
                        }
                    }
                }
            }
        }
        return counter;
    }
}