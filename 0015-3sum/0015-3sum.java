class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums); // Sort to use two-pointer approach

        for (int i = 0; i < nums.length - 2; i++) {
            // Skip duplicate values for i
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            int lp = i + 1;
            int rp = nums.length - 1;

            while (lp < rp) {
                int sum = nums[i] + nums[lp] + nums[rp];
                if (sum == 0) {
                    ans.add(Arrays.asList(nums[i], nums[lp], nums[rp]));

                    while (lp < rp && nums[lp] == nums[lp + 1]) lp++;
                    while (lp < rp && nums[rp] == nums[rp - 1]) rp--;

                    lp++;
                    rp--;
                } else if (sum < 0) {
                    lp++;
                } else {
                    rp--;
                }
            }
        }

        return ans;
    }
}
