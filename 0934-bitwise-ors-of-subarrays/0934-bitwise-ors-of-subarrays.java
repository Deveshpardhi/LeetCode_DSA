import java.util.HashSet;
import java.util.Set;

class Solution {
    public int subarrayBitwiseORs(int[] arr) {
        Set<Integer> answer = new HashSet<>();
        Set<Integer> prev = new HashSet<>();
        for (int num : arr) {
            Set<Integer> curr = new HashSet<>();
            curr.add(num);                  
            for (int x : prev) {
                curr.add(x | num);          
            }
            answer.addAll(curr);           
            prev = curr;                    
        }
        return answer.size();
    }
}
