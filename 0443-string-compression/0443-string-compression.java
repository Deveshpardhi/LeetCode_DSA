class Solution {
    public int compress(char[] chars) {
        String str = "";
        int i = 0;
        while (i < chars.length) {
            char current = chars[i];
            int count = 0;
            while (i < chars.length && chars[i] == current) {
                count++;
                i++;
            }
            str += current;
            if (count > 1) {
                str += String.valueOf(count);
            }
        }
        for(int j=0;j<str.length();j++){
                chars[j]=str.charAt(j);
            }
        return str.length();
    }
}