class Solution {
    static class Xsum implements Comparable<Xsum> {
        int val;
        int count;

        Xsum(int val, int count) {
            this.val = val;
            this.count = count;
        }

        @Override
        public int compareTo(Xsum x) {
            if (this.count != x.count) return x.count - this.count;
            return x.val - this.val;
        }
    }

    public int[] findXSum(int[] nums, int k, int x) {
        int n = nums.length - k + 1, idx = 0;
        int[] arr = new int[n];
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            map.clear();

            PriorityQueue<Xsum> pq = new PriorityQueue<>();
            for (int j = i; j < k + i; j++) {
                map.put(nums[j], map.getOrDefault(nums[j], 0) + 1);
            }

            Set<Integer> key = map.keySet();
            for (int k0 : key) {
                pq.add(new Xsum(k0, map.get(k0)));
            }

            int take = Math.min(x, pq.size());
            for (int k1 = 0; k1 < take; k1++) {
                Xsum x1 = pq.remove();
                arr[i] += x1.val * x1.count; 
            }
        }
        return arr;
    }
}
