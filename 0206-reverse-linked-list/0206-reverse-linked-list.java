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

 //Inplace
// class Solution {
//     public ListNode reverseList(ListNode head) {

//         if(head == null) return head; //empty list
//         if(head.next == null) return head; //size of the linkedlist is 1
    
//         ListNode prev = head; 
//         ListNode curr = head.next;
//         head.next = null;

//         while(curr!= null)
//         {
//             ListNode ahead = curr.next;
//             curr.next = prev;
//             prev = curr;
//             curr = ahead;
//         }
//         return prev;
//     }
// }

//With Memory->Insert at first
class Solution {
    public ListNode reverseList(ListNode head) {

        if(head == null) return null;
        ListNode temp = head ;
        ListNode copy = null;//initialized to null 

        while(temp != null)
        {
            ListNode newNode = new ListNode(temp.val);
            newNode.next = copy;
            copy = newNode;//traverses along the copy list
            temp = temp.next;//traverses the main/given list
        }

        return copy;
    }
}
