import java.math.BigInteger; 
class Solution {
    public BigInteger multiplyRange(int i, int j){
        BigInteger f = BigInteger.valueOf(1);
        while(i<=j){
            f=f.multiply(BigInteger.valueOf(i));
            i++;
        }
        return f;
    }
    public int uniquePaths(int m, int n) {
        int N = m+n-2;
        int R = Math.min(m,n)-1;
        int NR = N-R;
        return  multiplyRange(Math.max(R,NR)+1, N).divide(multiplyRange(1, Math.min(R,NR))).intValue();
    }
}