package com.leetcode.misc;
/*
Given an array of strings, group anagrams together.

Example:

Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
Output:
[
  ["ate","eat","tea"],
  ["nat","tan"],
  ["bat"]
]
Note:

All inputs will be in lowercase.
The order of your output does not matter.
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/*
time complexity: O(n * log(m))

O(n)

represent key:
0...25
a,b,c,d...z
 */
class AnagramsGroup {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            map.compute(buildKey(str), (k, list) -> {
                if (list == null) {
                    list = new LinkedList<>();
                }
                list.add(str);
                return list;
            });
        }
        return new ArrayList<>(map.values());
    }

    private String buildKey(String str) {
        int[] a = new int[26];
        for (int i = 0; i < str.length(); i++) {
            a[str.charAt(i) - 'a']++;
        }
        StringBuilder builder = new StringBuilder();
        for (int cnt : a) {
            builder.append(cnt).append(',');
        }
        return builder.toString();
    }
}