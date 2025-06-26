class Solution {
    public int longestSubsequence(String s, int k) {
        int count = 0;
        int length = s.length();
        long value = 0;
        int power = 0;

        // Traverse from right to left
        for (int i = length - 1; i >= 0; i--) {
            char c = s.charAt(i);

            if (c == '0') {
                count++;  // Always include 0
            } else {
                // Check if including this '1' exceeds k
                if (power < 32 && value + (1L << power) <= k) {
                    value += (1L << power);
                    count++;
                }
            }

            power++;
        }

        return count;
    }
}
