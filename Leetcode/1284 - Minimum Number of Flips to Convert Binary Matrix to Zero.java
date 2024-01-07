class Solution {
    int n,m;
    
    public int[][] generateMatrix (int signature) {
        int mat [][]= new int [n][m];
        for(int i = n-1; i>=0; i--) {
            for(int j = m-1; j>=0; j--) {
                mat[i][j] = signature&1;
                signature = signature>>1;
            }
        }
        return mat;
    }
    
    
    public int minFlips(int[][] mat) {
        n = mat.length;
        m = mat[0].length;
        boolean visited [] = new boolean[1<<(n*m)];
        int signature = 0; 
        int nroPasos = 0;
        for(int i=0 ; i<n; i++) {
            for(int j=0 ; j<m; j++) {
               signature = (signature<<1) + mat[i][j]; 
            }
        }
        int R[] = {0,-1,0,1,0};
        int C[] = {0,0,1,0,-1};
        LinkedList<Integer> bfs = new LinkedList<>();
        bfs.add(signature);
        int min=-1;
        while (!bfs.isEmpty() && min==-1) {
            LinkedList<Integer> nextbfs = new LinkedList<>();
            while (!bfs.isEmpty()) {
                signature = bfs.removeFirst();
                if (signature == 0) {
                    min = nroPasos;
                    break;
                }
                
                
                
                if (!visited[signature]) {
                    mat = generateMatrix(signature);
                    LinkedList<Integer> allSignatures = new LinkedList<>();
                    int otherSign = 0;
                    
                    for (int i = 0; i<n; i++) {
                        for (int j = 0; j<m; j++) {
                             otherSign = (otherSign<<1) + mat[i][j];
                        }
                    }
                    allSignatures.add(otherSign);
                    otherSign = 0;
                    for (int i = n-1; i>=0; i--) {
                        for (int j = 0; j<m; j++) {
                             otherSign = (otherSign<<1) + mat[i][j];
                        }
                    }
                    allSignatures.add(otherSign);
                    otherSign = 0;
                    for (int i = 0; i<n; i++) {
                        for (int j = m-1; j>=0; j--) {
                             otherSign = (otherSign<<1) + mat[i][j];
                        }
                    }
                    allSignatures.add(otherSign);
                    otherSign = 0;
                    for (int i = n-1; i>=0; i--) {
                        for (int j = m-1; j>=0; j--) {
                             otherSign = (otherSign<<1) + mat[i][j];
                        }
                    }
                    allSignatures.add(otherSign);
                    otherSign = 0;
                    if (n == m) {
                        for (int j = 0; j<m; j++) {
                            for (int i = 0; i<n; i++) {
                                 otherSign = (otherSign<<1) + mat[i][j];
                            }
                        }
                        allSignatures.add(otherSign);
                        otherSign = 0;
                        for (int j = 0; j<m; j++) {
                            for (int i = n-1; i>=0; i--) {
                                 otherSign = (otherSign<<1) + mat[i][j];
                            }
                        }
                        allSignatures.add(otherSign);
                        otherSign = 0;
                        for (int j = m-1; j>=0; j--) {
                            for (int i = 0; i<n; i++) {
                                 otherSign = (otherSign<<1) + mat[i][j];
                            }
                        }
                        allSignatures.add(otherSign);
                        otherSign = 0;
                        for (int j = m-1; j>=0; j--) {
                            for (int i = n-1; i>=0; i--) {
                                 otherSign = (otherSign<<1) + mat[i][j];
                            }
                        }
                        allSignatures.add(otherSign);
                    }
                    
                    for (Integer sign: allSignatures) {
                        visited [sign]= true;
                    }
                    
                    
                    
                    for (int i = 0; i<n; i++) {
                        for (int j = 0; j<m; j++) {
                            int nextSign = signature;
                            for(int k =0;k<5;k++){
                                int ni=i+R[k];
                                int nj=j+C[k];
                                if(0<=ni && ni<n && 0<=nj && nj<m){
                                    int p = 1<<((n-1-ni)*m + m-nj-1);
                                    if ((nextSign & p) == p) {
                                        nextSign-=p;
                                    } else {
                                        nextSign+=p;
                                    }
                                }
                            }
                            if(!visited[nextSign]){
                                nextbfs.add(nextSign);
                            }
                        }
                    }
                }
            }
            bfs=nextbfs;
            nroPasos++;
        }
        return min;
    }
}
