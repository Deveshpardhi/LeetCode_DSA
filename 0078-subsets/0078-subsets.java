class Solution {
    public List<List<Integer>> bt(int[] arr,List<Integer> a,int i){
        List<List<Integer>> res=new ArrayList<>();
        if(i==arr.length){
            //res.add(new ArrayList<>(a));
            if(a.size()==0){
                res.add(new ArrayList<>());
            }else{
                res.add(new ArrayList<>(a));
            }
            return res;
        }

        a.add(arr[i]);
        res.addAll(bt(arr, a, i + 1));
        a.remove(a.size() - 1);
        res.addAll(bt(arr,a,i+1));
        return res;
    }
    public List<List<Integer>> subsets(int[] nums) {
        return bt(nums, new ArrayList<>(),0);
    }
}