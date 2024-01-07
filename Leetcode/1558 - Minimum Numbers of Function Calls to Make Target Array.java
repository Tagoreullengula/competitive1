class Solution {
    public int minOperations(int[] nums) {
        int min = 0;
        int threshold = 1;
        for (int i =0; i<nums.length; i++) {
            if (nums[i]>0) {
                while ((nums[i]>>1) >= threshold) {
                    threshold = threshold<<1;
                    min++;
                }
                while (nums[i]>0) {
                    if (nums[i]%2==0) {
                        nums[i]=nums[i]>>1;
                    } else {
                        nums[i]--;
                        min++;
                    }
                }
            }
        }
        return min;
    }
} 
