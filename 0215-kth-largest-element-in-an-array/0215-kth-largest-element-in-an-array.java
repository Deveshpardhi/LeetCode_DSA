class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq=new PriorityQueue<>(Comparator.reverseOrder());
        int n=0;
        for(int i=0;i<nums.length;i++){
            pq.add(nums[i]);
        }
        while(k-->0){
            n=pq.remove();
        }
        return n;
    }
}