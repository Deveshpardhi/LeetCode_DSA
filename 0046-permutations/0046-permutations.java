class Solution {
    public List<List<Integer>> bt(List<Integer> n, List<Integer> x) {
        List<List<Integer>> res = new ArrayList<>();
        
        if (n.size() == 0) {
            res.add(new ArrayList<>(x)); // make a copy to avoid mutation
            return res;
        }

        for (int i = 0; i < n.size(); i++) {
            int curr = n.get(i);

            // Clone current list to avoid modifying original
            List<Integer> a = new ArrayList<>(n);
            a.remove(i);

            // Add current element to path
            x.add(curr);

            // Recursive call and add all returned permutations
            res.addAll(bt(a, x));

            // Backtrack: remove last added element
            x.remove(x.size() - 1);
        }
        return res;
    }

    public List<List<Integer>> permute(int[] nums) {
        List<Integer> arr = new ArrayList<>();
        for (int num : nums) {
            arr.add(num);
        }
        return bt(arr, new ArrayList<>());
    }
}
