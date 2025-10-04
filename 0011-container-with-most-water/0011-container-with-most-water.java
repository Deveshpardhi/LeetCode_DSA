class Solution {
    public int maxArea(int[] arr) {
        int max=0,n=arr.length;
        int lp=0,rp=n-1;

        while(lp<rp){
            int sum=(rp-lp)*Math.min(arr[lp],arr[rp]);
            if(max<sum){
                max=sum;
            }
            if(arr[lp]<=arr[rp]){
                lp++;
            }else{
                rp--;
            }

        }
        return max;
    }
}