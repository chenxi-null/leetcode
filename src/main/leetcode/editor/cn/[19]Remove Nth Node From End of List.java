//Given the head of a linked list, remove the nth node from the end of the list 
//and return its head. 
//
// Follow up: Could you do this in one pass? 
//
// 
// Example 1: 
//
// 
//Input: head = [1,2,3,4,5], n = 2
//Output: [1,2,3,5]
// 
//
// Example 2: 
//
// 
//Input: head = [1], n = 1
//Output: []
// 
//
// Example 3: 
//
// 
//Input: head = [1,2], n = 1
//Output: [1]
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the list is sz. 
// 1 <= sz <= 30 
// 0 <= Node.val <= 100 
// 1 <= n <= sz 
// 
// Related Topics 链表 双指针 
// 👍 1345 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode prev = null, slow = head, fast = head;
        while (n-- > 0) {
            fast = fast.next;
        }
        while (fast != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next;
        }
        if (slow == head) {
            return slow.next;
        } else {
            prev.next = slow.next;
            return head;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
