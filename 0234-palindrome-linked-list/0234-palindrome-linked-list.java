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
//  //by reversing the ll into an extra ll and traverse ssimultaneously
// class Solution {
//     public boolean isPalindrome(ListNode head) {
        
//         if(head == null || head.next == null){//if LL has only 1 element
//             return true;
//         }

//         ListNode rev = null;
//         ListNode t1 = head ;
//         // ListNode t2 = t1.next ;
       
//        while(t1!=null){
//         ListNode x = new ListNode(t1.val);
//         x.next = rev;
//         rev = x;
//         t1 = t1.next;
//        }
//        //traverse
//        t1 = head;
//        ListNode t2 = rev;
//        while(t1 != null){
//         if(t1.val != t2.val){
//             return false;
//         }
//         t1 = t1.next;
//         t2 = t2.next;
//        }
//      return true;
//     }
// }


//By taking an extra array(space)
// class Solution {
//     public boolean isPalindrome(ListNode head) {

//         if((head == null)||(head.next == null)){
//             return true;
//         }

//        List<Integer> l = new ArrayList<>();
//        ListNode ptr = head ; //ptr to traverse the ll

//        while(ptr != null){
//         l.add(ptr.val);
//         ptr =ptr.next;
//        }

//        //chack if the arrlist is palindrome
//        int left= 0;
//        int right = l.size()-1;

//        while(left<=right)
//        {
//            if(l.get(left) != l.get(right)){
//             return false;
//            }      
//            left++;
//            right--;
//        }
//        return true;
//     }
// }

//By o(1) space
//slow , fast ptr

class Solution {
    public boolean isPalindrome(ListNode head) {
        // Handle empty list or single node
        if (head == null || head.next == null) {
            return true;
        }
        
        // Find the middle of the linked list
        ListNode slow = head;
        ListNode fast = head;
        
        // Find middle (slow will be at middle)
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        // Reverse the second half of the list
        ListNode secondHalf = reverseList(slow);//return the head(prev of the reversed part)
        // slow.next = null; 
        
        // Compare first half with reversed second half
        ListNode firstHalf = head;
        ListNode reversedHalf = secondHalf;
        
        while (reversedHalf != null) {
            if (firstHalf.val != reversedHalf.val) {
                return false;
            }
            firstHalf = firstHalf.next;
            reversedHalf = reversedHalf.next;
        }
        
        return true;
    }
    
    // Helper method to reverse a linked list
    private ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        
        while (current != null) {
            ListNode nextTemp = current.next;
            current.next = prev;
            prev = current;
            current = nextTemp;
        }
        
        return prev;
    }
}