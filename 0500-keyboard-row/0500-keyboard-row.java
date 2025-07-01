class Solution {
    public String[] findWords(String[] words) {
        ArrayList<String> al =new ArrayList<>();
        String first="qwertyuiopQWERTYUIOP";
        String second="asdfghjklASDFGHJKL";
        String third="zxcvbnmZXCVBNM";
        

        for(int i=0;i<words.length;i++){
            String str=words[i];
            int c1=0,c2=0,c3=0;
            for(int j=0;j<str.length();j++){
                char ch=str.charAt(j);
                if(first.contains(String.valueOf(ch))){
                    c1++;
                }else if(second.contains(String.valueOf(ch))){
                    c2++;
                }else{
                    c3++;
                }
            }
            if(c1==str.length() || c2==str.length() || c3==str.length()){
                al.add(str);
            }
        }
        String arr[]=new String[al.size()];
        for(int i=0;i<arr.length;i++){
            arr[i]=al.get(i);
        }
        return arr;
    }
}