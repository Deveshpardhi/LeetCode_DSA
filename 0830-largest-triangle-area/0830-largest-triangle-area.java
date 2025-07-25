class Solution {
    public double largestTriangleArea(int[][] points) {
        double maxArea = 0.0;
        int n = points.length;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    maxArea = Math.max(maxArea, area(points[i], points[j], points[k]));
                }
            }
        }
        return maxArea;
    }

    private double area(int[] a, int[] b, int[] c) {
        return 0.5 * Math.abs(
            a[0]*(b[1]-c[1]) +
            b[0]*(c[1]-a[1]) +
            c[0]*(a[1]-b[1])
        );
    }
}
