class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid[0].length;
        int[] arr = new int[n * n + 1];
        int[] res = new int[2];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[grid[i][j]]++;
            }
        }

        arr[0] = 9999999;

        for (int i = 1; i <= n * n; i++) {
            if (arr[i] == 2) {
                res[0] = i;
                break;
            }
        }

        for (int i = 1; i <= n * n; i++) {
            if (arr[i] == 0) {
                res[1] = i;
                break;
            }
        }
        
        return res;
    }
}
