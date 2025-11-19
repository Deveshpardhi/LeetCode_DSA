class Solution {
    public boolean kLengthApart(int[] nums, int k) {

        int n = nums.length;
        int i = 0;

        // same idea as your code, but we control i manually
        while (i < n - 1) {
            int count = 0;

            if (nums[i] == 1) {
                i++;  // move to the next element

                // count zeros after this 1
                while (i < n && nums[i] == 0) {
                    count++;
                    i++;
                }

                // if we found another 1 and gap is less than k -> false
                if (i < n && count < k) {
                    return false;
                }
            } else {
                i++;  // just move ahead if current is 0
            }
        }

        return true;
    }
}
