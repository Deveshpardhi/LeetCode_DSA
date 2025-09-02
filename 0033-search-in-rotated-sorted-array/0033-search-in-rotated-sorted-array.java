class Solution {
    public int helper(int arr[],int target,int si,int ei){
        if(si>ei){
            return -1;
        }
         int mid=si+(ei-si)/2;
        if(arr[mid]==target){
            return mid;
        }

        if(arr[si]<=arr[mid]){
            if(arr[si]<=target && target<=arr[mid]){
                return helper(arr,target,si,mid-1);
            }else{
                return helper(arr,target,mid+1,ei);
            }
        }else{
            if(arr[mid]<=target && target<=arr[ei]){
                return helper(arr,target,mid+1,ei);
            }else{
                return helper(arr,target,si,mid-1);
            }
        }
    }
    public int search(int[] nums, int target) {
        return helper(nums,target,0,nums.length-1);
    }
}