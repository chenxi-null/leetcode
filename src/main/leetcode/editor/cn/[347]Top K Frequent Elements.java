//Given an integer array nums and an integer k, return the k most frequent eleme
//nts. You may return the answer in any order.
//
//
// Example 1:
// Input: nums = [1,1,1,2,2,3], k = 2
//Output: [1,2]
// Example 2:
// Input: nums = [1], k = 1
//Output: [1]
//
//
// Constraints:
//
//
// 1 <= nums.length <= 105
// k is in the range [1, the number of unique elements in the array].
// It is guaranteed that the answer is unique.
//
//
//
// Follow up: Your algorithm's time complexity must be better than O(n log n), w
//here n is the array's size.
// Related Topics 堆 哈希表
// 👍 755 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int n = nums.length;
        Map<Integer, Integer> numToCnt = new HashMap<>();
        for (int num : nums) {
            numToCnt.put(num, numToCnt.getOrDefault(num, 0) + 1);
        }
        List<int[]> list = new ArrayList<>();
        for (Map.Entry<Integer, Integer> e : numToCnt.entrySet()) {
            list.add(new int[]{e.getKey(), e.getValue()});
        }

        int[] ret = new int[k];
        qsort(0, list.size() - 1, k, list, ret, 0);
        return ret;
    }

    private void qsort(int start, int end, int k, List<int[]> list, int[] ret, int retIdx) {
        if (k == 0) return;
        int picked = new Random().nextInt(end - start + 1) + start;
        Collections.swap(list, picked, start);
        int pivot = list.get(start)[1];
        int index = start;
        for (int i = start + 1; i <= end; i++) {
            if (list.get(i)[1] >= pivot) {
                Collections.swap(list, i, ++index);
            }
        }
        Collections.swap(list, start, index);

        int len = index - start + 1;
        if (len > k) {
            qsort(start, index, k, list, ret, retIdx);
        } else {
            for (int i = start; i <= index; i++) {
                ret[retIdx++] = list.get(i)[0];
            }
            qsort(index + 1, end, k - len, list, ret, retIdx);
        }
    }
}//leetcode submit region end(Prohibit modification and deletion)

class Solution {
    // use heap
    public int[] 20210526_

    topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> numToCnt = new HashMap<>();
        for (int num : nums) {
            numToCnt.put(num, numToCnt.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<int[]> q = new PriorityQueue<>(Comparator.comparingInt(x -> x[1]));
        for (Map.Entry<Integer, Integer> e : numToCnt.entrySet()) {
            int num = e.getKey();
            int cnt = e.getValue();
            if (q.size() < k) {
                q.offer(new int[]{num, cnt});
            } else if (cnt > q.peek()[1]) {
                q.poll();
                q.offer(new int[]{num, cnt});
            }
        }
        int[] ans = new int[k];
        int i = 0;
        for (int[] nc : q) {
            ans[i++] = nc[0];
        }
        return ans;
    }
}


/*
map: numToOccurenceCnt

e.g
k: 3
num occurence o-k
a   15
b   13
c   12
d   14
e   11
f   10
 */
