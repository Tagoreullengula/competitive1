class Solution {
    public int minimumEffortPath(int[][] heights) {
        int r = heights.length;
        int c = heights[0].length;
        int minEffortMatrix [][]= new int [r][c];
        int R [] = {-1,0,1,0};
        int C [] = {0,1,0,-1};
        for(int i=0; i<r; i++) {Arrays.fill(minEffortMatrix[i], -1);}
        PriorityQueue<Pair<Integer, Pair<Integer,Integer>>> pq = new PriorityQueue<Pair<Integer, Pair<Integer,Integer>>>((a,b) -> {
            return a.getKey() > b.getKey()? 1:-1;
        });
        pq.add(new Pair(0, new Pair(0,0)));
        minEffortMatrix[0][0] = 0;
        while (!pq.isEmpty()) {
            Pair<Integer, Pair<Integer, Integer>> cell = pq.poll();
            int i = cell.getValue().getKey();
            int j = cell.getValue().getValue();
            if(i==r-1 && j==c-1){
                break;
            }
            if (cell.getKey() == minEffortMatrix[i][j]) {
                for (int k =0,ni,nj; k<4; k++) {
                    ni=i+R[k];
                    nj=j+C[k];
                    if ( 0<=ni && ni<r && 0<=nj && nj<c) {
                        int newMaxEffort = Math.max (cell.getKey(), Math.abs( heights[i][j] - heights[ni][nj] ));
                        if (minEffortMatrix[ni][nj] == -1 || minEffortMatrix[ni][nj]> newMaxEffort) {
                            minEffortMatrix[ni][nj] = newMaxEffort;
                            pq.add(new Pair(newMaxEffort, new Pair(ni,nj)));
                        }
                    }
                }
            }
        }
        
        return minEffortMatrix[r-1][c-1];
    }
    
}
