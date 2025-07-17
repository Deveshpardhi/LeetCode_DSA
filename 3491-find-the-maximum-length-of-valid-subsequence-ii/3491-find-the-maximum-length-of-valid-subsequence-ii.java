class Solution {
    public int maximumLength(int[] nums, int k) {
        int[][] dp = new int[k][k];      
        boolean[] seen = new boolean[k]; 
        int answer = 1;                  

        for (int v : nums) {
            int r = v % k;               
            for (int t = 0; t < k; ++t) {
                int prev = t - r;
                if (prev < 0) prev += k;          
                if (dp[t][prev] > 0) {            
                    int len = dp[t][prev] + 1;   
                    if (len > dp[t][r]) dp[t][r] = len;
                    if (len > answer)   answer = len;
                }
            }
            for (int prev = 0; prev < k; ++prev) {
                if (!seen[prev]) continue;
                int t = (prev + r) % k;
                if (dp[t][r] < 2) dp[t][r] = 2;
                if (answer   < 2) answer   = 2;
            }

            seen[r] = true;  
        }
        return answer;
    }
}