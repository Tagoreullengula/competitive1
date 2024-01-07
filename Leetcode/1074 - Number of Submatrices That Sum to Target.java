class Solution {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;
        int M [][] = new int [n+1][m+1];
        for (int i = 1; i<=n; i++) {
            for (int j = 1; j<=m; j++) {
                M[i][j] = matrix[i-1][j-1];
            }
        }
        int c = 0;
        matrix = null;
        for (int i=1; i<=n; i++) {
            HashMap<Integer, Integer> hash []= new HashMap[i+1];
            for (int j=1; j<=i; j++) {
                hash[j] = new HashMap<>();
            }
            
            for (int j=1; j<=m; j++) {
                M[i][j] = M[i][j] + M[i-1][j] + M[i][j-1] - M[i-1][j-1];
                for (int k = 1; k<=i; k++) {
                    int diff = M[i][j] - M[k-1][j];
                    if (diff == target) { c++; }
                    if (hash[k].containsKey(diff-target)) {
                        c += hash[k].get(diff-target);
                    }
                    hash[k].put(diff, hash[k].containsKey(diff)? hash[k].get(diff)+1:1);
                }
            }
        }
        
        return c;
    }
}
