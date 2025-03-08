class Solution {
    public int minimumRecolors(String blocks, int k) {
        int n=blocks.length()-k;
        int min =  9999999;

        if(blocks.length()==k){
            int c=0;
            for(int i=0;i<blocks.length();i++){
                if(blocks.charAt(i)=='W'){
                    c++;
                }
            }
            return c;
        }

        for(int i=0;i<=n;i++){
            int count=0;
            for(int j=i;j<i+k;j++){
                if(blocks.charAt(j)=='W'){
                    count++;
                }
            }
            if(count<min){
                min=count;
            }
        }
        return min;
    }
}