class Solution {
    public int findFinalValue(int[] nums, int original) {
        Set<Integer> set = new HashSet<>();
        for(int i:nums){
            set.add(i);
        }
        int i=0;
        while(set.contains(original) && i<nums.length){
            original=original*2;
            i++;
        }
        return original;
    }
}