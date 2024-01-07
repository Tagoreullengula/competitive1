class Solution {
    double log2 = Math.log(2);
    double epsilon = 0.000000001;
    int modulo = (int) Math.pow(10,9)+7;
    
    public int getUpperPowerOfTwo(int n) {
        /*double log2n = Math.log(n)/log2 + 1;
        if((int)(log2n + epsilon) > (int)log2n) {
            log2n++;
        }
        return (int)log2n;*/
        return 0;
    }
    
    public int countPairs(int[] deliciousness) {
        int frequencyHash []= new int [(1<<20)+1];
        for(int i =0; i<deliciousness.length; i++){
            frequencyHash[deliciousness[i]]++;
        }
        int counter = 0;
        
        for(int i =0;i<deliciousness.length; i++) {
            frequencyHash[deliciousness[i]]--;
            for(int j=getUpperPowerOfTwo(deliciousness[i]), pow=1<<j; j<=21 ; j++, pow=pow<<1 ) {
                int diff= pow-deliciousness[i];
                if( diff < frequencyHash.length){
                    if(diff>=0 ){
                        counter = (counter + frequencyHash[pow-deliciousness[i]]) % modulo;
                    }
                } else {
                    break;
                }
            }
        }
        return counter;
    }
}