class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        
        // 1. Sort the array
        Arrays.sort(nums);
        int n = nums.length;
        int[] dp = new int[n];       // dp[i] holds the size of the largest divisible subset ending at nums[i]
        int[] parent = new int[n];   // parent[i] stores the previous index for reconstructing the subset
        
        Arrays.fill(dp, 1);
        Arrays.fill(parent, -1);
        
        int maxLen = 0;
        int maxIndex = 0;
        
        // 2. Fill the dp and parent arrays
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                // If nums[i] can extend the subset ending at nums[j]
                if (nums[i] % nums[j] == 0 && dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1;
                    parent[i] = j;
                }
            }
            // Track the index of the largest subset found so far
            if (dp[i] > maxLen) {
                maxLen = dp[i];
                maxIndex = i;
            }
        }
        
        // 3. Reconstruct the largest divisible subset
        int current = maxIndex;
        while (current >= 0) {
            result.add(nums[current]);
            current = parent[current];
        }
        Collections.reverse(result);
        return result;
    }
}