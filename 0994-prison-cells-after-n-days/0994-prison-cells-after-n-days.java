import java.util.*;

class Solution {
    public int[] prisonAfterNDays(int[] cells, int n) {
        Map<String, Integer> seenDay = new HashMap<>();
        List<int[]> order = new ArrayList<>();
        
        while (n > 0) {
            String key = Arrays.toString(cells);
            if (seenDay.containsKey(key)) {
                int cycleStart = seenDay.get(key);
                int cycleLen = order.size() - cycleStart;
                n %= cycleLen; // jump ahead
                return order.get(cycleStart + n);
            } else {
                seenDay.put(key, order.size());
                order.add(cells);
            }
            cells = nextDay(cells);
            n--;
        }
        return cells;
    }

    private int[] nextDay(int[] a) {
        int[] next = new int[8]; // ends default to 0
        for (int i = 1; i < 7; i++) {
            next[i] = (a[i - 1] == a[i + 1]) ? 1 : 0;
        }
        return next;
    }
}
