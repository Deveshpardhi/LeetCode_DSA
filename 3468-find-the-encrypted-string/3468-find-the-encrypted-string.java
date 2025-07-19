class Solution {
    public String getEncryptedString(String s, int k) {
        String ans = "";
        k= k%s.length();
        s=s+s;
        ;
        for (int i =0;i<s.length()/2;i++){
            ans+=s.charAt(i+k);
        }
        return ans;
    }
}