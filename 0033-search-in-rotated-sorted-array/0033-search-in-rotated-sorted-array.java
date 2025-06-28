class Solution {
    public int searchR(int[] arr, int target,int si,int ei) {
        if(si>ei){
            return -1;
        }
        int mid=si+(ei-si)/2;
        if(arr[mid]==target){
            return mid;
        }
        if(arr[si]<=arr[mid]){
            if(arr[si]<=target && target<=arr[mid]){
                return searchR(arr,target,si,mid-1);
            }else{
                return searchR(arr,target,mid+1,ei);
            }
        }else{
            if(arr[mid]<=target && target<=arr[ei]){
                return searchR(arr,target,mid+1,ei);
            }else{
                return searchR(arr,target,si,mid-1);
            }
        }
        //return mid;
    }
    public int search(int[] nums, int target) {
        return searchR(nums,target,0,nums.length-1);
    }
}
