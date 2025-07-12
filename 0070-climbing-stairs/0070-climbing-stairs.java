class Solution {
    public int algo(int n,int arr[]){
        if(n==0){
            return 1;
        }
        if(n<0){
            return 0;
        }
        if(arr[n]!=0){
            return arr[n];
        }
        arr[n]=algo(n-1,arr)+algo(n-2,arr);
        return arr[n];
    }
    public int climbStairs(int n) {
        int arr[]=new int[n+1];
        return algo(n,arr);
    }
}