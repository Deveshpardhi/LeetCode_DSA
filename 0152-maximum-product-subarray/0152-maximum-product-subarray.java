class Solution {
    public int maxProduct(int[] nums) {
        // Edge case
        if (nums == null || nums.length == 0) return 0;

        int curMax = nums[0];
        int curMin = nums[0];
        int ans = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int x = nums[i];

            // If x is negative, swapping curMax/curMin handles sign flip
            if (x < 0) {
                int tmp = curMax;
                curMax = curMin;
                curMin = tmp;
            }

            // Extend or restart at x
            curMax = Math.max(x, curMax * x);
            curMin = Math.min(x, curMin * x);

            ans = Math.max(ans, curMax);
        }
        return ans;
    }
}
