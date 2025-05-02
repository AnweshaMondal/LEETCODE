/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void deleteNode(ListNode node) {
        
    //shifting the values to left
    ListNode temp = node;
    ListNode ahead  = temp.next;
    while(ahead.next != null) //want to stop at the 2nd last node, so the condition is written accordingly
       {
        temp.val = ahead.val;
        temp = ahead;
        ahead = ahead.next;
       }
     
     //for the last node
     temp.val = ahead.val;
     temp.next = null;
    
    }
}