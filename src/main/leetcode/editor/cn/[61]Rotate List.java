//Given the head of a linked list, rotate the list to the right by k places. 
//
// 
// Example 1: 
//
// 
//Input: head = [1,2,3,4,5], k = 2
//Output: [4,5,1,2,3]
// 
//
// Example 2: 
//
// 
//Input: head = [0,1,2], k = 4
//Output: [2,0,1]
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the list is in the range [0, 500]. 
// -100 <= Node.val <= 100 
// 0 <= k <= 2 * 109 
// 
// Related Topics 链表 双指针 
// 👍 558 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
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
    public ListNode rotateRight(ListNode head, int k) {
        // get n
        int n = 0;
        ListNode p = head;
        while (p != null) {
            ++n;
            p = p.next;
        }
        if (n == 0) return head;

        k = k % n;
        if (k == 0) return head;

        int t = n - k; // t: [1, n-1]
        p = head;
        for (int i = 0; i < t - 1; i++) {
            p = p.next;
        }

        ListNode newHead = p.next;
        ListNode q = newHead;
        p.next = null;
        while (q.next != null) {
            q = q.next;
        }
        q.next = head;
        return newHead;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
