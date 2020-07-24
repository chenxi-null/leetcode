package com.leetcode.weekly.weekly198;

import com.leetcode.linkedList.LinkedListCycle;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/*
Given a tree (i.e. a connected, undirected graph that has no cycles) consisting of n nodes numbered from 0 to n - 1 and exactly n - 1 edges.
The root of the tree is the node 0, and each node of the tree has a label
 which is a lower-case character given in the string labels (i.e. The node with the number i has the label labels[i]).

The edges array is given on the form edges[i] = [ai, bi], which means there is an edge between nodes ai and bi in the tree.

Return an array of size n where ans[i] is the number of nodes in the subtree of the ith node which have the same label as node i.

A subtree of a tree T is the tree consisting of a node in T and all of its descendant nodes.


Constraints:

1 <= n <= 10^5
edges.length == n - 1
edges[i].length == 2
0 <= ai, bi < n
ai != bi
labels.length == n
labels is consisting of only of lower-case English letters.

https://leetcode-cn.com/problems/number-of-nodes-in-the-sub-tree-with-the-same-label/

---

#dfs

 */
class _1519_NumberOfNodesInTheSubTreeWithTheSameLabel {

    public int[] countSubTrees(int n, int[][] edges, String labels) {
        this.labels = labels;
        this.edgeMap = new HashMap<>();
        this.ans = new int[n];
        this.visited = new boolean[n];
        for (int[] e : edges) {
            int l = e[0];
            int r = e[1];
            edgeMap.computeIfAbsent(l, k -> new LinkedList<>());
            edgeMap.get(l).add(r);
            edgeMap.computeIfAbsent(r, k -> new LinkedList<>());
            edgeMap.get(r).add(l);
        }
        dfs(0);
        return ans;
    }

    private String labels;
    private Map<Integer, List<Integer>> edgeMap;
    private int[] ans;
    private boolean[] visited;

    public int[] dfs(int root) {
        visited[root] = true;
        int[] currHash = new int[26];
        int currLableIdx = labels.charAt(root) - 'a';
        currHash[currLableIdx] = 1;

        List<Integer> nextNodes = edgeMap.get(root);
        if (nextNodes != null) {
            for (int node : nextNodes) {
                if (!visited[node]) {
                    int[] childHash = dfs(node);
                    for (int i = 0; i < childHash.length; i++) {
                        currHash[i] += childHash[i];
                    }
                }
            }
        }
        ans[root] = currHash[currLableIdx];
        return currHash;
    }
}