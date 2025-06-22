class Solution {
    public List<List<Integer>> largeGroupPositions(String s) {
        List<List<Integer>> ans = new ArrayList<>();
        int i = 0, n = s.length();

        while (i < n) {
            int j = i;
            // Move j to the end of the group of same characters
            while (j < n && s.charAt(j) == s.charAt(i)) {
                j++;
            }
            // Check if the group length is 3 or more
            if (j - i >= 3) {
                ans.add(Arrays.asList(i, j - 1));
            }
            // Move to the next group
            i = j;
        }

        return ans;
    }
}
