class Solution {

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        boolean[] visited = new boolean[strs.length];
        String[] sorted = new String[strs.length];

        // Step 1: Create sorted string versions for comparison
        for (int i = 0; i < strs.length; i++) {
            char[] s = strs[i].toCharArray();
            Arrays.sort(s);
            sorted[i] = new String(s);
        }

        // Step 2: Group anagrams
        for (int i = 0; i < strs.length; i++) {
            if (visited[i]) continue;

            List<String> group = new ArrayList<>();
            group.add(strs[i]);
            visited[i] = true;

            for (int j = i + 1; j < strs.length; j++) {
                if (!visited[j] && sorted[i].equals(sorted[j])) {
                    group.add(strs[j]);
                    visited[j] = true;
                }
            }

            res.add(group);
        }

        return res;
    }
}
