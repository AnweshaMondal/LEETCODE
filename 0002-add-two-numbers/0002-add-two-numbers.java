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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        int c = 0;
        ListNode dummy = new ListNode(-1);
        
        if(l1 == null) return l2;
        if(l2 == null) return l1;

        ListNode ptr1 = l1;
        ListNode ptr2 = l2;
        ListNode temp = dummy;

        while(ptr1 != null || ptr2 != null || c == 1)
        {
            int val1 = 0;
            int val2 = 0;
            ListNode add = new ListNode();//create a new node
            if(ptr1!= null)  val1 = ptr1.val;
            if(ptr2!= null)  val2 = ptr2.val;
            int sum = val1 + val2 + c;
            c = sum / 10;
            add.val = sum % 10;
            temp.next = add;
            temp =temp.next; //move temp to newly created node

            if(ptr1!= null)  ptr1 =  ptr1.next;
            if(ptr2!= null)  ptr2 = ptr2.next;
        }

        return dummy.next;
    }
}