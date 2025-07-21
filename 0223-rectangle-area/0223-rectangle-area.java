class Solution {
    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        int area1 = Math.abs(ax2 - ax1) * Math.abs(ay2 - ay1);
        // Area of second rectangle
        int area2 = Math.abs(bx2 - bx1) * Math.abs(by2 - by1);

        // Calculate overlap along X and Y axes
        int x_overlap = Math.max(0, Math.min(ax2, bx2) - Math.max(ax1, bx1));
        int y_overlap = Math.max(0, Math.min(ay2, by2) - Math.max(ay1, by1));
        int overlapArea = x_overlap * y_overlap;

        return area1 + area2 - overlapArea;
    }
}