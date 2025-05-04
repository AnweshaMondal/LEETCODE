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

//linked List Sort = MERGE SORT always
//Divide and conquer

class Solution {
    public ListNode sortList(ListNode head) {
        
        if(head == null || head.next == null) return head;

        ListNode prev = null;
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null) {
          prev = slow;
          slow = slow.next;
          fast = fast.next.next;
        }
        prev.next = null;  // Proper split

        
        ListNode newHead = slow;//break the fast part's link

        return merge(sortList(head),sortList(newHead));
    }


    ListNode merge(ListNode h1, ListNode h2){
        
        if(h1 == null) return h2;//BASE CASES
        if(h2 == null) return h1;

        ListNode merged = null;
        if(h1.val < h2.val) 
        {
           h1.next = merge(h1.next, h2);
           return h1;
        }
        else
        {
           h2.next = merge(h2.next, h1);
           return h2;
        }
    }
}