class Solution {
    public int reinitializePermutation(int n) {
        int index = 1;
        int counter = 0;
        do {
            counter++;
            if (index < (n>>1)) {
                index = index * 2;
            } else {
                index = ((index - (n>>1))<<1) +1;
            }
        } while (index !=1 );
        return counter;
    }
}

