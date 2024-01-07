class Solution {
    public int largestOverlap(int[][] img1, int[][] img2) {
        int n = img2.length;
        int img1c =0;
        int img2c = 0;
        for (int i = 0; i<n; i++) {
            for(int j = 0; j<n; j++) {
                img1c+=img1[i][j];
                img2c+=img2[i][j];
            }
        }
        int minImg[][], maxImg[][];
        if(img1c > img2c) {
            minImg = img2;
            maxImg = img1;
        } else {
            maxImg = img2;
            minImg = img1;
        }
        List<Integer> onesInMinR = new LinkedList<>();
        List<Integer> onesInMinC = new LinkedList<>();
        int minR=n;
        int maxR=-1;
        int minC=n;
        int maxC=-1;
        for(int i = 0; i<n ; i++) {
            for(int j = 0; j<n; j++) {
                if(minImg[i][j] == 1) {
                    onesInMinC.add(j);
                    onesInMinR.add(i);
                    minR = Math.min(minR, i);
                    minC = Math.min(minC, j);
                    maxR = Math.max(maxR, i);
                    maxC = Math.max(maxC, j);
                }
            }
        }
        int maxOverLap = 0;
        for(int i = -maxR ; i<=n-1 - minR; i++) {
            for(int j = -maxC; j<=n-1 - minC; j++) {
                int localOverLap = 0;
                Iterator<Integer> itR = onesInMinR.iterator();
                Iterator<Integer> itC = onesInMinC.iterator();
                while(itR.hasNext()) {
                    int ni = itR.next()+i;
                    int nj = itC.next()+j;
                    if(0<=ni && ni<n && 0<=nj && nj<n){
                        localOverLap = localOverLap + maxImg[ni][nj];
                    }
                }
                maxOverLap = Math.max(maxOverLap, localOverLap);
                if ( maxOverLap == img1c || maxOverLap == img2c)
                    return maxOverLap;
                
            }
        }
        return maxOverLap;
    }
}