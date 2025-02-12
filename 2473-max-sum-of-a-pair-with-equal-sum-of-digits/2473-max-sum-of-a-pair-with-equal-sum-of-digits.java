class Solution {
    public int sum(int n){
        int sum=0;
        while(n!=0){
            sum+=n%10;
            n=n/10;
        }
        return sum;
    }
    public int maximumSum(int[] nums) {
        Map<Integer,Integer> sum=new HashMap<>();
        int max=-1;

        for(int i=0;i<nums.length;i++){
            int digit=sum(nums[i]);

            if(sum.containsKey(digit)){
                max=Math.max(max,sum.get(digit)+nums[i]);
                sum.put(digit,Math.max(sum.get(digit),nums[i]));
            }else{
                sum.put(digit,nums[i]);
            }
        }
        return max;
    }
}