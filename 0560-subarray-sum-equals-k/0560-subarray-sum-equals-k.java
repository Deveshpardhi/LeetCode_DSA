class Solution {
    public int subarraySum(int[] arr, int k) {
        int sum = 0;
        int count = 0;

        
        for (int start = 0; start < arr.length; start++) {
            sum = 0; 
            for (int end = start; end < arr.length; end++) {
                sum += arr[end]; 
                
                if (sum == k) {
                    count++; 
                }
            }
        }

        return count;
    }
}