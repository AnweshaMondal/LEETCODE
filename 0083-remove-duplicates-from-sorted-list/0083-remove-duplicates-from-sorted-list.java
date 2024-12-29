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
    public ListNode deleteDuplicates(ListNode head) {
        //dummy node \U0001f642
        ListNode dummy = new ListNode(-999);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode curr = head;
        
        while(curr != null){
            if(prev.val != curr.val){
                prev = prev.next;
                curr = curr.next;    
            }else{
                prev.next = curr.next;//prev is standing at the same node, just its next got jumped 
                curr = curr.next;
            }

        }
        return head;
    }
}