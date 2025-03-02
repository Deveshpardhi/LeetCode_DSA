class Solution {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        int arr[][] = new int[nums1.length + nums2.length][2]; 
        int num = nums1.length + nums2.length; 
        int n = Math.max(nums1.length, nums2.length);
        int i = 0, j = 0, idx = 0;

        while (i < nums1.length && j < nums2.length) {
            if (nums1[i][0] < nums2[j][0]) {
                arr[idx][0] = nums1[i][0];
                arr[idx][1] = nums1[i][1];
                i++;
            } else if (nums1[i][0] > nums2[j][0]) {
                arr[idx][0] = nums2[j][0];
                arr[idx][1] = nums2[j][1];
                j++;
            } else { 
                arr[idx][0] = nums1[i][0];
                arr[idx][1] = nums1[i][1] + nums2[j][1];
                i++;
                j++;
            }
            idx++;
        }

        while (i < nums1.length) {
            arr[idx][0] = nums1[i][0];
            arr[idx][1] = nums1[i][1];
            idx++;
            i++;
        }

        while (j < nums2.length) {
            arr[idx][0] = nums2[j][0];
            arr[idx][1] = nums2[j][1];
            idx++;
            j++;
        }

        int res[][] = new int[idx][2];
        for (int k = 0; k < idx; k++) {
            res[k][0] = arr[k][0];
            res[k][1] = arr[k][1];
        }

        return res;
    }
}
