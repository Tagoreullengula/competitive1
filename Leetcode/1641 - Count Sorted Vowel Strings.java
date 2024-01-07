class Solution {
    public int countVowelStrings(int n) {
        int numF = 1;
        for (int i=n+1; i<=n+4; numF*=i,i++);
        return numF/24;
    }
}
