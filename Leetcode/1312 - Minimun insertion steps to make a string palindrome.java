class Solution {
    public int minInsertions(String s) {
        int n = s.length();
        int lcs[][]= new int [n+1][n+1];
        for (int i=1;i<=n;i++){
            for (int j=1;j<=n;j++){
                lcs[i][j]  =  Math.max(Math.max(lcs[i-1][j], lcs[i][j-1]), (s.charAt(i-1) == s.charAt(n-j))? lcs[i-1][j-1]+1 : Integer.MIN_VALUE);
            }
        }
        return n-lcs[n][n];
    }
}