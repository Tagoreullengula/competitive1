class Solution {
    int sequence[];
    boolean isUsed[];

    public boolean formSequence (int n, int i){
        while(i<sequence.length && sequence[i]>0)i++;
        if(i==sequence.length) return true;
        while(n>0){
            if(!isUsed[n] && ((n+i<sequence.length && sequence[n+i]==0) || n==1) ){
                isUsed[n]=true;
                sequence[i]=n;
                if(n>1)sequence[n+i]=n;
                if(formSequence(isUsed.length-1, i)) {
                    return true;
                }
                isUsed[n]=false;
                sequence[i]=0;
                if(n>1)sequence[n+i]=0;
            }
            n--;
        }
        return false;
    }
    public int[] constructDistancedSequence(int n) {
        sequence= new int [2*n-1];
        isUsed=new boolean[n+1];
        formSequence(n,0);
        return sequence;
    }
}