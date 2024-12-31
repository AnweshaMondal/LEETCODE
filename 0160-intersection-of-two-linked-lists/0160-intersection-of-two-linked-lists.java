/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
 //Cover same distance by the 2 traversing variables
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
          ListNode ta = headA;
          ListNode tb = headB;
        
          if(headA == null || headB == null){
            return null;
          }

          while(ta != tb){
            ta = (ta == null) ? headB : ta.next;
            tb = (tb == null) ? headA : tb.next;
          }
       
        // Either both pointers are null (no intersection) or they meet at the intersection node
         return ta; 
    }
}