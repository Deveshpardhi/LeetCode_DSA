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
    public int sumIndicesWithKSetBits(List<Integer> nums, int k) {
        int sum=0;
        for(int i=0;i<nums.size();i++){
            if(count(i)==k){
                sum+=nums.get(i);
            }
        }
        return sum;
    }
}