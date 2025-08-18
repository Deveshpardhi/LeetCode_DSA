class Solution {
    public void moveZeroes(int[] nums) {
        int sum=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                sum++;
            }
        }
        for(int i=0;i<nums.length-sum;i++){
            if(nums[i]==0){
                int j=i+1;
                while(nums[j]==0 && j<nums.length){
                    j++;
                }
                int temp=nums[i];
                nums[i]=nums[j];
                nums[j]=temp;
            }
        }
        
    }
}