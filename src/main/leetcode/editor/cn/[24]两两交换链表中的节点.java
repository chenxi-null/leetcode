//Given a linked list, swap every two adjacent nodes and return its head. 
//
// You may not modify the values in the list's nodes, only nodes itself may be c
//hanged. 
//
// 
//
// Example: 
//
// 
//Given 1->2->3->4, you should return the list as 2->1->4->3.
// 


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode curr = head;
        ListNode prev = null;
        while (curr != null) {
            // e.g:
            //     prev curr next
            // 2 -> 1 -> 3 -> 4 -> 5
            //
            //     prev next curr
            // 2 -> 1 -> 4 -> 3 -> 5

            if (curr.next == null) {
                break;
            }
            if (curr == head) {
                head = curr.next;
            }

            ListNode next = curr.next;
            if (prev != null) {
                prev.next = next;
            }
            curr.next = next.next;
            next.next = curr;

            prev = curr;
            curr = curr.next;
        }
        return head;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
