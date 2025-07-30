import java.util.*;

class Solution {
    public int[] smallestSubarrays(int[] nums) {
        int n = nums.length;
        int[] last = new int[32];
        Arrays.fill(last, -1);
        int[] ans = new int[n];

        for (int i = n - 1; i >= 0; --i) {
            int x = nums[i];
            for (int b = 0; b < 32; ++b) {
                if (((x >> b) & 1) == 1) last[b] = i;
            }
            int maxReach = i;
            for (int b = 0; b < 32; ++b) {
                if (last[b] != -1) maxReach = Math.max(maxReach, last[b]);
            }
            ans[i] = maxReach - i + 1;
        }
        return ans;
    }
}
