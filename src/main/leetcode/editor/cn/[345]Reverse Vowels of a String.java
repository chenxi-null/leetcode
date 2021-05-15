//Given a string s, reverse only all the vowels in the string and return it. 
//
// The vowels are 'a', 'e', 'i', 'o', and 'u', and they can appear in both cases
//. 
//
// 
// Example 1: 
// Input: s = "hello"
//Output: "holle"
// Example 2: 
// Input: s = "leetcode"
//Output: "leotcede"
// 
// 
// Constraints: 
//
// 
// 1 <= s.length <= 3 * 105 
// s consist of printable ASCII characters. 
// 
// Related Topics 双指针 字符串 
// 👍 150 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String reverseVowels(String s) {
        int n = s.length();
        char[] ans  = s.toCharArray();
        int l = 0, r = n - 1;
        while (l < r) {
            if (!isVowel(ans, l)) l++;
            if (!isVowel(ans, r)) r--;
            if (l < r && isVowel(ans, l) && isVowel(ans, r)) {
                char t = ans[l];
                ans[l] = ans[r];
                ans[r] = t;
                l++;
                r--;
            }
        }
        return new String(ans);
    }

    char[] vowels = new char[] {'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'};

    boolean isVowel(char[] a, int i) {
        for (char v : vowels) {
            if (a[i] == v) return true;
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

/*
x x x o o x x o x o x
 */
