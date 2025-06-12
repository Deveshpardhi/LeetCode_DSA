class Solution {
    public int maxAdjacentDistance(int[] nums) {
        int max= -999999;

        for(int i=0;i<nums.length-1;i++){
            int n=Math.abs(nums[i]-nums[i+1]);
            if(max<n){
                max=n;
            }
        }
        int m=Math.abs(nums[0]-nums[nums.length-1]);
        if(max<m){
                max=m;
            }
        return max;
    }
}