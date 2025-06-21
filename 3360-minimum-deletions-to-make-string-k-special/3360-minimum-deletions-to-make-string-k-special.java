class Solution {
    public int minimumDeletions(String word, int k) {
        Map<Character, Integer> freqMap = new HashMap<>();

        for (char c : word.toCharArray()) {
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        }

        List<Integer> freqList = new ArrayList<>(freqMap.values());
        int minDeletions = Integer.MAX_VALUE;

        // Try each possible target frequency from 1 to max freq
        for (int f = 1; f <= Collections.max(freqList); f++) {
            int deletions = 0;

            for (int freq : freqList) {
                if (freq < f) {
                    deletions += freq; // remove all characters
                } else if (freq > f + k) {
                    deletions += freq - (f + k); // reduce to (f + k)
                }
            }

            minDeletions = Math.min(minDeletions, deletions);
        }

        return minDeletions;
    }
}