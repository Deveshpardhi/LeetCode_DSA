class Solution {
    public double myPow(double x, int n) {
       long pow = n;
        if (pow < 0) {
            x = 1 / x;
            pow = -pow;
        }

        double mul = 1;
        while (pow > 0) {
            if ((pow & 1) == 1) {
                mul *= x;
            }
            x *= x;
            pow >>= 1;
        }

        return mul;
    }
}