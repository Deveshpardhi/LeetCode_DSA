class Solution {
    private boolean isPossible(int[][] rectangles, int k) {
        // Sort rectangles based on the k-th coordinate (either x or y)
        Arrays.sort(rectangles, Comparator.comparingInt(a -> a[k]));

        int cuts = 0;
        int mx = rectangles[0][k + 2]; // Track the maximum endpoint

        // Iterate through rectangles to check for possible cuts
        for (int i = 0; i < rectangles.length; i++) {
            int b = rectangles[i][k];    // Start of the current rectangle
            int e = rectangles[i][k + 2]; // End of the current rectangle

            // If there's a valid gap, increment the cut count
            if (mx <= b) cuts++;

            // Update the maximum endpoint
            mx = Math.max(mx, e);
        }

        // At least two valid cuts should be present
        return cuts >= 2;
    }

    public boolean checkValidCuts(int n, int[][] rectangles) {
        return isPossible(rectangles, 0) || isPossible(rectangles, 1);
    }
}
