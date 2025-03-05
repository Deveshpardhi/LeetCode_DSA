class Solution {
    public long coloredCells(int n) {
        if(n==1){
            return 1;
        }else if(n==2){
            return 5;
        }
        return coloredCells(n-1)+4*(n-1);
    }
}