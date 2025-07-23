import java.util.ArrayDeque;
import java.util.Deque;

class Solution {

    /**
     * Removes every occurrence of the pair (a,b) in that order and
     * returns both the remaining string and the points gained.
     */
    private Object[] helper(String str, char a, char b, int points) {
        Deque<Character> stack = new ArrayDeque<>();
        int gained = 0;

        for (char ch : str.toCharArray()) {
            if (ch == b && !stack.isEmpty() && stack.peek() == a) {
                stack.pop();          // delete the pair “ab” / “ba”
                gained += points;     // add points
            } else {
                stack.push(ch);
            }
        }

        // build the leftover string (stack is LIFO, so reverse at the end)
        StringBuilder rem = new StringBuilder();
        while (!stack.isEmpty()) rem.append(stack.pop());
        rem.reverse();

        return new Object[]{rem.toString(), gained};   // ← return real score!
    }

    public int maximumGain(String s, int x, int y) {
        int total = 0;

        if (x >= y) {  // remove “ab” (worth x) first
            Object[] res1 = helper(s, 'a', 'b', x);
            total += (Integer) res1[1];

            Object[] res2 = helper((String) res1[0], 'b', 'a', y);
            total += (Integer) res2[1];                // ← use the 2nd result
        } else {       // remove “ba” (worth y) first
            Object[] res1 = helper(s, 'b', 'a', y);
            total += (Integer) res1[1];

            Object[] res2 = helper((String) res1[0], 'a', 'b', x);
            total += (Integer) res2[1];
        }

        return total;
    }
}
