class Solution {
    public String sortVowels(String s) {
        List<Character> al=new ArrayList<>();
        char str[]=new char[s.length()];
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='a' || s.charAt(i)=='e' || s.charAt(i)=='i' ||s.charAt(i)=='o' ||s.charAt(i)=='u' ||s.charAt(i)=='A' ||s.charAt(i)=='E' ||s.charAt(i)=='I' || s.charAt(i)=='U' || s.charAt(i)=='O' ){
                al.add(s.charAt(i));
            }else{
                str[i]=s.charAt(i);
            }
        }
        Collections.sort(al);
        int idx=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='a' || s.charAt(i)=='e' || s.charAt(i)=='i' ||s.charAt(i)=='o' ||s.charAt(i)=='u' ||s.charAt(i)=='A' ||s.charAt(i)=='E' ||s.charAt(i)=='I' || s.charAt(i)=='U' || s.charAt(i)=='O'){
                str[i]=al.get(idx);
                idx++;
            }
        }
        return new String(str);
    }
}