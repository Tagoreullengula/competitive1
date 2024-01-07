class Solution {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        int n = nums.length;
        int cumulativeSum []= new int [n+1];
        cumulativeSum[1]=nums[0];
        for(int i = 2; i<=n; i++){
            cumulativeSum [i] = cumulativeSum[i-1] +nums[i-1];
        }
        int result[] = new int[n];
        for(int i = 1 ;i<=n;i++){
            result[i-1] = cumulativeSum[n] - cumulativeSum[i] - nums[i-1]*(n-i) + nums[i-1]*(i-1) - cumulativeSum[i-1];
        }
        return result;
    }
}
