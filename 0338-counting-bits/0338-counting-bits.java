class Solution {
    public int count(int n){
        int count=0;
        while(n!=0){
            int bit=1;
            if((n & bit)==1){
                count++;
            }
            n=n>>1;
        }
        return count;
    }
    public int[] countBits(int n) {
        int arr[]=new int[n+1];
        for(int i=0;i<=n;i++){
            arr[i]=count(i);
        }
        return arr;
    }
}