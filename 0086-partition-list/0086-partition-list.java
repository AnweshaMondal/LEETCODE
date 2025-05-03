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

//Brute Force Idea:
//Traverse the list and store nodes with values less than x in one list.
// Store nodes with values greater than or equal to x in another list.
// Join the two lists together to create the final reordered list.


// class Solution {
//     public ListNode partition(ListNode head, int x) {

//         ListNode lessHead = new ListNode(-1);
//         ListNode greaterHead = new ListNode(-1);

//         ListNode temp = head;
//         ListNode ptr1 =  lessHead;
//         ListNode ptr2 =  greaterHead;

//    //Cretae 2 sorted list
//         while(temp != null)
//         {
//             if(temp.val < x)
//             {
//               ListNode newnode = new ListNode(temp.val);//create new node
//               ptr1.next = newnode;
//               ptr1 = ptr1.next;
//               temp = temp.next;
//             }

//             else
//             {
//               ListNode newnode = new ListNode(temp.val);//create new node
//               ptr2.next = newnode;
//               ptr2 = ptr2.next;
//               temp = temp.next;
//             }
//         }
         
//      greaterHead = greaterHead.next;//shift its head

//     //merge 2 lists
//     ptr1.next = greaterHead;
//     return lessHead.next;

         
//     }
// }

//Without Using Extra Space
class Solution {
    public ListNode partition(ListNode head, int x) {


       ListNode lessHead = new ListNode(-1);
       ListNode greaterHead = new ListNode(-1);

       ListNode ptr1 =  lessHead;//ptr to traverse
       ListNode ptr2 =  greaterHead;
       ListNode temp = head; 

       while(temp != null)
        {
            if(temp.val < x)
            {
              ptr1.next = temp;
              ptr1 = ptr1.next;
              temp = temp.next;
            }

            else
            {
              ptr2.next = temp;
              ptr2 = ptr2.next;
              temp = temp.next;
            }
        }
    greaterHead = greaterHead.next;
    ptr2.next = null;
    ptr1.next = greaterHead;

    return lessHead.next;//Skip the dummy node

    }
}