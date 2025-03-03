class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode smallDummy = new ListNode(0); 
        ListNode bigDummy = new ListNode(0);  

        ListNode small = smallDummy, big = bigDummy;
        
        while (head != null) {
            if (head.val < x) {
                small.next = head; 
                small = small.next; 
            } else {
                big.next = head; 
                big = big.next;  
            }
            head = head.next;  
        }
        
        big.next = null;         
        small.next = bigDummy.next; 

        return smallDummy.next;  
    }
}
