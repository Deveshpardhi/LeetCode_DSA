class Solution {

    public int hammingWeight(int n) {
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
}