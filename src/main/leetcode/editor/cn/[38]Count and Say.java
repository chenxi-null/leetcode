//The count-and-say sequence is the sequence of integers with the first five terms as following:
//
// 
//1.     1
//2.     11
//3.     21
//4.     1211
//5.     111221
// 
//
// 1 is read off as "one 1" or 11. 
//11 is read off as "two 1s" or 21. 
//21 is read off as "one 2, then one 1" or 1211. 
//
// Given an integer n where 1 ≤ n ≤ 30, generate the nth term of the count-and-s
//ay sequence. You can do so recursively, in other words from the previous member 
//read off the digits, counting the number of digits in groups of the same digit. 
//
//
// Note: Each term of the sequence of integers will be represented as a string. 
//
//
// 
//
// Example 1: 
//
// 
//Input: 1
//Output: "1"
//Explanation: This is the base case.
// 
//
// Example 2: 
//
// 
//Input: 4
//Output: "1211"
//Explanation: For n = 3 the term was "21" in which we have two groups "2" and "
//1", "2" can be read as "12" which means frequency = 1 and value = 2, the same wa
//y "1" is read as "11", so the answer is the concatenation of "12" and "11" which
// is "1211".
// 
// Related Topics 字符串 


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String countAndSay(int n) {
        // e.g: aaabbbccc
        StringBuilder r = new StringBuilder("1");
        int cnt = 0;
        char num = 0;
        for (int i = 2; i <= n; i++) {
            StringBuilder nr = new StringBuilder();
            for (int j = 0; j < r.length(); j++) {
                if (j == 0) {
                    num = r.charAt(j);
                    cnt = 1;
                } else if (r.charAt(j) != r.charAt(j - 1)) {
                    nr.append(String.valueOf(cnt)).append(num);
                    num = r.charAt(j);
                    cnt = 1;
                } else {
                    cnt++;
                }
            }
            nr.append(String.valueOf(cnt)).append(num);
            r = nr;
        }
        return r.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
