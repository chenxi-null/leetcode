//Implement strStr(). 
//
// Return the index of the first occurrence of needle in haystack, or -1 if need
//le is not part of haystack. 
//
// Example 1: 
//
// 
//Input: haystack = "hello", needle = "ll"
//Output: 2
// 
//
// Example 2: 
//
// 
//Input: haystack = "aaaaa", needle = "bba"
//Output: -1
// 
//
// Clarification: 
//
// What should we return when needle is an empty string? This is a great questio
//n to ask during an interview. 
//
// For the purpose of this problem, we will return 0 when needle is an empty str
//ing. This is consistent to C's strstr() and Java's indexOf(). 
// Related Topics 双指针 字符串


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int strStr(String haystack, String needle) {
        if (haystack == null || needle == null) {
            return -1;
        }
        if (needle.isEmpty()) {
            return 0;
        }
        if (needle.length() > haystack.length()) {
            return -1;
        }
        for (int i = 0; i < haystack.length() - needle.length() + 1; i++) {
            boolean found = true;
            for (int j = 0; j < needle.length(); j++) {
                if (!Objects.equals(haystack.charAt(i + j), needle.charAt(j))) {
                    found = false;
                    break;
                }
            }
            if (found) {
                return i;
            }
        }
        return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
