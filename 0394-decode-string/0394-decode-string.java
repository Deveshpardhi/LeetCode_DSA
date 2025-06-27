class Solution {
    public String decodeString(String str) {
        Stack<Character> s = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == ']') {
                String a = "";
                while (s.peek() != '[') {
                    a = s.pop() + a;
                }
                s.pop(); // pop the '['

                // Extract number (may be multiple digits)
                String num = "";
                while (!s.isEmpty() && Character.isDigit(s.peek())) {
                    num = s.pop() + num;
                }
                int n = Integer.parseInt(num);

                // Repeat and push back to stack
                String repeated = a.repeat(n);
                for (char c : repeated.toCharArray()) {
                    s.push(c);
                }
            } else {
                s.push(ch);
            }
        }

        // Build final answer from stack
        StringBuilder ans = new StringBuilder();
        while (!s.isEmpty()) {
            ans.insert(0, s.pop());
        }

        return ans.toString();
    }
}
