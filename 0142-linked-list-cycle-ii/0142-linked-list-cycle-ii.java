/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
// public class Solution {
//     public ListNode detectCycle(ListNode head) {
//         ListNode temp = head;
//         Set<ListNode> set = new HashSet<>();

//         while(temp!= null){
//             if(set.contains(temp)){
//                 return temp;
//             }
//             set.add(temp);
//             temp= temp.next;
//         }

//         return temp;
//     }
// }

//By Floyd's cycle detection
public class Solution {
    public ListNode detectCycle(ListNode head) {

        if(head == null) return null;
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) break;//loop detected
        }

        if(fast == null || fast.next == null) return null;// no cycle
       
       //Update one pointer to the head
       fast = head;//ptr->ptr
       while(slow != fast)
       {
            slow = slow.next;
            fast = fast.next;//move 1 step at a time
       }

       return fast;// or return fast
    }
}
