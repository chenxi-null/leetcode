//Given a string s, return the length of the longest substring that contains at 
//most two distinct characters. 
//
// 
// Example 1: 
//
// 
//Input: s = "eceba"
//Output: 3
//Explanation: The substring is "ece" which its length is 3.
// 
//
// Example 2: 
//
// 
//Input: s = "ccaabbb"
//Output: 5
//Explanation: The substring is "aabbb" which its length is 5.
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 104 
// s consists of English letters. 
// 
// Related Topics 哈希表 双指针 字符串 Sliding Window 
// 👍 116 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int ans = 0;
        int[] hash = new int[26 * 2];
        int count = 0; // distinct count in the current sliding window

        int l = 0, r = -1;
        int n = s.length();
        for (; l < n; l++) {
            // update state when removing element from left side
            if (l != 0) {
                int idx = toIdx(s, l - 1);
                hash[idx]--;
                if (hash[idx] == 0) {
                    count--;
                }
            }

            while (count <= 2 && ++r < n) {
                // update state when adding element from right side
                int idx = toIdx(s, r);
                hash[idx]++;
                if (hash[idx] == 1) {
                    count++;
                }
                // if statisfied
                if (count <= 2) {
                    ans = Math.max(ans, r - l + 1);
                }
            }
        }
        return ans;
    }

    private int toIdx(String s, int i) {
        char ch = s.charAt(i);
        if (ch >= 'a') {
            return ch - 'a' + 26;
        } else {
            return ch - 'A';
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

/*

aabaaccc
-----
 ----
  ---
   -----

===

--------
 ----------
    ----
     -----

 */
