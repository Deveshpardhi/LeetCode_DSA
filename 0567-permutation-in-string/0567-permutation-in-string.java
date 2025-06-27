import java.util.HashMap;

class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;

        HashMap<Character, Integer> freqMap = new HashMap<>();

        for (char ch : s1.toCharArray()) {
            freqMap.put(ch, freqMap.getOrDefault(ch, 0) + 1);
        }

        int windowSize = s1.length();
        HashMap<Character, Integer> windowMap = new HashMap<>();

        for (int i = 0; i < s2.length(); i++) {
            // Add current char to window map
            char ch = s2.charAt(i);
            windowMap.put(ch, windowMap.getOrDefault(ch, 0) + 1);

            // Remove leftmost char when window size exceeds
            if (i >= windowSize) {
                char leftChar = s2.charAt(i - windowSize);
                windowMap.put(leftChar, windowMap.get(leftChar) - 1);
                if (windowMap.get(leftChar) == 0) {
                    windowMap.remove(leftChar);
                }
            }

            // Compare maps
            if (freqMap.equals(windowMap)) {
                return true;
            }
        }

        return false;
    }
}
