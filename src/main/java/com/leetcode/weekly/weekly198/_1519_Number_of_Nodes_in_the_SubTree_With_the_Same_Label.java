package com.leetcode.weekly.weekly198;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

class _1519_Number_of_Nodes_in_the_SubTree_With_the_Same_Label {
    public int[] countSubTrees(int n, int[][] edges, String labels) {
        this.labels = labels;
        this.connMap = new HashMap<>();
        this.ans = new int[n];
        for (int[] e : edges) {
            int l = e[0];
            int r = e[1];
            connMap.putIfAbsent(l, new LinkedList<>());
            connMap.get(l).add(r);
        }
        count(0);
        return ans;
    }

    private String labels;
    private Map<Integer, List<Integer>> connMap;
    private int[] ans;

    public Map<Character, Integer> count(int root) {
        Map<Character, Integer> resMap = new HashMap<>();
        char currLabel = labels.charAt(root);
        List<Integer> childsIndexes = connMap.get(root);
        if (childsIndexes != null) {
            for (int i : childsIndexes) {
                Map<Character, Integer> map = count(i);
                map.forEach((ch, cnt) -> {
                    int t = resMap.get(ch) == null ? 0 : resMap.get(ch);
                    resMap.put(ch, t + cnt);
                });
            }
        }
        int t = resMap.get(currLabel) == null ? 0 : resMap.get(currLabel);
        resMap.put(currLabel, t + 1);
        ans[root] = t + 1;
        return resMap;
    }
}