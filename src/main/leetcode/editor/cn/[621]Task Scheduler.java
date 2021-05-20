//Given a characters array tasks, representing the tasks a CPU needs to do, wher
//e each letter represents a different task. Tasks could be done in any order. Eac
//h task is done in one unit of time. For each unit of time, the CPU could complet
//e either one task or just be idle.
//
// However, there is a non-negative integer n that represents the cooldown perio
//d between two same tasks (the same letter in the array), that is that there must
// be at least n units of time between any two same tasks.
//
// Return the least number of units of times that the CPU will take to finish al
//l the given tasks.
//
//
// Example 1:
//
//
//Input: tasks = ["A","A","A","B","B","B"], n = 2
//Output: 8
//Explanation:
//A -> B -> idle -> A -> B -> idle -> A -> B
//There is at least 2 units of time between any two same tasks.
//
//
// Example 2:
//
//
//Input: tasks = ["A","A","A","B","B","B"], n = 0
//Output: 6
//Explanation: On this case any permutation of size 6 would work since n = 0.
//["A","A","A","B","B","B"]
//["A","B","A","B","A","B"]
//["B","B","B","A","A","A"]
//...
//And so on.
//
//
// Example 3:
//
//
//Input: tasks = ["A","A","A","A","A","A","B","C","D","E","F","G"], n = 2
//Output: 16
//Explanation:
//One possible solution is
//A -> B -> C -> A -> D -> E -> A -> F -> G -> A -> idle -> idle -> A -> idle ->
// idle -> A
//
//
//
// Constraints:
//
//
// 1 <= task.length <= 104
// tasks[i] is upper-case English letter.
// The integer n is in the range [0, 100].
//
// Related Topics 贪心算法 队列 数组
// 👍 649 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int leastInterval(char[] tasks, int n) {
        int len = tasks.length;
        if (n == 0) return len;

        int[] counts = new int[26];
        int maxCount = 0;
        for (char task : tasks) {
            counts[task - 'A']++;
            maxCount = Math.max(maxCount, counts[task - 'A']);
        }
        int high = maxCount * (n + 1);
        //System.out.println("high: " + high);
        if (len >= high) {
            return len;
        }

        int low = (maxCount - 1) * (n + 1) + 1;
        //System.out.println("low: " + low);
        int numOfMaxCount = 0;
        for (int count : counts) {
            if (count == maxCount) {
                numOfMaxCount++;
            }
        }
        return Math.max(len, low + numOfMaxCount - 1);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
/*
---
答案上界 = max{len, maxCount * (n + 1)}
答案下界 = max{len, (maxCount - 1) * (n + 1) + 1}

m ... m ... m ...
m ... m ... m

e.g
n = 2
a b c a b c a b c

n = 4
a b c x | a b c x | a b
a b c x | a b c x | a b c
a b c x | a b c x | a b c

n = 3
["A","B","C","D","A","B","V"]

["a", "b", "c", "a", "b", "c", "a", "b"]

---

n = 2
a b c a b c a

n = 3
a b c _ a b c _ a

n = 2
a a a x x x x
a x x a x x a


n = 2
a a a b b c

_ (_ | 3a, 2b, 1c)
a (2a | 2b, 1c)
ab (2a, 1b |  1c)
abc ( _| 2a, 1b)
 */
