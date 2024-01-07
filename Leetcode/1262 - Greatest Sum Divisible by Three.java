class Solution {
    public int maxSumDivThree(int[] nums) {
        int maxSums[] = new int [3];
        for(int i =0;i<nums.length;i++){
            int newSums [] = new int [3];
            for(int k=nums[i]%3,j=0;j<3;j++,k=(k+1)%3) {
                newSums[k] = Math.max(maxSums[k], maxSums[j]%3 == j? nums[i]+maxSums[j]:-1);  
            }
            maxSums= newSums;
        }
        return maxSums[0];
    }
}
