class Solution {

    // shift a lowercase letter forward k positions, wrapping z → a
    private char next(char ch, int k) {
        return (char) ('a' + (ch - 'a' + k) % 26);
    }

    public String replaceDigits(String s) {
        StringBuilder sb = new StringBuilder(s.length());

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch >= 'a' && ch <= 'z') {          // letter → copy as-is
                sb.append(ch);
            } else {                               // digit → shift prev letter
                int k = ch - '0';                  // ① numeric value, not 51/52…
                char base = sb.charAt(sb.length() - 1); // ② previous letter
                sb.append(next(base, k));
            }
        }
        return sb.toString();
    }
}
