class Solution {
    public int numOfSubarrays(int[] arr) {
        long mod = 1000000007;
        int even = 1, odd = 0, pre = 0;
        long res = 0;  // Change res to long

        for (int i = 0; i < arr.length; i++) {
            pre += arr[i];
            if (pre % 2 == 0) {
                res += odd;
                even++;
            } else {
                res += even;
                odd++;
            }
            res = res % mod;  // No need for casting, since res is now long
        }
        return (int) res;  // Cast back to int before returning
    }
}
