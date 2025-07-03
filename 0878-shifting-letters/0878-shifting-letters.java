class Solution {
    private char kthCharacter(char ch, int k) {
        k %= 26;                                   
        return (char) ('a' + (ch - 'a' + k) % 26);
    }

    public String shiftingLetters(String s, int[] shifts) {

        for (int i = shifts.length - 2; i >= 0; i--) {
            shifts[i] = (shifts[i] + shifts[i + 1]) % 26;
        }

        StringBuilder sb = new StringBuilder(s.length());
        for (int i = 0; i < shifts.length; i++) {
            sb.append(kthCharacter(s.charAt(i), shifts[i]));
        }
        return sb.toString();
    }
}
