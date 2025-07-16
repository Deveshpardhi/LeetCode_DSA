class Solution {
    public int maximumLength(int[] nums) {
        int cntEven = 0, cntOdd = 0;
        int dpEven = 0, dpOdd = 0;          // best alternating lengths

        for (int v : nums) {
            if ((v & 1) == 0) {             // even
                cntEven++;
                int newDpEven = Math.max(1, dpOdd + 1); // append or start
                dpEven = Math.max(dpEven, newDpEven);
            } else {                        // odd
                cntOdd++;
                int newDpOdd = Math.max(1, dpEven + 1);
                dpOdd = Math.max(dpOdd, newDpOdd);
            }
        }

        int alt  = Math.max(dpEven, dpOdd);      // best alternating
        int same = Math.max(cntEven, cntOdd);    // all-even or all-odd
        return Math.max(alt, same);
    }
}