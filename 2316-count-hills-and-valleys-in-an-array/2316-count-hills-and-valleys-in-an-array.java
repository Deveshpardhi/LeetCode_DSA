class Solution {
    public int countHillValley(int[] nums) {
        int count=0;

        for(int i=1;i<nums.length-1;i++){
            int j=i+1;
            while(nums[i]==nums[j] && j<nums.length-1){
                j++;
            }
            //i=j;
            if((nums[i-1]<nums[i] && nums[j]<nums[i]) ||(nums[i-1]>nums[i] && nums[j]>nums[i]) ){
                count++;
            }
        }
        return count;
    }
}