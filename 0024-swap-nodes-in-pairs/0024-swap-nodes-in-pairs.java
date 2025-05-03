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
    public ListNode swapPairs(ListNode head) {
        
        if(head == null || head.next == null) return head;//handle single and null List
         
        ListNode curr = head;
        ListNode ahead = head.next ;
        ListNode temp = null; //to retrieve the location of prev ptr after updation
        ListNode newHead = head.next;//update head
        

        while(curr != null && curr.next != null)// whenever accessing curr.next.next
        {                                       //do include both 
            ahead = curr.next;
            ListNode aheadNext = ahead.next;//store the next node as we are gonna disconnect the link
            
            curr.next = aheadNext;
            ahead.next = curr;

            if(temp != null) temp.next = ahead;

            temp = curr;
            curr = curr.next;       
        }

      return newHead;
    }
}