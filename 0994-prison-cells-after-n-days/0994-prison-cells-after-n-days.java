class Solution {
    public int[] prisonAfterNDays(int[] cells, int n) {
        int cycle = 14; 
        n = (n - 1) % cycle + 1; 

        for (int day = 0; day < n; day++) {
            int[] next = new int[8];
            for (int i = 1; i < 7; i++) {
                next[i] = (cells[i - 1] == cells[i + 1]) ? 1 : 0;
            }
            cells = next;
        }
        return cells;
    }
}
