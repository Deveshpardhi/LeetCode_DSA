class Solution {
    public String reverseVowels(String s) {
        Stack<Character> str=new Stack<>();
        char ans[]=new char[s.length()];
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='a' || s.charAt(i)=='e' || s.charAt(i)=='i' ||s.charAt(i)=='o' ||s.charAt(i)=='u' ||s.charAt(i)=='A' ||s.charAt(i)=='E' ||s.charAt(i)=='I' || s.charAt(i)=='U' || s.charAt(i)=='O' ){
                str.push(s.charAt(i));
            }else{
                ans[i]=s.charAt(i);
            }
        }
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='a' || s.charAt(i)=='e' || s.charAt(i)=='i' ||s.charAt(i)=='o' ||s.charAt(i)=='u' ||s.charAt(i)=='A' ||s.charAt(i)=='E' ||s.charAt(i)=='I' || s.charAt(i)=='U' || s.charAt(i)=='O' ){
                ans[i]=str.pop();
            }
        }
        return new String(ans);
    }
}