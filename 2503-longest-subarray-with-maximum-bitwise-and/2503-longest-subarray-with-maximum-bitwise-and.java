class Solution {
    public int longestSubarray(int[] nums) {
        int max = Integer.MIN_VALUE;

        for (int val : nums) {
            max = Math.max(max, val);
        }

        int longest = 0, current = 0;

        for (int val : nums) {
            if (val == max) {
                current++;
                longest = Math.max(longest, current);
            } else {
                current = 0;
            }
        }

        return longest;
    }
}
