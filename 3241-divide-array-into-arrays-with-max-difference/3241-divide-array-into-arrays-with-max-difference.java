class Solution {
    public int[][] divideArray(int[] nums, int k) {
        int arr[][]=new int[nums.length/3][3];
        int ans[][]=new int[nums.length/3][3];
        Arrays.sort(nums);
        int j=0;
        for(int i=0;i<arr.length;i++){
            for(int c=0;c<3;c++){
                arr[i][c]=nums[j];
                j++;
            }
        }
        int ar[][]=new int[0][0];
        for(int i=0;i<arr.length;i++){
            int a=Math.abs(arr[i][0]-arr[i][1]);
            int b=Math.abs(arr[i][2]-arr[i][1]);
            int c=Math.abs(arr[i][0]-arr[i][2]);
            if(a<=k && b<=k && c<=k){
                ans=arr;
            }else{
                ans=ar;
                break;
            }
        }
        return ans;
    }
}