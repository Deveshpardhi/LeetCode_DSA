class Solution {
    public int balancedStringSplit(String str) {
        Stack<Character> s = new Stack<>();
        int count = 0;

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if (s.isEmpty()) {
                s.push(ch);
            } else {
                if (s.peek() != ch) {
                    s.pop();
                } else {
                    s.push(ch);
                }

                if (s.isEmpty()) {
                    count++;
                }
            }
        }

        return count;
    }
}
