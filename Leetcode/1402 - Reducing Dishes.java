class Solution {
    public int maxSatisfaction(int[] satisfaction) {
        Arrays.sort(satisfaction);
        int max = 0;
        for(int i = satisfaction.length-1, cumulative=0, likeTime=0; i>=0; i--){
            cumulative += satisfaction[i];
            likeTime +=  cumulative;
            max = Math.max(likeTime, max);
        }
        return max;
    }
}
