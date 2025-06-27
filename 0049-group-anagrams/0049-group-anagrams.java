class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String word : strs) {
            char[] chars = word.toCharArray();
            Arrays.sort(chars);
            String sorted = new String(chars); // sorted version of the word

            // Grouping anagrams using sorted word as key
            map.computeIfAbsent(sorted, k -> new ArrayList<>()).add(word);
        }

        return new ArrayList<>(map.values());
    }
}
