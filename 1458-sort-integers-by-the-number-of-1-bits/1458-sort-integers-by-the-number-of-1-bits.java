import java.util.*;

class Solution {
    public int[] sortByBits(int[] arr) {
        // Convert int[] to Integer[]
        Integer[] boxed = Arrays.stream(arr).boxed().toArray(Integer[]::new);

        // Sort with custom comparator
        Arrays.sort(boxed, (a, b) -> {
            int bitA = Integer.bitCount(a);
            int bitB = Integer.bitCount(b);
            if (bitA == bitB) {
                return a - b;
            } else {
                return bitA - bitB;
            }
        });

        // Convert back to int[]
        for (int i = 0; i < arr.length; i++) {
            arr[i] = boxed[i];
        }

        return arr;
    }
}
