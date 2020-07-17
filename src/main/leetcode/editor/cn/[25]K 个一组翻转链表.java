//Given a linked list, reverse the nodes of a linked list k at a time and return
// its modified list. 
//
// k is a positive integer and is less than or equal to the length of the linked
// list. If the number of nodes is not a multiple of k then left-out nodes in the 
//end should remain as it is. 
//
// 
// 
//
// Example: 
//
// Given this linked list: 1->2->3->4->5 
//
// For k = 2, you should return: 2->1->4->3->5 
//
// For k = 3, you should return: 3->2->1->4->5 
//
// Note: 
//
// 
// Only constant extra memory is allowed. 
// You may not alter the values in the list's nodes, only nodes itself may be ch
//anged. 
// 
// Related Topics 链表


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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode lastEnd = null;
        ListNode p = head;
        while (p != null) {
            int cnt = 1;
            ListNode start = p;
            ListNode q = p;
            while (q != null && cnt < k) {
                cnt++;
                q = q.next;
            }
            if (q == null) {
                if (lastEnd == null) {
                    head = p;
                } else {
                    lastEnd.next = p;
                }
                break;
            }
            ListNode end = q;

            p = end.next;

            // reverse current group [start, end]
            // prev    curr -> next
            // prev <- curr  next
            // e.g: a -> b -> c | a <- b <- c
            ListNode prev = null;
            ListNode curr = start;
            ListNode endNext = end.next;
            while (curr != endNext) {
                ListNode t = curr.next;
                curr.next = prev;
                prev = curr;
                curr = t;
            }

            // connect previous and current group
            // lastEnd    start -> ... -> end   -> ...
            // after reverse group:
            // lastEnd    end   -> ... -> start    ...
            // lastEnd -> end   -> ... -> start    ...
            if (lastEnd == null) {
                head = end;
            } else {
                lastEnd.next = end;
            }
            lastEnd = start;
        }
        return head;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
