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

//We shall do it by recursion

class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        
        ListNode ptr = head;
       
        for(int i = 0; i<k; i++)
        {  
           if(ptr == null) return head; //this means the ll is shorter than k, 
           ptr = ptr.next;              //so return as it is 
        }                               //BASE CASE

        int t = k;
        ListNode curr=head,prev = null; 
        while(t>0)
        {
          ListNode ahead = curr.next;
          curr.next = prev;
          prev = curr;
          curr = ahead;
          t--;
        }

        head.next = reverseKGroup(curr, k);
        return prev;
    }
}
         