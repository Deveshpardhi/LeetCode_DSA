class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        List<int[]> res=new ArrayList<>();
        int i=0,j=0;
         
         while(i<firstList.length && j<secondList.length){
            int st=Math.max(firstList[i][0],secondList[j][0]);
            int ed=Math.min(firstList[i][1],secondList[j][1]);
            if(st<=ed){
                res.add(new int[]{st, ed});
            }
            if(firstList[i][1] < secondList[j][1]){
                i++;
            }else{
                j++;
            }
         }
         return res.toArray(new int[res.size()][]);
    }
}