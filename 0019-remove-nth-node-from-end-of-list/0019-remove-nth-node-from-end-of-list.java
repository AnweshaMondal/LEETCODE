/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        
        if(head == null) return null;

        // Create a dummy node that points to the head
        // ListNode dummy = new ListNode(0);
        // dummy.next = head;

        // ListNode fast = dummy;
        // ListNode slow = dummy;

        
        ListNode fast = head;
        ListNode slow = head;

        int i = 0;

        while(i<n)
        {
            fast = fast.next;
            i++;
        }

      //if fast == null -> that means we have to delete the 1st node
      if(fast == null) return head.next;

        while(fast.next != null)
        {
            slow = slow.next;
            fast = fast.next;
        }

        //delete Node
        slow.next = slow.next.next;

        return head;
    }
}