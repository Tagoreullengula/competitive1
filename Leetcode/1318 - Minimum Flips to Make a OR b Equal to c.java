class Solution {
    public int countBits(int n){
        int c=0;
        while(n>0) {
            int nn = ((~n)+1)&n;
            if(nn>0){
                c++;
                n=n&(~nn);
            }
        }
        return c;
    }
    
    public int minFlips(int a, int b, int c) {
        int remainingAbits = a&(~(a&c));
        int remainingBbits = b&(~(b&c));
        int incompleteCbits = c&(~((a|b)&c));
        return countBits(remainingAbits) + countBits(remainingBbits) + countBits(incompleteCbits);
    }
}
