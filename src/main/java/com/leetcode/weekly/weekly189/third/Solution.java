package com.leetcode.weekly.weekly189.third;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/*
输入：favoriteCompanies = [["leetcode","google","facebook"],["google","microsoft"],["google","facebook"],["google"],["amazon"]]
输出：[0,1,4]

[words1, words2, words3, ...]

is subset ?

words1.isSubsetOf(words2)

N 100
M 500
K 20

N * N * M * K

arr:
    index is alpha char
    value is count

---
map:
N * N * K
     */
class Solution {
    public List<Integer> peopleIndexes(List<List<String>> favoriteCompanies) {
        if (null == favoriteCompanies || favoriteCompanies.size() <= 1) {
            return Collections.emptyList();
        }

        Set<Integer> ans = new HashSet<>();
        for (int i = 0; i < favoriteCompanies.size(); i++) {
            ans.add(i);
        }

        List<Set<String>> wordsList = favoriteCompanies.stream()
                        .map(HashSet::new).collect(Collectors.toList());

        for (int i = 0; i < favoriteCompanies.size(); i++) {
            List<String> currWords = favoriteCompanies.get(i);

            for (int j = 0; j < wordsList.size(); j++) {
                if (i == j) {
                    continue;
                }
                Set<String> otherWords = wordsList.get(j);

                // currWords is subset of otherWords
                if (currWords.size() < otherWords.size()) {
                    boolean allContains = true;
                    for (String word : currWords) {
                        if (!otherWords.contains(word)) {
                            allContains = false;
                            break;
                        }
                    }
                    if (allContains) {
                        ans.remove(i);
                    }
                }
            }
        }
        return new ArrayList<>(ans);
    }
}