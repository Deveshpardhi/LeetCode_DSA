class Solution {
    public boolean insc(int arr[]){
        for(int i=0;i<arr.length-1;i++){
            if(arr[i]>arr[i+1]){
                return false;
            }
        }
        return true;
    }
    public boolean desc(int arr[]){
        for(int i=0;i<arr.length-1;i++){
            if(arr[i]<arr[i+1]){
                return false;
            }
        }
        return true;
    }
    public boolean isMonotonic(int[] nums) {
        if(insc(nums)){
            return true;
        }else if(desc(nums)){
            return true;
        }else if(insc(nums) && desc(nums)){
            return true;
        }
        return false;
    }
}