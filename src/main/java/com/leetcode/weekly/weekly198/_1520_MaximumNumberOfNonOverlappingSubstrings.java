package com.leetcode.weekly.weekly198;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/*
1520. Maximum Number of Non-Overlapping Substrings
Given a string s of lowercase letters, you need to find the maximum number of non-empty substrings of s that meet the following conditions:

The substrings do not overlap, that is for any two substrings s[i..j] and s[k..l], either j < k or i > l is true.
A substring that contains a certain character c must also contain all occurrences of c.
Find the maximum number of substrings that meet the above conditions. If there are multiple solutions with the same number of substrings, return the one with minimum total length. It can be shown that there exists a unique solution of minimum total length.

Notice that you can return the substrings in any order.

Constraints:

1 <= s.length <= 10^5
s contains only lowercase English letters.

https://leetcode-cn.com/problems/maximum-number-of-non-overlapping-substrings/

---

借鉴了[官方的题解](https://leetcode-cn.com/problems/maximum-number-of-non-overlapping-substrings/solution/zui-duo-de-bu-zhong-die-zi-zi-fu-chuan-by-leetcodae/)

先预处理，得到 "包含某个字符的符合条件的最短子串"
例如，对于 'abcbacdd'，预处理得到：
a -> 'abcbac'
b -> 'abcbac'
c -> 'abcbac'
d -> 'dd'

显然这些子串只会包含或者分离，不会相交
然后，将这些子串按照起点下标排序，使用贪心的思路，出现包含关系时，只选择加入最短的子串，互相分离时，直接加入。


不过官方题解 预处理-拓展区间 那部分的代码应该是有问题，最快情况下的复杂度是 O(s * n ^ 2)，不是它说的 O(s * n)
这部分代码参考了评论区里的一个解法 @凶猛的嘟嘟
 */

/**
 * @author chenxi <chenxi01@souche.com>
 * @date 2020/7/24
 */
public class _1520_MaximumNumberOfNonOverlappingSubstrings {

    public List<String> maxNumOfSubstrings(String s) {

        // 每个字符的 startIndex 和 endIndex
        int[][] charIntervals = new int[26][2];
        for (int i = 0; i < 26; i++) {
            charIntervals[i][0] = -1;
        }
        for (int i = 0; i < s.length(); i++) {
            int c = s.charAt(i) - 'a';
            if (charIntervals[c][0] == -1) {
                charIntervals[c][0] = i;
            }
            charIntervals[c][1] = i;
        }

        // 预处理，得到多个区间，每个区间表示包含某个字符的满足条件的最短子串
        List<int[]> complexIntervals = new ArrayList<>();
        for (int[] interval : charIntervals) {
            int start = interval[0], end = interval[1];
            if (start == -1) {
                continue;
            }
            boolean keep = true;
            for (int i = start; i <= end; i++) {
                int[] t = charIntervals[s.charAt(i) - 'a'];
                // 遇到左端点更新就终止，保证处理每个字符都是 O(N) 的时间复杂度，且不会生成重复的区间
                if (t[0] < start) {
                    keep = false;
                    break;
                }
                end = Math.max(end, t[1]);
            }
            if (keep) {
                complexIntervals.add(new int[]{start, end});
            }
        }

        complexIntervals.sort(Comparator.comparingInt(a -> a[0]));
        LinkedList<int[]> res = new LinkedList<>();
        for (int[] a : complexIntervals) {
            if (!res.isEmpty() && a[0] < res.getLast()[1]) {
                res.removeLast();
            }
            res.add(a);
        }
        return res.stream().map(a -> s.substring(a[0], a[1] + 1))
                .collect(Collectors.toList());
    }
}
