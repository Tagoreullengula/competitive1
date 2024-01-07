class Solution {
    int max;
    int lettersFreq[];
    char words[][];
    int score[];
    
    public void doCombination (int i, int currentSum) {
        max = Math.max(currentSum, max);
        for (;i<words.length; i++) {
            int wordSum = 0;
            boolean sufficient = true;
            for (int j = 0; j<words[i].length; j++) {
                sufficient = sufficient && (lettersFreq[words[i][j]-97] > 0);
                if (sufficient) {
                    wordSum += score[words[i][j]-97];
                }
                lettersFreq[words[i][j]-97]--;
            }
            if (sufficient) {
                doCombination(i+1, currentSum + wordSum);
            }
            for (int j = 0; j<words[i].length; j++) {
                lettersFreq[words[i][j]-97]++;
            }
        }
    }
    
    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        this.words= new char [words.length][0];
        
        for (int i =0; i<words.length; i++) {
            this.words[i] = words[i].toCharArray();
        }
        
        lettersFreq = new int [26];
        this.score = score;
        
        for (int i = 0; i < letters.length; i++) {
            lettersFreq[letters[i]-97]++;
        }
        max=0;
        doCombination(0, 0);
        return max;
    }
}
