class Solution {
    public int findLHS(int[] nums) {
        int max=0;
        Arrays.sort(nums);
        
        for(int i=0;i<nums.length;i++){
            int j=i+1;
            while(j<nums.length && nums[j]-nums[i]<=1){
                j++;
            }
            if(nums[j-1]-nums[i]==1){
                max=Math.max(max,j-i);
            }
            
        }
        return max;
    }
}