class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < nums1.length; i++) {
            map.put(nums1[i], map.getOrDefault(nums1[i], 0) + 1);
        }
        
        List<Integer> al = new ArrayList<>();
        
        for (int i = 0; i < nums2.length; i++) {
            if (map.getOrDefault(nums2[i], 0) > 0) {
                al.add(nums2[i]);
                map.put(nums2[i], map.get(nums2[i]) - 1); 
            }
        }

        int[] arr = new int[al.size()];
        int idx = 0;
        for (int n : al) {
            arr[idx++] = n;
        }
        
        return arr;
    }
}
