/*
 * @lc app=leetcode.cn id=17 lang=java
 *
 * [17] 电话号码的字母组合
 */

// @lc code=start
class Solution {
    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.isEmpty()) {
            return Collections.emptyList();
        }

        Map<Character, String> numToLetters = new HashMap<>();
        numToLetters.put('2', "abc");
        numToLetters.put('3', "def");
        numToLetters.put('4', "ghi");
        numToLetters.put('5', "jkl");
        numToLetters.put('6', "mno");
        numToLetters.put('7', "pqrs");
        numToLetters.put('8', "tuv");
        numToLetters.put('9', "wxyz");

        List<String> ans = new LinkedList<>();
        bt(0, digits, numToLetters, new LinkedList<>(), ans);
        return ans;
    }

    private void bt(int idx, String digits, Map<Character, String> numToLetters,
                    LinkedList<Character> output, List<String> ans) {

        if (idx == digits.length()) {
            StringBuilder sb = new StringBuilder();
            for (char c : output) {
                sb.append(c);
            }
            ans.add(sb.toString());
            return;
        }

        Character num = digits.charAt(idx);
        String letters = numToLetters.get(num);
        for (int i = 0; i < letters.length(); i++) {
            output.add(letters.charAt(i));
            bt(idx + 1, digits, numToLetters, output, ans);
            output.removeLast();
        }
    }
}
// @lc code=end

/*
#[WA] recursion miss `return` & find wrong line while debuging & corner case - string is empty
*/

