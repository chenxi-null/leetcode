//Sort a linked list in O(n log n) time using constant space complexity. 
//
// Example 1: 
//
// 
//Input: 4->2->1->3
//Output: 1->2->3->4
// 
//
// Example 2: 
//
// 
//Input: -1->5->3->4->0
//Output: -1->0->3->4->5 


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
    public ListNode sortList(ListNode head) {

    }

    // [h, end)
    void partition(ListNode h, ListNode end) {
        // h s e
        // h,s * e
        if (h == end || h.next == end) {
            return;
        }
        ListNode pivot;
        swap(pivot, h);
        ListNode store = h.next;
        ListNode p = store;
        while (p != null) {
            if (p.val < store.val) {
                swap(p, store);
                store = store.next;
            }
            p = p.next;
        }

        partition(h, store);
        partition(store, end);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
