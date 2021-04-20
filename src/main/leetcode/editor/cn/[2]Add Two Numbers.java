//You are given two non-empty linked lists representing two non-negative integer
//s. The digits are stored in reverse order, and each of their nodes contains a si
//ngle digit. Add the two numbers and return the sum as a linked list. 
//
// You may assume the two numbers do not contain any leading zero, except the nu
//mber 0 itself. 
//
// 
// Example 1: 
//
// 
//Input: l1 = [2,4,3], l2 = [5,6,4]
//Output: [7,0,8]
//Explanation: 342 + 465 = 807.
// 
//
// Example 2: 
//
// 
//Input: l1 = [0], l2 = [0]
//Output: [0]
// 
//
// Example 3: 
//
// 
//Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
//Output: [8,9,9,9,0,0,0,1]
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in each linked list is in the range [1, 100]. 
// 0 <= Node.val <= 9 
// It is guaranteed that the list represents a number that does not have leading
// zeros. 
// 
// Related Topics 递归 链表 数学 
// 👍 6072 👎 0


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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode p1 = l1;
        ListNode p2 = l2;
        ListNode p = null, h = null;
        int f = 0;
        while (true) {
            if (p1 == null && p2 == null && f == 0) {
                return h;
            }
            int n1 = (p1 == null) ? 0 : p1.val;
            int n2 = (p2 == null) ? 0 : p2.val;
            int s = n1 + n2 + f;
            f = (s >= 10) ? 1 : 0;
            int n3 = s % 10;
            if (h == null) {
                h = new ListNode(n3);
                p = h;
            } else {
                p.next = new ListNode(n3);
                p = p.next;
            }
            p1 = (p1 != null) ? p1.next : null;
            p2 = (p2 != null) ? p2.next : null;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

// 加法进位：(s >= 10) ? 1 : 0
// 当前位：s % 10

// #[WA] 1. linked list operation; 2. math plus rule; 3. corner case: e.g. 9 + 9 = 11