class Solution {
    int frequency [];
    int factorials[];
    int letter[];
    int n;
    public int dfs(int index, int divisor, int letterCount) {
        int currentPerm = 0;
        letterCount++;
        for (int i=index, count, div; i<n; i++) {
            div= divisor;
            count=letterCount;
            for (int j = 0; j<frequency[letter[i]]; j++, div *= (j+1), count++ ) {
                currentPerm += factorials[count]/div  +  dfs (i+1, div, count);
            }
        }
        return currentPerm;
    }
    
    public int numTilePossibilities(String tiles) {
        char letters[] = tiles.toCharArray();
        frequency  = new int [26];
        factorials = new int [letters.length+1];
        factorials[0] =1;
        n = 0;
        for (int i = 0; i<letters.length; i++) {
            frequency[letters[i]-65]++;
            if(frequency[letters[i]-65] == 1) {
                n++;
            }
            factorials[i+1] = factorials[i]*(i+1);
        }
        letter = new int [n];
        for(int i=0, p=0;i<26; i++) {
            if(frequency[i]>0) {
                letter[p] = i; p++;
            }
        }
        return dfs(0, 1, 0);
    }
}
