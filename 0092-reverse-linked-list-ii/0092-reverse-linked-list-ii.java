/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || left == right) return head;

        // 0 →  head   (dummy makes life easier when left == 1)
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        // Step 1: find node just before position `left`
        ListNode beforeLeft = dummy;
        for (int i = 1; i < left; i++) {
            beforeLeft = beforeLeft.next;
        }

        // `curr` is the first node to be reversed
        ListNode curr = beforeLeft.next;
        ListNode prev = null;

        // Step 2: reverse the [left, right] segment
        for (int i = 0; i < right - left + 1; i++) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        // Step 3: reconnect the three pieces
        beforeLeft.next.next = curr; // tail of reversed segment → node after `right`
        beforeLeft.next = prev;      // node before `left` → new head of reversed segment

        return dummy.next;           // new head (handles left == 1)
    }
}
