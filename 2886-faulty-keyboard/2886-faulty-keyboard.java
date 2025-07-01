class Solution {
    public String reverse(String str,int si,int ei){
        char arr[]=str.toCharArray();
        while(si<ei){
            char temp=arr[ei];
            arr[ei]=arr[si];
            arr[si]=temp;
            si++;
            ei--;
        }
        str="";
        for(int i=0;i<arr.length;i++){
            str+=arr[i];
        }
        return str;
    }
    public String finalString(String s) {
        String str="";
        String ans="";
        int count=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='i'){
                str=reverse(s,0,i-1);
                s=str;
            }else{
                count++;
                ans+=s.charAt(i);
            }
        }
        if(count==s.length()){
            return ans;
        }
        ans="";
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)!='i'){
                ans+=str.charAt(i);
            }else{
                ans=ans;
            }
        }
        return ans;
    }
}