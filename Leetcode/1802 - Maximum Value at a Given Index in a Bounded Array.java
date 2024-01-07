class Solution {
    public long geometricF(long n) {
        if (n<0) {
            return 0;
        }
        return (n*n + n)/2;
    }
    
    public int maxValue(int n, int index, int maxSum) {
        int max = (int)Math.sqrt(maxSum-n);
        int residual = maxSum - n - max*max;
        int cutLeft = max-1-index;
        int cutRight = max+index-n;
        int len = Math.max(max*2-1, 0) - Math.max(cutLeft, 0) - Math.max(cutRight, 0);
        residual += (int)geometricF(cutLeft) + (int)geometricF(cutRight);
        
        if (cutLeft > 0 && cutRight <= 0 || cutLeft <= 0 && cutRight > 0) {
            double root = Math.sqrt((geometricF(len)+residual)*8 + 1);
            int x = (int)Math.min((root-1)/2, n);
            residual =residual - (int)( geometricF(x)-geometricF(len) );
            max = max + x - len;
        }
        return max + residual/n +1;
    }
}
