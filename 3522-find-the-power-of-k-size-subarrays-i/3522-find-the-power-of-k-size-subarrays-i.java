class Solution {
    public static boolean isSorted(List<Integer> list) {
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i)-list.get(i-1) != 1) {
                return false;
            }
        }
        return true;
    }
    public int[] resultsArray(int[] nums, int k) {
        int arr[] =  new int[nums.length-k+1];
        //Map<ArrayList,int> power=new HashMap<>();
        ArrayList<Integer> list=new ArrayList<>();
        int max=-1;
        
        for(int i=0;i<arr.length;i++){
            for(int j=i;j<i+k;j++){
                list.add(nums[j]);
            }
            
            if(isSorted(list)){
                max=Collections.max(list);
                arr[i]=max;
            }else{
                arr[i]=-1;
            }
            max=-1;
            list.clear();
        }
        return arr;
    }
}