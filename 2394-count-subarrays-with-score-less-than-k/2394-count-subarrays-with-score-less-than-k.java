class Solution {
    public long countSubarrays(int[] nums, long k) {
         int n = nums.length;
        int left = 0;           // window start
        long sum = 0;           // current window sum
        long ans = 0;           // result

        for (int right = 0; right < n; right++) {
            sum += nums[right];

            // shrink from the left until score < k (or window empty)
            while (left <= right && sum * (right - left + 1) >= k) {
                sum -= nums[left++];
            }

            // all windows [left, …, right] are now valid
            ans += (right - left + 1);
        }
        return ans;
    }
}