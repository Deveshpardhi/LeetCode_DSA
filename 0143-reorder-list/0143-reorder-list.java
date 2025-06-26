class Solution {
    public ListNode mid(ListNode head){
        ListNode slow = head;
        ListNode fast = head.next;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;

        ListNode mid = mid(head);
        ListNode left = head;
        ListNode curr = mid.next;
        mid.next = null; // break the list
        ListNode prev = null;
        ListNode next;

        // Reverse second half
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        ListNode right = prev;
        ListNode nl, nr;

        // Merge two halves
        while (left != null && right != null) {
            nl = left.next;
            nr = right.next;

            left.next = right;
            right.next = nl;

            left = nl;
            right = nr;
        }
    }
}
