//Given strings s1, s2, and s3, find whether s3 is formed by an interleaving of 
//s1 and s2. 
//
// An interleaving of two strings s and t is a configuration where they are divi
//ded into non-empty substrings such that: 
//
// 
// s = s1 + s2 + ... + sn 
// t = t1 + t2 + ... + tm 
// |n - m| <= 1 
// The interleaving is s1 + t1 + s2 + t2 + s3 + t3 + ... or t1 + s1 + t2 + s2 + 
//t3 + s3 + ... 
// 
//
// Note: a + b is the concatenation of strings a and b. 
//
// 
// Example 1: 
//
// 
//Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
//Output: true
// 
//
// Example 2: 
//
// 
//Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc"
//Output: false
// 
//
// Example 3: 
//
// 
//Input: s1 = "", s2 = "", s3 = ""
//Output: true
// 
//
// 
// Constraints: 
//
// 
// 0 <= s1.length, s2.length <= 100 
// 0 <= s3.length <= 200 
// s1, s2, and s3 consist of lowercase English letters. 
// 
//
// 
// Follow up: Could you solve it using only O(s2.length) additional memory space
//? 
// Related Topics 字符串 动态规划 
// 👍 440 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {


    public boolean isInterleave_20210508_2322(String s1, String s2, String s3) {
        int sz1 = s1.length();
        int sz2 = s2.length();
        int sz3 = s3.length();

        if (sz1 + sz2 != sz3) return false;
        if (sz1 == 0) return Objects.equals(s2, s3);
        if (sz2 == 0) return Objects.equals(s1, s3);

        boolean[][][] dp = new boolean[sz3 + 1][][];
        for (int k = 0; k < sz3 + 1; k++) {
            dp[k] = new boolean[sz1 + 1][];
            for (int i = 0; i < sz1 + 1; i++) {
                dp[k][i] = new boolean[sz2 + 1];
            }
        }

        dp[0][0][0] = true;
        for (int k = 1; k < sz3 + 1; k++) {
            for (int i = 0; i < sz1 + 1; i++) {
                for (int j = 0; j < sz2 + 1; j++) {
                    if (i + j == k) {
                        dp[k][i][j] = dp[k][i][j] ||
                                (i > 0 && s1.charAt(i - 1) == s3.charAt(k - 1) && (i == 0 || dp[k - 1][i - 1][j])) ||
                                (j > 0 && s2.charAt(j - 1) == s3.charAt(k - 1) && (j == 0 || dp[k - 1][i][j - 1]));
                    }
                }
            }
        }
        for (int i = 0; i < sz1 + 1; i++) {
            for (int j = 0; j < sz2 + 1; j++) {
                if (dp[sz3][i][j]) {
                    return true;
                }
            }
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

//#[Better]: 简化为2 维度 DP & 滚动数组优化

// #[WA] 1. 数组下标, [0, n], arr.size == n + 1; 2. 变量弄错 s vs sz

/*
"aabcc"
"dbbca"
"aadbbcbcac"

s1: a a
s2: - -
s3: a a
    1 1

f(i, j, k) =
    f(i-1,j,k-1), (s1[i] == s3[k])
    or
    f(i,j-1,k-1) (s2[j] == s3[k])

f(0,0,0) = true

O(N^3)

---

cases:
"aabcc"
"dbbca"
"aadbbbaccc"
 */
