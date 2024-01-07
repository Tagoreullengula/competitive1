class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (b1,b2) -> b2[0]<b1[0]?1:-1);
        long endThreshold = Long.MIN_VALUE;
        int arrows=0;
        for(int i=0; i<points.length; i++){
            if(points[i][0]>endThreshold){
                arrows++;
                endThreshold = points[i][1];
            } else {
                endThreshold = Math.min(endThreshold, points[i][1]);
            }
        }
        return arrows;
    }
}
