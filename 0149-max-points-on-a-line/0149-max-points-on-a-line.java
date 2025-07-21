import java.util.*;

class Solution {
    public int maxPoints(int[][] points) {
        int n = points.length;
        if (n <= 2) return n;
        int res = 0;

        for (int i = 0; i < n; i++) {
            Map<String, Integer> map = new HashMap<>();
            int overlap = 0, localMax = 0;

            for (int j = i + 1; j < n; j++) {
                int dx = points[j][0] - points[i][0];
                int dy = points[j][1] - points[i][1];

                if (dx == 0 && dy == 0) {
                    overlap++; // same point
                } else {
                    int g = gcd(dx, dy);
                    dx /= g;
                    dy /= g;
                    // To handle sign, keep denominator positive
                    if (dx < 0) {
                        dx = -dx;
                        dy = -dy;
                    }
                    String slope = dx + "," + dy;
                    map.put(slope, map.getOrDefault(slope, 0) + 1);
                    localMax = Math.max(localMax, map.get(slope));
                }
            }
            // Add the anchor point itself and overlaps (if any)
            res = Math.max(res, localMax + overlap + 1);
        }
        return res;
    }

    private int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}
