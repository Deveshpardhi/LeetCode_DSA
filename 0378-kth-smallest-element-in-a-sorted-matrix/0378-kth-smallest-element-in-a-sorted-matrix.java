class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int lo = matrix[0][0];
        int hi = matrix[n - 1][n - 1];

        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            int cnt = countNotGreater(matrix, mid);

            if (cnt < k) {
                lo = mid + 1;   // k‑th element is larger
            } else {
                hi = mid;       // k‑th element is ≤ mid
            }
        }
        return lo;              // or hi (they’re equal here)
    }

    // counts elements ≤ target in O(n)
    private int countNotGreater(int[][] m, int target) {
        int n = m.length;
        int row = n - 1, col = 0, cnt = 0;

        while (row >= 0 && col < n) {
            if (m[row][col] <= target) {
                cnt += row + 1;
                col++;
            } else {
                row--;
            }
        }
        return cnt;
    }
}
