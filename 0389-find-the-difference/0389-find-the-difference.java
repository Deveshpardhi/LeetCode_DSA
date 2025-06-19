import java.util.Arrays;

class Solution {
    public char findTheDifference(String s1, String t1) {
        char[] c1 = s1.toCharArray();
        char[] c2 = t1.toCharArray();
        
        Arrays.sort(c1);
        Arrays.sort(c2);

        for (int i = 0; i < c1.length; i++) {
            if (c1[i] != c2[i]) {
                return c2[i];
            }
        }
        // If all previous chars are same, the last char in t1 is the extra one
        return c2[c2.length - 1];
    }
}
