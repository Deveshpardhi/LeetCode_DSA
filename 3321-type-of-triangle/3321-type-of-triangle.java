class Solution {
    public boolean isTriangle(int arr[]){
        if((arr[0]+arr[1]>arr[2]) && (arr[2]+arr[1]>arr[0]) && (arr[0]+arr[2]>arr[1])){
            return true;
        }
        return false;
    }
    public String triangleType(int[] nums) {
        String ans="";
        if(isTriangle(nums)){
            if(nums[0]==nums[1] && nums[1]==nums[2]){
                ans="equilateral";
            }else if(nums[0]==nums[1] || nums[0]==nums[2] || nums[2]==nums[1]){
                ans="isosceles";
            }else{
                ans="scalene";
            }
        }else{
            ans="none";
        }
        return ans;
    }
}