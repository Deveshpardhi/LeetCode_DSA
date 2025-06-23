class Solution {
    public boolean isPalindrome(String s){
        int i = 0, j = s.length() - 1;
        while(i < j){
            if(s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }

    public String baseK(long n, int k){
        StringBuilder sb = new StringBuilder();
        while(n > 0){
            sb.append(n % k);
            n /= k;
        }
        return sb.reverse().toString();
    }

    public long kMirror(int k, int n) {
        long sum = 0;
        int len = 1;
        while(n > 0){
            // Odd-length palindromes
            for(int i = (int)Math.pow(10, len - 1); i < (int)Math.pow(10, len); i++){
                String s = Integer.toString(i);
                StringBuilder rev = new StringBuilder(s).reverse();
                String palStr = s + rev.substring(1);
                long pal = Long.parseLong(palStr);  // changed to long

                if(isPalindrome(baseK(pal, k))){
                    sum += pal;
                    n--;
                    if(n == 0) return sum;
                }
            }

            // Even-length palindromes
            for(int i = (int)Math.pow(10, len - 1); i < (int)Math.pow(10, len); i++){
                String s = Integer.toString(i);
                StringBuilder rev = new StringBuilder(s).reverse();
                String palStr = s + rev.toString();
                long pal = Long.parseLong(palStr);  // changed to long

                if(isPalindrome(baseK(pal, k))){
                    sum += pal;
                    n--;
                    if(n == 0) return sum;
                }
            }

            len++;
        }

        return sum;
    }
}
