import java.util.*;

class Solution {
    public int numSubseq(int[] nums, int target) {
        Arrays.sort(nums);
        int mod = 1_000_000_007;
        int count = 0;

        int[] pow = new int[nums.length];
        pow[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            pow[i] = (pow[i - 1] * 2) % mod;
        }

        int i = 0, j = nums.length - 1;

        while (i <= j) {
            if (nums[i] + nums[j] <= target) {
                count = (count + pow[j - i]) % mod;
                i++;
            } else {
                j--;
            }
        }

        return count;
    }
}
