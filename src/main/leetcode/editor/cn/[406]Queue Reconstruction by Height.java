//You are given an array of people, people, which are the attributes of some peo
//ple in a queue (not necessarily in order). Each people[i] = [hi, ki] represents
//the ith person of height hi with exactly ki other people in front who have a hei
//ght greater than or equal to hi.
//
// Reconstruct and return the queue that is represented by the input array peopl
//e. The returned queue should be formatted as an array queue, where queue[j] = [h
//j, kj] is the attributes of the jth person in the queue (queue[0] is the person
//at the front of the queue).
//
//
// Example 1:
//
//
//Input: people = [[7,0],[4,4],[7,1],[5,0],[6,1],[5,2]]
//Output: [[5,0],[7,0],[5,2],[6,1],[4,4],[7,1]]
//Explanation:
//Person 0 has height 5 with no other people taller or the same height in front.
//
//Person 1 has height 7 with no other people taller or the same height in front.
//
//Person 2 has height 5 with two persons taller or the same height in front, whi
//ch is person 0 and 1.
//Person 3 has height 6 with one person taller or the same height in front, whic
//h is person 1.
//Person 4 has height 4 with four people taller or the same height in front, whi
//ch are people 0, 1, 2, and 3.
//Person 5 has height 7 with one person taller or the same height in front, whic
//h is person 1.
//Hence [[5,0],[7,0],[5,2],[6,1],[4,4],[7,1]] is the reconstructed queue.
//
//
// Example 2:
//
//
//Input: people = [[6,0],[5,0],[4,0],[3,2],[2,2],[1,4]]
//Output: [[4,0],[5,0],[2,2],[3,2],[1,4],[6,0]]
//
//
//
// Constraints:
//
//
// 1 <= people.length <= 2000
// 0 <= hi <= 106
// 0 <= ki < people.length
// It is guaranteed that the queue can be reconstructed.
//
// Related Topics 贪心算法
// 👍 881 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] reconstructQueue(int[][] a) {
        Arrays.sort(a, (x, y) -> {
            if (x[1] != y[1]) {
                return x[1] - y[1];
            } else {
                return x[0] - y[0];
            }
        });
        List<int[]> list = new LinkedList<>();
        for (int[] p : a) {
            int k = p[1];
            int cnt = 0;
            int i;
            for (i = 0; i < list.size(); i++) {
                if (list.get(i)[1] == k) {
                    continue;
                }
                if (cnt == k) {
                    break;
                }
                if (list.get(i)[0] >= p[0]) {
                    cnt++;
                }
            }
            list.add(i, p);
        }
        return list.toArray(new int[][]{});
    }
}
//leetcode submit region end(Prohibit modification and deletion)
/*
[h, k]
the idx of this people in queue >= k

1. sort array

comparator:
if the value of 'k' is same, order by 'h' insc
firstly, order by 'k', then, order by 'h'

2. insert into queue

[5,0] [7,0] | [6,1] [7,1] | [5,2] | [4,4]

[5,0] [7,0]     [6,1]        [7,1]
           [5,2]      [4, 4]

the people after the insertion postion, their k will not be changed

 */
