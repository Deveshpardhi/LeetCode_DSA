class Solution {
    public int[] maxSubsequence(int[] nums, int k) {
        // Store value + index in a min-heap of size k
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> a[0] - b[0] // sort by value (min-heap)
        );

        for (int i = 0; i < nums.length; i++) {
            pq.offer(new int[]{nums[i], i});
            if (pq.size() > k) {
                pq.poll(); // remove smallest
            }
        }

        // Extract top k elements and sort by index to maintain order
        List<int[]> topK = new ArrayList<>(pq);
        topK.sort((a, b) -> a[1] - b[1]); // sort by index

        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = topK.get(i)[0];
        }

        return result;
    }
}
