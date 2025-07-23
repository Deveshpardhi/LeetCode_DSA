import java.util.ArrayDeque;
import java.util.Deque;

class Solution {

    private Object[] helper(String str, char a, char b, int points) {
        Stack<Character> stack = new Stack<>();
        int gained = 0;

        for (char ch : str.toCharArray()) {
            if (ch == b && !stack.isEmpty() && stack.peek() == a) {
                stack.pop();          
                gained += points;     
            } else {
                stack.push(ch);
            }
        }
        StringBuilder rem = new StringBuilder();
        while (!stack.isEmpty()) rem.append(stack.pop());
        rem.reverse();

        return new Object[]{rem.toString(), gained};   
    }

    public int maximumGain(String s, int x, int y) {
        int total = 0;

        if (x >= y) {  
            Object[] res1 = helper(s, 'a', 'b', x);
            total += (Integer) res1[1];
            Object[] res2 = helper((String) res1[0], 'b', 'a', y);
            total += (Integer) res2[1];               
        } else {      
            Object[] res1 = helper(s, 'b', 'a', y);
            total += (Integer) res1[1];

            Object[] res2 = helper((String) res1[0], 'a', 'b', x);
            total += (Integer) res2[1];
        }

        return total;
    }
}
