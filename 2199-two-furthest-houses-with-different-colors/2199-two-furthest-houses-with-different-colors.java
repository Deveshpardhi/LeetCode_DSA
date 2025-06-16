class Solution {
    public int maxDistance(int[] colors) {
        int n = colors.length;
        int max = 0;

        // Check from the start against end
        for (int i = 0; i < n; i++) {
            if (colors[i] != colors[0]) {
                max = Math.max(max, i);
            }
            if (colors[i] != colors[n - 1]) {
                max = Math.max(max, n - 1 - i);
            }
        }

        return max;
    }
}
