import java.util.*;

class Solution {
    public List<Integer> findLonely(int[] nums) {
        List<Integer> arr = new ArrayList<>();

        Arrays.sort(nums); // ✅ Moved to top to ensure proper neighbor checks

        // ✅ Handle edge case: if array has only 1 element
        if (nums.length == 1) {
            arr.add(nums[0]);
            return arr;
        }

        // ✅ First element check
        if (nums[1] != nums[0] + 1 && nums[1] != nums[0] - 1 && nums[0] != nums[1]) {
            arr.add(nums[0]);
        }

        // ✅ Middle elements
        for (int i = 1; i < nums.length - 1; i++) {
            if (nums[i - 1] != nums[i] - 1 &&
                nums[i - 1] != nums[i] + 1 &&
                nums[i + 1] != nums[i] - 1 &&
                nums[i + 1] != nums[i] + 1 &&
                nums[i - 1] != nums[i] &&
                nums[i + 1] != nums[i]) {
                arr.add(nums[i]);
            }
        }

        // ✅ Last element check
        if (nums[nums.length - 2] != nums[nums.length - 1] + 1 &&
            nums[nums.length - 2] != nums[nums.length - 1] - 1 &&
            nums[nums.length - 2] != nums[nums.length - 1]) {
            arr.add(nums[nums.length - 1]);
        }

        return arr;
    }
}
