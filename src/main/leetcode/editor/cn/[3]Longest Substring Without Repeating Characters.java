//Given a string s, find the length of the longest substring without repeating c
//haracters. 
//
// 
// Example 1: 
//
// 
//Input: s = "abcabcbb"
//Output: 3
//Explanation: The answer is "abc", with the length of 3.
// 
//
// Example 2: 
//
// 
//Input: s = "bbbbb"
//Output: 1
//Explanation: The answer is "b", with the length of 1.
// 
//
// Example 3: 
//
// 
//Input: s = "pwwkew"
//Output: 3
//Explanation: The answer is "wke", with the length of 3.
//Notice that the answer must be a substring, "pwke" is a subsequence and not a 
//substring.
// 
//
// Example 4: 
//
// 
//Input: s = ""
//Output: 0
// 
//
// 
// Constraints: 
//
// 
// 0 <= s.length <= 5 * 104 
// s consists of English letters, digits, symbols and spaces. 
// 
// Related Topics 哈希表 双指针 字符串 Sliding Window 
// 👍 5349 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int[] hash = new int[1024];
        int[] dp = new int[n];
        int max = 1;
        int l = 0;
        int r = 1;
        for (; r < n; r++) {
            int c = s.charAt(r);

            dp[r] = dp[r - 1] + 1;
            while (hash[c] >= 1) {
                //remove from window & update state
                hash[l++]--;
                dp[r]--;
            }
            //add into window & update state;
            hash[c]++;

            max = Math.max(dp[r], max);
        }
        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

/*

a, b, c, d, d

0, 1, 2, 3
l,    r
.  .

----

int l = 0;
int r = 0; // inclusive
for (; r < n; r++) {
    // add into window
    update state

    while (l < r && statisfied) {
        update the answer

        // remove from window
        update state
        l++;
    }
}
 */
