class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int arr[] = new int[nums1.length + nums2.length];
        int n1 = 0, n2 = 0, n = 0;

        while (n1 < nums1.length && n2 < nums2.length) {
            if (nums1[n1] < nums2[n2]) {
                arr[n++] = nums1[n1++];
            } else {
                arr[n++] = nums2[n2++];
            }
        }

        while (n1 < nums1.length) {
            arr[n++] = nums1[n1++];
        }

        while (n2 < nums2.length) {
            arr[n++] = nums2[n2++];
        }

        double ans = 0;
        if (arr.length % 2 == 0) {
            ans = (arr[arr.length / 2] + arr[(arr.length / 2) - 1]) / 2.0;
        } else {
            ans = arr[arr.length / 2];
        }

        return ans;
    }
}
