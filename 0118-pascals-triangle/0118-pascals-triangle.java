class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> al=new ArrayList<>();
        for(int i=0;i<numRows;i++){
            List<Integer> arr=new ArrayList<>();
            for(int j=0;j<i+1;j++){
                if(j==0 || j==i){
                    arr.add(1);
                }else{
                    arr.add(al.get(i - 1).get(j - 1) + al.get(i - 1).get(j));
                }
            }
            al.add(arr);
        }
        return al;
    }    
}