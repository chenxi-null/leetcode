/*
 * @lc app=leetcode.cn id=93 lang=java
 *
 * [93] 复原IP地址
 */

// @lc code=start
class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> ans = new LinkedList<>();
        backtrack(0, s, new LinkedList<>(), ans);
        return ans;
    }

    void backtrack(int idx, String s, Deque<String> path, List<String> ans) {
        if (path.size() == 4) {
            if (idx == s.length()) {
                ans.add(String.join(".", path));
            }
            return;
        }
        String num = new String();
        for (int i = idx; i < idx + 3 && i < s.length(); i++) {
            num = num + s.charAt(i);
            if (i < idx + 2 || Integer.valueOf(num) <= 255) {
                path.addLast(num);
                backtrack(i + 1, s, path, ans);
                path.removeLast();
            }
            if ("0".equals(num)) {
                break;
            }
        }
    }
}
// @lc code=end


/*
#[WA] leading zero of number
e.g: ["0.1.0.010","0.1.00.10","0.1.001.0","0.10.0.10","0.10.01.0","0.100.1.0","01.0.0.10","01.0.01.0","01.00.1.0","010.0.1.0"]


输入: "25525511135"
输出: ["255.255.11.135", "255.255.111.35"]
 */
