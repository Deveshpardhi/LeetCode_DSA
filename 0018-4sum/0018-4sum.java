import java.util.*;

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Set<List<Integer>> set = new HashSet<>(); // use set to avoid duplicates
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 3; i++) {
            for (int j = i + 1; j < nums.length - 2; j++) {
                int lp = j + 1;
                int rp = nums.length - 1;

                while (lp < rp) {
                    long sum = (long)nums[i] + nums[j] + nums[lp] + nums[rp]; // use long to avoid overflow
                    if (sum == target) {
                        List<Integer> quad = Arrays.asList(nums[i], nums[j], nums[lp], nums[rp]);
                        set.add(quad);
                        lp++;
                        rp--;
                    } else if (sum < target) {
                        lp++;
                    } else {
                        rp--;
                    }
                }
            }
        }

        return new ArrayList<>(set); // convert set to list before returning
    }
}
