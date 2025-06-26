class Solution {
    public ListNode swapNodes(ListNode head, int k) {
        ListNode first = head;
        int len = 0;

        // Find the length of the list
        ListNode temp = head;
        while (temp != null) {
            len++;
            temp = temp.next;
        }

        // Find the k-th node from the beginning
        ListNode left = head;
        for (int i = 1; i < k; i++) {
            left = left.next;
        }

        // Find the k-th node from the end
        ListNode right = head;
        for (int i = 1; i < len - k + 1; i++) {
            right = right.next;
        }

        // Swap values
        int t = left.val;
        left.val = right.val;
        right.val = t;

        return head;
    }
}
