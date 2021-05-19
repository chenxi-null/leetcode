//Given two strings s and p, return an array of all the start indices of p's ana
//grams in s. You may return the answer in any order.
//
//
// Example 1:
//
//
//Input: s = "cbaebabacd", p = "abc"
//Output: [0,6]
//Explanation:
//The substring with start index = 0 is "cba", which is an anagram of "abc".
//The substring with start index = 6 is "bac", which is an anagram of "abc".
//
//
// Example 2:
//
//
//Input: s = "abab", p = "ab"
//Output: [0,1,2]
//Explanation:
//The substring with start index = 0 is "ab", which is an anagram of "ab".
//The substring with start index = 1 is "ba", which is an anagram of "ab".
//The substring with start index = 2 is "ab", which is an anagram of "ab".
//
//
//
// Constraints:
//
//
// 1 <= s.length, p.length <= 3 * 104
// s and p consist of lowercase English letters.
//
// Related Topics 哈希表
// 👍 527 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        int n = s.length();
        int m = p.length();
        int target[] = new int[26];
        for (int i = 0; i < m; i++) {
            target[p.charAt(i) - 'a']++;
        }
        int[] hash = new int[26]; // state in current window
        // [0, m-1)
        for (int i = 0; i < m - 1; i++) {
            hash[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i + m - 1 < n; i++) {
            // remove left-most element
            if (i != 0) {
                System.out.println("remove: " + s.charAt(i - 1));
                hash[s.charAt(i - 1) - 'a']--;
            }
            // add right-most element
            System.out.println("add: " + s.charAt(i + m - 1));
            hash[s.charAt(i + m - 1) - 'a']++;
            // check and try to update answer
            if (check(hash, target)) {
                ans.add(i);
            }
            System.out.println(i);
            System.out.println(Arrays.toString(hash));
            System.out.println("---");
        }
        return ans;
    }
    private boolean check(int[] a, int[] b) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] != b[i]) return false;
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

// #[WA]: sliding-window need to add left-most element of **last window** not current window!
