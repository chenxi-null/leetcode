//Given two strings s and t of lengths m and n respectively, return the minimum 
//window in s which will contain all the characters in t. If there is no such wind
//ow in s that covers all characters in t, return the empty string "". 
//
// Note that If there is such a window, it is guaranteed that there will always 
//be only one unique minimum window in s. 
//
// 
// Example 1: 
// Input: s = "ADOBECODEBANC", t = "ABC"
//Output: "BANC"
// Example 2: 
// Input: s = "a", t = "a"
//Output: "a"
// 
// 
// Constraints: 
//
// 
// m == s.length 
// n == t.length 
// 1 <= m, n <= 105 
// s and t consist of English letters. 
// 
//
// 
//Follow up: Could you find an algorithm that runs in O(m + n) time? Related Top
//ics 哈希表 双指针 字符串 Sliding Window 
// 👍 1149 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String minWindow(String s, String t) {
        int minLen = Integer.MAX_VALUE;
        int candLeft = 0, candRight = -1;

        int[] hash = new int[26 * 2];
        int count = 0;
        Map<Character, Integer> letterToNums = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            if (!letterToNums.containsKey(ch)) {
                letterToNums.put(ch, 1);
            } else {
                letterToNums.put(ch, letterToNums.get(ch) + 1);
            }
        }
        int targetCount = letterToNums.size();

        int l = 0, r = 0;
        int n = s.length();
        for (; r < n; r++) {
            // adding element from right side
            int idx = toIdx(s, r);
            hash[idx]++;
            Integer tmpNum = letterToNums.get(s.charAt(r));
            if (tmpNum != null && hash[idx] == tmpNum) {
                count++;
            }

            while (count == targetCount && l <= r) {
                // try to udpate answer
                if (r - l + 1 < minLen) {
                    minLen = r - l + 1;
                    candLeft = l;
                    candRight = r;
                }

                // remove left-most element;
                int idx1 = toIdx(s, l);
                hash[idx1]--;
                Integer tmpNum1 = letterToNums.get(s.charAt(l));
                if (tmpNum1 != null && hash[idx1] < tmpNum1) {
                    count--;
                }
                l++;
            }
        }

        return s.substring(candLeft, candRight + 1);
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

1.
expand right pointer util satisfied;

2.
while(satisfied) {
    try to update answer;

    remove left-most element;
}

===

int[] hash

int count: // t: a,b,c win: a,b,b,e,f, count == 2

satisfied <==> (count == t.length())

===

l1      r
--------
    l2
    ---------
        l3
        ---------

[Left_i, Left_i+1]

====

 */
