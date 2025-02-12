class Solution {
    // Updated method: now checks that each adjacent pair differs by exactly 1.
    public static boolean isSorted(List<Integer> list) {
        for (int i = 1; i < list.size(); i++) {
            // Instead of checking using compareTo, we subtract adjacent elements.
            // If the difference is not exactly 1, the elements are not consecutive.
            if (list.get(i) - list.get(i - 1) != 1) {
                return false;
            }
        }
        return true;
    }
    
    public int[] resultsArray(int[] nums, int k) {
        int arr[] =  new int[nums.length - k + 1];
        ArrayList<Integer> list = new ArrayList<>();
        int max = -1;
        
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < i + k; j++) {
                list.add(nums[j]);
            }
            
            if (isSorted(list)) {
                // Since the window is consecutive and sorted,
                // its maximum element is Collections.max(list) (or simply the last element).
                max = Collections.max(list);
                arr[i] = max;
            } else {
                arr[i] = -1;
            }
            max = -1;
            list.clear();
        }
        return arr;
    }
}
