package com.leetcode.weekly.weekly189.second;

/*
句子的首字母大写
text 中的每个单词都用单个空格分隔。
请你重新排列 text 中的单词，使所有单词按其长度的升序排列。如果两个单词的长度相同，则保留其在原句子中的相对顺序。
 */

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Solution {
    public String arrangeWords(String text) {
        if (null == text || text.length() <= 1) {
            return text;
        }

        text = text.substring(0, 1).toLowerCase() + text.substring(1);
        String[] words = text.split("\\s");

        Holder[] arr = new Holder[words.length];
        for (int i = 0; i < words.length; i++) {
            arr[i] = new Holder(words[i], i);
        }
        Arrays.sort(arr, (o1, o2) -> {
            if (o1.word.length() > o2.word.length()) {
                return 1;
            } else if (o1.word.length() < o2.word.length()) {
                return -1;
            } else {
                return o1.index > o2.index ? 1 : -1;
            }
        });

        List<String> sortedWords = Arrays.stream(arr).map(h -> h.word).collect(Collectors.toList());
        String res = String.join(" ", sortedWords);
        return res.substring(0, 1).toUpperCase() + res.substring(1);
    }

    private static class Holder {
        String word;
        int index;

        public Holder(String word, int index) {
            this.word = word;
            this.index = index;
        }
    }
}