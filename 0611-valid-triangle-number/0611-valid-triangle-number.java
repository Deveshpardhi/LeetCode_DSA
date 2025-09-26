class Solution {
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int count = 0;
        
        // Fix the largest side from index 2 to the end
        for (int right = 2; right < nums.length; right++) {
            int left = 0;
            int mid = right - 1;
            
            // Use two pointers to check pairs of smaller sides
            while (left < mid) {
                if (nums[left] + nums[mid] > nums[right]) {
                    // If valid, all pairs (left, mid), (left, mid-1), ..., (left, left+1) are valid
                    count += (mid - left);
                    mid--;
                } else {
                    left++;
                }
            }
        }
        
        return count;
    }
}
