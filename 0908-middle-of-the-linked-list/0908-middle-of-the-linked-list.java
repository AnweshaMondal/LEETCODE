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

 //Slow and Fast Pointer
class Solution {
    public ListNode middleNode(ListNode head) {
        if(head == null) return null;
        
        //In case of Even length -> it always finds the 2nd Middle node 
        ListNode fast = head;
        ListNode slow = head;

        while(fast!= null && fast.next != null) //fast.next != null ->For odd length LL
        {                                       //fast != nulll -> for even length LL
           slow = slow.next;
           fast = fast.next.next;
        }

     return slow;
    }
}