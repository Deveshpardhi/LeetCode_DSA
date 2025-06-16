class Solution {
    public int max(int arr[],int idx){
        int max=Integer.MIN_VALUE;
        for(int i=idx+1;i<arr.length;i++){
            if(max<arr[i]){
                max=arr[i];
            }
        }
        return max;
    }
    public int[] replaceElements(int[] arr) {
        int n=arr.length;
        
        for(int i=0;i<n-1;i++){
            arr[i]=max(arr,i);
        }
        arr[n-1]=-1;
        return arr;
    }
}