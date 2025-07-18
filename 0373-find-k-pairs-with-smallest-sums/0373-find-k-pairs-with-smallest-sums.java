import java.util.*;

class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> result = new ArrayList<>();
        
        // Edge case: if either nums1 or nums2 is empty or if k is 0
        if (nums1.length == 0 || nums2.length == 0 || k == 0) {
            return result;
        }

        // Min-heap (priority queue) to store pairs (sum, index in nums1, index in nums2)
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));

        // Initialize the heap with the first element from each row in nums1
        for (int i = 0; i < Math.min(k, nums1.length); i++) {
            minHeap.offer(new int[] {nums1[i] + nums2[0], i, 0});
        }

        // Extract k smallest pairs
        while (k-- > 0 && !minHeap.isEmpty()) {
            int[] current = minHeap.poll();
            int i = current[1]; // index in nums1
            int j = current[2]; // index in nums2

            // Add the pair to the result
            result.add(Arrays.asList(nums1[i], nums2[j]));

            // If there are more elements in the same row (i), add the next element in nums2
            if (j + 1 < nums2.length) {
                minHeap.offer(new int[] {nums1[i] + nums2[j + 1], i, j + 1});
            }
        }

        return result;
    }
}
