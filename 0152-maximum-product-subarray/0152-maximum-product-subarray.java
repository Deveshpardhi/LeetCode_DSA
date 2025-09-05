class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;

        // Build prefix products, resetting after zeros
        int[] pref = new int[n];
        int running = 1;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                pref[i] = 0;
                running = 1;          // reset for next segment
            } else {
                running *= nums[i];
                pref[i] = running;    // product since last zero (exclusive)
            }
        }

        int max = Integer.MIN_VALUE;

        // Scan all subarrays within each zero-free segment
        int lastZero = -1;
        for (int r = 0; r < n; r++) {
            if (nums[r] == 0) {
                max = Math.max(max, 0);  // a subarray could be just the zero
                lastZero = r;            // start a new segment after this
                continue;
            }
            for (int l = lastZero + 1; l <= r; l++) {
                int leftProd = (l == lastZero + 1) ? 1 : pref[l - 1];
                int prod = pref[r] / leftProd;   // exact division within the segment
                if (prod > max) max = prod;
            }
        }

        return max;
    }
}
