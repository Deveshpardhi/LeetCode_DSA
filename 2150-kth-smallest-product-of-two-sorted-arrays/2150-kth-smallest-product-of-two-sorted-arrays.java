import java.util.*;

class Solution {
    public long kthSmallestProduct(int[] nums1, int[] nums2, long k) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        long left = -10000000000L, right = 10000000000L;
        long ans = 0;

        while (left <= right) {
            long mid = left + (right - left) / 2;
            if (countLessEqual(nums1, nums2, mid) >= k) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return ans;
    }

    private long countLessEqual(int[] nums1, int[] nums2, long mid) {
        long count = 0;

        for (int num : nums1) {
            if (num == 0) {
                if (mid >= 0) {
                    count += nums2.length;
                }
            } else if (num > 0) {
                // Count how many nums2[j] such that num * nums2[j] <= mid
                int l = 0, r = nums2.length - 1;
                while (l <= r) {
                    int m = l + (r - l) / 2;
                    if ((long) num * nums2[m] <= mid) {
                        l = m + 1;
                    } else {
                        r = m - 1;
                    }
                }
                count += l;
            } else { // num < 0
                int l = 0, r = nums2.length - 1;
                while (l <= r) {
                    int m = l + (r - l) / 2;
                    if ((long) num * nums2[m] <= mid) {
                        r = m - 1;
                    } else {
                        l = m + 1;
                    }
                }
                count += (nums2.length - l);
            }
        }

        return count;
    }
}
