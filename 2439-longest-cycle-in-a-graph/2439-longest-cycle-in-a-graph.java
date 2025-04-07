class Solution {
    static int currPathIndex = -1;

    public int longestCycle(int[] edges) {
        int n = edges.length;        
        int maxCycle = -1;
        for (int i = 0; i < n; i++) {
            if (edges[i] < 0)
                continue;
            int cycleLen = cycleLength(i, edges);
            if (cycleLen > maxCycle) {
                maxCycle = cycleLen;
            }
        }
        return maxCycle;
    }

    int cycleLength(int u, int[] edges) {
        int startPathIndex = this.currPathIndex;
        while (u != -1) {
            if (edges[u] <= startPathIndex) { 
                return -this.currPathIndex + edges[u]; 
            }
            if (edges[u] < 0) {
                // visited before, wasn't part of a cycle
                return -1;
            }
            int v = edges[u];
            edges[u] = this.currPathIndex--;
            u = v;
        }
        return -1;
    }
}