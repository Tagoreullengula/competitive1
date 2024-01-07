class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> hash = new HashMap<>();
        int counter= nums[0]==k? 1:0;
        hash.put(nums[0],1);
        for(int i=1;i<nums.length;i++){
            nums[i] += nums[i-1];
            if(nums[i]==k){
                counter++;
            }
            
            if(hash.containsKey(nums[i]-k)){
                counter += hash.get(nums[i]-k);
            }
            
            if(hash.containsKey(nums[i])){
                hash.put(nums[i],hash.get(nums[i])+1);
            } else {
                hash.put(nums[i], 1);
            }
        }
        return counter;
    }
}
