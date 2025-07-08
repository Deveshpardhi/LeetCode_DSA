import java.util.*;

class Solution {

    // -------- your Info class (unchanged, just a tiny typo fixed) --------
    public static class Info {
        int st, ed, val;
        Info(int st, int ed, int val) {
            this.st = st;         // start day
            this.ed = ed;         // end day
            this.val = val;       // value
        }
    }

    // ---------- driver ---------------------------------------------------
    public int maxValue(int[][] events, int k) {

        int n = events.length;
        Info[] arr = new Info[n];
        for (int i = 0; i < n; i++)
            arr[i] = new Info(events[i][0], events[i][1], events[i][2]);

        // sort by start day (ASC) so we can binary-search the next slot
        Arrays.sort(arr, Comparator.comparingInt(a -> a.st));

        // extract start days into a plain array for faster searching
        int[] starts = new int[n];
        for (int i = 0; i < n; i++) starts[i] = arr[i].st;

        // memo[idx][rem]  (-1 = not computed)
        int[][] memo = new int[n][k + 1];
        for (int[] row : memo) Arrays.fill(row, -1);

        return dfs(0, k, arr, starts, memo);
    }

    // ---------- top-down DFS with memoisation ----------------------------
    private int dfs(int idx, int rem,
                    Info[] arr, int[] starts,
                    int[][] memo) {

        if (idx == arr.length || rem == 0) return 0;
        if (memo[idx][rem] != -1) return memo[idx][rem];

        // 1️⃣  skip current event
        int best = dfs(idx + 1, rem, arr, starts, memo);

        // 2️⃣  take current event
        int nextIdx = upperBound(starts, arr[idx].ed);          // first start > current end
        int take = arr[idx].val + dfs(nextIdx, rem - 1,
                                      arr, starts, memo);

        return memo[idx][rem] = Math.max(best, take);
    }

    // ---------- upper-bound: first index whose start-day > target --------
    private int upperBound(int[] a, int target) {
        int lo = 0, hi = a.length;
        while (lo < hi) {
            int mid = (lo + hi) >>> 1;
            if (a[mid] <= target) lo = mid + 1;
            else hi = mid;
        }
        return lo;
    }
}
