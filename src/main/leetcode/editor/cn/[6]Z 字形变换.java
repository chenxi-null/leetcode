//The string "PAYPALISHIRING" is written in a zigzag pattern on a given number o
//f rows like this: (you may want to display this pattern in a fixed font for bett
//er legibility) 
//
// 
//P   A   H   N
//A P L S I I G
//Y   I   R
// 
//
// And then read line by line: "PAHNAPLSIIGYIR" 
//
// Write the code that will take a string and make this conversion given a numbe
//r of rows: 
//
// 
//string convert(string s, int numRows); 
//
// Example 1: 
//
// 
//Input: s = "PAYPALISHIRING", numRows = 3
//Output: "PAHNAPLSIIGYIR"
// 
//
// Example 2: 
//
// 
//Input: s = "PAYPALISHIRING", numRows = 4
//Output: "PINALSIGYAHRPI"
//Explanation:
//
//P     I    N
//A   L S  I G
//Y A   H R
//P     I 


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String convert(String s, int nr) {
        int n = s.length();
        List<Deque<Character>> lst = new ArrayList<>(nr);
        for (int i = 0; i < nr; i++) {
            lst.add(new LinkedList<>());
        }
        for (int i = 0; i < n; ) {
            for (int j = 0; j < nr && i < n; j++) {
                lst.get(j).addLast(s.charAt(i++));
            }
            for (int j = nr - 2; j >= 1 && i < n; j--) {
                lst.get(j).addLast(s.charAt(i++));
            }
        }
        StringBuilder sb = new StringBuilder();
        for (Deque<Character> d : lst) {
            for (char ch : d) {
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
