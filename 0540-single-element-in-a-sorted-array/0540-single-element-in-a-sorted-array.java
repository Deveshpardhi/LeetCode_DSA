class Solution {
    public int singleNonDuplicate(int[] nums) {
        int sum=0;
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]==nums[i+1]){
                nums[i+1]=-1*nums[i+1];
            }
        }
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
        }
        return sum;
    }
}