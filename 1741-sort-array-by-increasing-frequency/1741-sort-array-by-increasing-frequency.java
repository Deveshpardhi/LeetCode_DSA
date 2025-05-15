import java.util.*;

class Solution {
    public int[] frequencySort(int[] nums) {
        // Step 1: Count the frequency of each number
        HashMap<Integer, Integer> freq = new HashMap<>();
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        // Step 2: Convert the array to Integer[] so we can sort with a comparator
        Integer[] arr = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            arr[i] = nums[i];
        }

        // Step 3: Sort the array
        Arrays.sort(arr, new Comparator<Integer>() {
            public int compare(Integer a, Integer b) {
                int freqA = freq.get(a);
                int freqB = freq.get(b);

                if (freqA != freqB) {
                    return freqA - freqB; // Sort by increasing frequency
                } else {
                    return b - a; // If same frequency, sort by decreasing number
                }
            }
        });

        // Step 4: Convert Integer[] back to int[]
        int[] result = new int[nums.length];
        for (int i = 0; i < arr.length; i++) {
            result[i] = arr[i];
        }

        return result;
    }
}
