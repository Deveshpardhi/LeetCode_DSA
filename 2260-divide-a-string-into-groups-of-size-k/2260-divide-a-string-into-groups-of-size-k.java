class Solution {
    public String[] divideString(String s, int k, char fill) {

        int n=s.length()%k;
        if(n!=0){
            n=k-n;
        }
       
        for(int i=0;i<n;i++){
            s+=fill;
        }
        String arr[]=new String[(s.length()+n)/k];
        int j=0;
        for(int i=0;i<arr.length;i++){
            arr[i]=s.substring(j,j+k);
            j=j+k;
        }

        return arr;

    }
}