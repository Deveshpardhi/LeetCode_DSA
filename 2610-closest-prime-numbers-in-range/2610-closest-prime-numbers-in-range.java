class Solution {

    public boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public int[] closestPrimes(int left, int right) {
        ArrayList<Integer> arr = new ArrayList<>();
        int[] result = new int[2];
        int min = Integer.MAX_VALUE;

        for (int i = left; i <= right; i++) {
            if (isPrime(i)) {
                arr.add(i);
            }
        }

        if (arr.size() < 2) {
            result[0] = -1;
            result[1] = -1;
            return result;
        }

        for (int i = 0; i < arr.size() - 1; i++) {
            int dif = arr.get(i + 1) - arr.get(i);
            if (dif < min) {
                min = dif;
                result[0] = arr.get(i);
                result[1] = arr.get(i + 1);
            }
        }
        return result;
    }
}
